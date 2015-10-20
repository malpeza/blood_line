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
	private final BloodType bloodType;
	
	private Person() {
		this.email = "";
		this.bloodType = BloodType.Unknown;
	}
	
	public Person(final String name, final String lastname, final String email) {
		this(name, lastname, email, BloodType.Unknown);
	}

	public Person(final String name, final String lastname, final String email, final BloodType bloodType) {
		if (Arrays.stream((new String[] { name, lastname, email })).anyMatch(property -> isNullOrEmpty(property))) {
			throw new IllegalArgumentException("Properties can not be null, empty or white space.");
		}
		
		if (bloodType == null) {
			throw new IllegalArgumentException("Properties can not be null.");
		}

		this.email = email;
		this.bloodType = bloodType;
	}

	private static boolean isNullOrEmpty(final String value) {
		return value == null || value.trim().isEmpty();
	}

	public String getEmail() {
		return this.email;
	}
	
	public BloodType getBloodType() {
		return this.bloodType;
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
	
	@Override
	public int hashCode() {
		return this.bloodType.getAboGroup().hashCode();
	}
}
