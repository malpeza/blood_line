/*
 * Copyright (c) 2015, 2015, Malpeza and/or its affiliates. 
 * All rights reserved. Use is subject to license terms. 
 */

package com.malpeza.blood_line.core;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RegisterPersonTests {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void register_person_without_repository() {
		thrown.expect(IllegalStateException.class);
		thrown.expectMessage("PeopleRepository is required");

		PeopleManager peopleManager = EntitiesFactory.createPeopleManager();
		Person peter = new Person("Peter", "Parker", "peter@dummy.com");

		peopleManager.register(peter);
	}

	@Test
	public void register_null_person() throws Exception {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("can not be null");

		PeopleManager peopleManager = EntitiesFactory.createPeopleManager();

		peopleManager.setRepository(new Object());
		peopleManager.register(null);
	}
}
