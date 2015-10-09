/*
 * Copyright (c) 2015, 2015, Malpeza and/or its affiliates. 
 * All rights reserved. Use is subject to license terms. 
 */

package com.malpeza.blood_line.core;

import org.junit.Rule;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class InvalidPersonInstantiation {
	private static final String[] INVALID_STRING_PROPS = { null, "", "   " };

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Theory
	public void create_person_with_invalid_fields(@TestedOn(ints = { 0, 1, 2 }) int nameValueIndex,
			@TestedOn(ints = { 0, 1, 2 }) int lastNameValueIndex, @TestedOn(ints = { 0, 1, 2 }) int emailValueIndex) {
		String name = INVALID_STRING_PROPS[nameValueIndex];
		String lastName = INVALID_STRING_PROPS[lastNameValueIndex];
		String email = INVALID_STRING_PROPS[emailValueIndex];

		thrown.expect(IllegalArgumentException.class);

		new Person(name, lastName, email);
	}

}
