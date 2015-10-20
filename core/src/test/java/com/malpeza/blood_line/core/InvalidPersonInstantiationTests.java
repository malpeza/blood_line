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
public class InvalidPersonInstantiationTests {
	@DataPoints
	public static final String[] INVALID_STRING_PROPS = { null, "", "   ", "\n", "\t", "\n\r", "\r\n", "\r" };

	@Rule
	public final ExpectedException thrown = ExpectedException.none();
	
	@Rule
	public final Timeout globalTimeout = Timeout.millis(50);

	@Theory
	public void create_person_with_invalid_fields(final String name, final String lastName, final String email) {
		thrown.expect(IllegalArgumentException.class);

		new Person(name, lastName, email);
	}
	
	@Theory
	public void create_person_with_invalid_bloodType() {
		thrown.expect(IllegalArgumentException.class);

		new Person("peter", "parker", "p.parker@comics.com", null);
	}
}
