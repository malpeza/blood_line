/*
 * Copyright (c) 2015, 2015, Malpeza and/or its affiliates. 
 * All rights reserved. Use is subject to license terms. 
 */

package com.malpeza.blood_line.core;

import java.util.Arrays;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import com.malpeza.blood_line.core.exceptions.DuplicatedEntityException;
import com.malpeza.blood_line.core.internal.InMemoryPersonRepository;

public class RegisterPersonTests {

	@Rule
	public final ExpectedException thrown = ExpectedException.none();

	@Rule
	public final Timeout globalTimeout = Timeout.millis(20);

	@Test
	public void register_person_without_repository_should_throw_exception() {
		thrown.expect(IllegalStateException.class);
		thrown.expectMessage("PeopleRepository is required");

		final PeopleManager peopleManager = EntitiesFactory.createPeopleManager();
		Person peter = new Person("Peter", "Parker", "peter@dummy.com");

		peopleManager.register(peter);
	}

	@Test
	public void register_null_person_should_throw_exception() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("can not be null");

		final PeopleManager peopleManager = EntitiesFactory.createPeopleManager();
		peopleManager.setRepository(new InMemoryPersonRepository());

		peopleManager.register(null);
	}

	@Test
	public void register_none_should_throw_exception() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("invalid key");

		final PeopleManager peopleManager = EntitiesFactory.createPeopleManager();
		peopleManager.setRepository(new InMemoryPersonRepository());

		peopleManager.register(Person.None);
	}

	@Test
	public void register_person() {
		final PeopleManager peopleManager = EntitiesFactory.createPeopleManager();
		peopleManager.setRepository(new InMemoryPersonRepository());

		peopleManager.register(new Person("Peter", "Parker", "peter@dummy.com"));
	}

	@Test
	public void register_same_person_twice_should_trhow_exception() {
		thrown.expect(DuplicatedEntityException.class);
		thrown.expectMessage("Duplicated Person entry");

		final PeopleManager peopleManager = EntitiesFactory.createPeopleManager();
		peopleManager.setRepository(new InMemoryPersonRepository());

		final Person peter = new Person("Peter", "Parker", "peter@dummy.com");

		registerAll(peopleManager, peter, peter);
	}

	private void registerAll(final PeopleManager peopleManager, final Person... people) {
		Arrays.stream(people).forEach(person -> peopleManager.register(person));
	}

	@Test
	public void register_two_people_with_same_email_should_trhow_exception() {
		thrown.expect(DuplicatedEntityException.class);
		thrown.expectMessage("Duplicated Person entry");

		final PeopleManager peopleManager = EntitiesFactory.createPeopleManager();

		peopleManager.setRepository(new InMemoryPersonRepository());
		final Person peter = new Person("Peter", "Parker", "peter@dummy.com");
		final Person fakePeter = new Person("Copy", "Cat", "peter@dummy.com");

		registerAll(peopleManager, peter, fakePeter);
	}
}
