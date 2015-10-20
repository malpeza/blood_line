/*
 * Copyright (c) 2015, 2015, Malpeza and/or its affiliates. 
 * All rights reserved. Use is subject to license terms. 
 */

package com.malpeza.blood_line.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Set;

import org.junit.Test;

import com.malpeza.blood_line.core.internal.InMemoryDonorRepository;

public class FindMatchingDonorTests {

	/*
	 * ABO blood group system: A, B, AB, O
	 * Rh blood group system: Positive (+), Negative (-)
	 * */
	
	@Test
	public void find_donors_with_empty_repository_should_return_no_results() {
		final DonorManager manager = EntitiesFactory.createDonorManager();
		manager.setDonorRepository(new InMemoryDonorRepository());
		
		Set<Person> donors = manager.findDonorsWithExactBloodType(new BloodType(ABOGroup.A, RhesusGroup.Positive));
		
		assertTrue(donors.isEmpty());
	}
	
	@Test
	public void find_donors_should_return_all_actual_ones() {
		final DonorManager manager = EntitiesFactory.createDonorManager();
		manager.setDonorRepository(new InMemoryDonorRepository());
		
		final BloodType aPositive = new BloodType(ABOGroup.A, RhesusGroup.Positive);
		final Person peter = new Person("peter", "parker", "p.parker@comics.com", aPositive);
		final BloodType aNegative = new BloodType(ABOGroup.A, RhesusGroup.Negative);
		final Person mary = new Person("mary", "jane", "m.jane@comics.com", aNegative);
		registerAll(manager, peter, mary);
		
		final Set<Person> donors = manager.findDonorsWithExactBloodType(aPositive);
		
		assertEquals(1, donors.size());
		assertEquals(peter, donors.iterator().next());
		assertTrue(donors.contains(peter));
	}
	
	private void registerAll(final DonorManager manager, final Person... donors) {
		Arrays.stream(donors).parallel().forEach(donor -> manager.register(donor));
	}
	
	@Test
	public void count_all_donors() {
		final DonorManager manager = EntitiesFactory.createDonorManager();
		manager.setDonorRepository(new InMemoryDonorRepository());
		
		Arrays.stream(ABOGroup.values()).parallel().filter(abo -> ABOGroup.Unknown != abo).forEach(abo -> {
			Arrays.stream(RhesusGroup.values()).parallel().filter(rh -> rh != RhesusGroup.Unknown).forEach(rh -> {
				final String email = String.format("p.parker.%s.%s@comics.com", abo, rh);
				manager.register(new Person("peter", "parker", email, new BloodType(abo, rh)));
			});
		});
		
		assertEquals(8, manager.getCurrentDonorsCount());
		
		Arrays.stream(ABOGroup.values()).parallel().filter(abo -> ABOGroup.Unknown != abo).forEach(abo -> {
			Arrays.stream(RhesusGroup.values()).parallel().filter(rh -> rh != RhesusGroup.Unknown).forEach(rh -> {
				final BloodType type = new BloodType(abo, rh);
				final Set<Person> donors = manager.findDonorsWithExactBloodType(type);
				assertEquals(String.format("Must have exactly one donor with type %s.", type), 1, donors.size());
			});
		});
	}
}
