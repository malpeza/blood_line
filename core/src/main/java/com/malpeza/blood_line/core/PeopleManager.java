/*
 * Copyright (c) 2015, 2015, Malpeza and/or its affiliates. 
 * All rights reserved. Use is subject to license terms. 
 */

package com.malpeza.blood_line.core;

/**
 * @author Lorenzo Solano Martínez <lsolano@malpeza.com>
 *
 */
public interface PeopleManager {

	void register(final Person toRegister);

	void setRepository(final PersonRepository repository);

	Person findByEmail(final String email);
}
