/*
 * Copyright (c) 2015, 2015, Malpeza and/or its affiliates. 
 * All rights reserved. Use is subject to license terms. 
 */

package com.malpeza.blood_line.core;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import com.malpeza.blood_line.core.internal.InMemoryPersonRepository;

public class FindPersonTests {
	@Rule
	public final ExpectedException thrown = ExpectedException.none();
	
	@Rule
	public final Timeout globalTimeout = Timeout.millis(50);
	
	/*
	 * 1. Notfound => Person.None
	 * 2. Found => Must be equals 
	 * 3. ?*/
	
	@Test
	public void find_person_without_repository_should_throw_exception() {
		thrown.expect(IllegalStateException.class);
		thrown.expectMessage("PeopleRepository is required");
		
		final PeopleManager manager = EntitiesFactory.createPeopleManager();
		
		manager.findByEmail("p.parker@comics.com");
	}
	
	@Test
	public void test_find_non_existing_person_should_return_none() {
		final PeopleManager manager = EntitiesFactory.createPeopleManager();
		manager.setRepository(new InMemoryPersonRepository());
		
		assertEquals(Person.None, manager.findByEmail("p.parker@comics.com"));
	}
	
	@Test
	public void test_find_existing_person() {
		final PeopleManager manager = EntitiesFactory.createPeopleManager();
		manager.setRepository(new InMemoryPersonRepository());
		
		final Person peter = new Person("Peter", "Parker", "p.parker@comics.com");
		manager.register(peter);
		
		final Person peterCopy = new Person("Peter", "Parker", "p.parker@comics.com");
		assertTrue(peterCopy.equals(manager.findByEmail("p.parker@comics.com")));
	}
}
