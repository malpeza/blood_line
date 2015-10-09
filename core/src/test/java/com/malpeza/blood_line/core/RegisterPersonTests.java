/*
 * Copyright (c) 2015, 2015, Malpeza and/or its affiliates. 
 * All rights reserved. Use is subject to license terms. 
 */

package com.malpeza.blood_line.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class RegisterPersonTests {

	@Test(expected=IllegalStateException.class)
	public void register_person_without_repository() {
		PeopleManager peopleManager = EntitiesFactory.createPeopleManager();
		Person peter = new Person("Peter", "Parker", "peter@dummy.com");
		peopleManager.register(peter);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void register_null_person() throws Exception {
		PeopleManager peopleManager = EntitiesFactory.createPeopleManager();
		peopleManager.setRepository(new Object());
		peopleManager.register(null);
	}
}
