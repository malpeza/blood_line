/*
 * Copyright (c) 2015, 2015, Malpeza and/or its affiliates. 
 * All rights reserved. Use is subject to license terms. 
 */

/**
 * 
 */
package com.malpeza.blood_line.core.internal;

import java.util.Set;

import com.malpeza.blood_line.core.BloodType;
import com.malpeza.blood_line.core.DonorManager;
import com.malpeza.blood_line.core.DonorRepository;
import com.malpeza.blood_line.core.Person;

/**
 * @author Lorenzo Solano Martínez <lsolano@malpeza.com>
 *
 */
public final class DonorManagerImpl implements DonorManager {

	private DonorRepository repository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.malpeza.blood_line.core.DonorManager#setDonorRepository(com.malpeza.blood_line.core.DonorRepository)
	 */
	@Override
	public void setDonorRepository(final DonorRepository repo) {
		this.repository = repo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.malpeza.blood_line.core.DonorManager#findDonorsWithExactBloodType(com.malpeza.blood_line.core.BloodType)
	 */
	@Override
	public Set<Person> findDonorsWithExactBloodType(final BloodType bloodType) {
		return this.repository.findByBloodType(bloodType);
	}

	@Override
	public void register(final Person donor) {
		this.repository.register(donor);
	}

	@Override
	public int getCurrentDonorsCount() {
		return this.repository.currentCount();
	}
}
