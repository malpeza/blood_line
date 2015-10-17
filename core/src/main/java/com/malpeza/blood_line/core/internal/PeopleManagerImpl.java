/*
 * Copyright (c) 2015, 2015, Malpeza and/or its affiliates. 
 * All rights reserved. Use is subject to license terms. 
 */

package com.malpeza.blood_line.core.internal;

import com.malpeza.blood_line.core.PeopleManager;
import com.malpeza.blood_line.core.Person;
import com.malpeza.blood_line.core.PersonRepository;

public class PeopleManagerImpl implements PeopleManager {

	private PersonRepository repository;

	public void setRepository(PersonRepository repository) {
		this.repository = repository;
	}
	
	public void register(final Person toRegister) {
		checkDependencies();

		validateBeforeRegister(toRegister);

		this.repository.add(toRegister);
	}

	private void validateBeforeRegister(final Person toRegister) {
		if (toRegister == null) {
			throw new IllegalArgumentException("Person to register can not be null.");
		}
		
		if (Person.None.equals(toRegister)) {
			throw new IllegalArgumentException("Person has an invalid key (email).");
		}
	}

	@Override
	public Person findByEmail(final String email) {
		checkDependencies();
		
		return !this.repository.has(email) ? Person.None : this.repository.retrieve(email);
	}
	
	private void checkDependencies() {
		if (this.repository == null) {
			throw new IllegalStateException("PeopleRepository is required to attend this message.");
		}
	}
}
