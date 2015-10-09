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

	public Person(final String name, final String lastname, final String email) {
		if (Arrays.stream((new String[] { name, lastname, email })).anyMatch(property -> isNullOrEmpty(property))) {
			throw new IllegalArgumentException("Properties can not be null, empty or white space."); 
		}
	}
	
	private static boolean isNullOrEmpty(final String value) {
		return value == null || value.trim().isEmpty();
	}

}
