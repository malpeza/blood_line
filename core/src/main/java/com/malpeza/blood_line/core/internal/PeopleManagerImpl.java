/*
 * Copyright (c) 2015, 2015, Malpeza and/or its affiliates. 
 * All rights reserved. Use is subject to license terms. 
 */

package com.malpeza.blood_line.core.internal;

import com.malpeza.blood_line.core.PeopleManager;
import com.malpeza.blood_line.core.Person;

public class PeopleManagerImpl implements PeopleManager {

	private Object repository;

	public void register(Person toRegister) {
		if (this.repository == null) {
			throw new IllegalStateException("PeopleRepository is required to attend this message.");
		}
		
		if (toRegister == null) {
			throw new IllegalArgumentException("Person to register can not be null.");
		}
	}

	public void setRepository(Object repository) {
		this.repository = repository;
	}
}
