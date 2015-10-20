/*
 * Copyright (c) 2015, 2015, Malpeza and/or its affiliates. 
 * All rights reserved. Use is subject to license terms. 
 */

package com.malpeza.blood_line.core;

import java.util.Set;

public interface DonorRepository {

	void register(final Person donor);

	Set<Person> findByBloodType(final BloodType bloodType);

	int currentCount();

}
