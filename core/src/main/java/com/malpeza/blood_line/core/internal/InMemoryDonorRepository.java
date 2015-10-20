/*
 * Copyright (c) 2015, 2015, Malpeza and/or its affiliates. 
 * All rights reserved. Use is subject to license terms. 
 */

package com.malpeza.blood_line.core.internal;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.malpeza.blood_line.core.BloodType;
import com.malpeza.blood_line.core.DonorRepository;
import com.malpeza.blood_line.core.Person;

public class InMemoryDonorRepository implements DonorRepository {

	private final Map<String, Person> storage;

	public InMemoryDonorRepository() {
		this.storage = new ConcurrentHashMap<>();
	}

	@Override
	public void register(final Person donor) {
		this.storage.put(donor.getEmail(), donor);
	}

	@Override
	public Set<Person> findByBloodType(final BloodType bloodType) {
		final Stream<Person> donors = this.storage.values().parallelStream()
				.filter(donor -> bloodType.equals(donor.getBloodType()));

		return donors.collect(Collectors.toCollection(HashSet::new));
	}

	@Override
	public int currentCount() {
		return this.storage.size();
	}
}
