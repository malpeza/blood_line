/*
 * Copyright (c) 2015, 2015, Malpeza and/or its affiliates. 
 * All rights reserved. Use is subject to license terms. 
 */

/**
 * 
 */
package com.malpeza.blood_line.core;

import java.util.Arrays;

/**
 * @author Lorenzo Solano Martínez <lsolano@malpeza.com>
 *
 */
public class Person {
	public static final Person None = new Person();
	
	private final String email;
	
	private Person() {
		this.email = "";
	}
	
	public Person(final String name, final String lastname, final String email) {
		if (Arrays.stream((new String[] { name, lastname, email })).anyMatch(property -> isNullOrEmpty(property))) {
			throw new IllegalArgumentException("Properties can not be null, empty or white space.");
		}

		this.email = email;
	}

	private static boolean isNullOrEmpty(final String value) {
		return value == null || value.trim().isEmpty();
	}

	public String getEmail() {
		return this.email;
	}
	
	@Override
	public boolean equals(final Object obj) {
		if (obj == this) {
			return true;
		}
		
		if (obj instanceof Person) {
			return equals((Person)obj);
		}
		
		return false;
	}
	
	private boolean equals(final Person other) {
		return this.email.equals(other.email);
	}
}
