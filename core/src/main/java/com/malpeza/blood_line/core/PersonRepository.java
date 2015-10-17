/*
 * Copyright (c) 2015, 2015, Malpeza and/or its affiliates. 
 * All rights reserved. Use is subject to license terms. 
 */

/**
 * 
 */
package com.malpeza.blood_line.core;

/**
 * @author Lorenzo Solano Martínez <lsolano@malpeza.com>
 *
 */
public interface PersonRepository {

	void add(final Person toRegister);

	boolean has(final String email);

	Person retrieve(final String email);
}
