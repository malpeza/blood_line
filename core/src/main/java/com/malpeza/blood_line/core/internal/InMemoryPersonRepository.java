/*
 * Copyright (c) 2015, 2015, Malpeza and/or its affiliates. 
 * All rights reserved. Use is subject to license terms. 
 */

package com.malpeza.blood_line.core.internal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.malpeza.blood_line.core.Person;
import com.malpeza.blood_line.core.PersonRepository;
import com.malpeza.blood_line.core.exceptions.DuplicatedEntityException;

public class InMemoryPersonRepository implements PersonRepository {

	private final Map<String, Person> storage;

	public InMemoryPersonRepository() {
		this.storage = new ConcurrentHashMap<>();
	}

	@Override
	public void add(final Person toRegister) {
		final String key = toRegister.getEmail();
		if (this.storage.containsKey(key)) {
			throw new DuplicatedEntityException(String.format("Duplicated Person entry '%s'.", key));
		}

		this.storage.put(key, toRegister);
	}

	@Override
	public boolean has(final String email) {
		return this.storage.containsKey(email);
	}

	@Override
	public Person retrieve(final String email) {
		return this.storage.get(email);
	}
}
