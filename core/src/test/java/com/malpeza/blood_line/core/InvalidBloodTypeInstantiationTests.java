/*
 * Copyright (c) 2015, 2015, Malpeza and/or its affiliates. 
 * All rights reserved. Use is subject to license terms. 
 */

package com.malpeza.blood_line.core;

import org.junit.Rule;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class InvalidBloodTypeInstantiationTests {
	@DataPoints
	public static final ABOGroup[] INVALID_ABOGroup = { null, ABOGroup.Unknown };

	@DataPoints
	public static final RhesusGroup[] INVALID_RhesusGroup = { null, RhesusGroup.Unknown };

	@Rule
	public final ExpectedException thrown = ExpectedException.none();

	@Rule
	public final Timeout globalTimeout = Timeout.millis(50);

	@Theory
	public void create_blood_type_with_invalid_groups(final ABOGroup aboGroup, final RhesusGroup rhGroup) {
		thrown.expect(IllegalArgumentException.class);

		new BloodType(aboGroup, rhGroup);
	}
}
