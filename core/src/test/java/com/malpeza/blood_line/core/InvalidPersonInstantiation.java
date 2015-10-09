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
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class InvalidPersonInstantiation {
	@DataPoints
	public static final String[] INVALID_STRING_PROPS = { null, "", "   ", "\n", "\t", "\n\r", "\r\n", "\r" };

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Theory
	public void create_person_with_invalid_fields(String name, String lastName, String email) {
		thrown.expect(IllegalArgumentException.class);

		new Person(name, lastName, email);
	}

}
