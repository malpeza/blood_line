/*
 * Copyright (c) 2015, 2015, Malpeza and/or its affiliates. 
 * All rights reserved. Use is subject to license terms. 
 */

package com.malpeza.blood_line.core;

import java.util.Set;

public interface DonorManager {

	void setDonorRepository(final DonorRepository repo);

	Set<Person> findDonorsWithExactBloodType(final BloodType bloodType);

	void register(final Person donor);

	int getCurrentDonorsCount();

}
