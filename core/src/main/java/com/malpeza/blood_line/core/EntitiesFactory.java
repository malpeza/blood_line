/*
 * Copyright (c) 2015, 2015, Malpeza and/or its affiliates. 
 * All rights reserved. Use is subject to license terms. 
 */

package com.malpeza.blood_line.core;

import com.malpeza.blood_line.core.internal.PeopleManagerImpl;

/**
 * @author Lorenzo Solano Martínez <lsolano@malpeza.com>
 *
 */
public final class EntitiesFactory {

	private EntitiesFactory() {
		/* prevent instantiation */
	}

	public static PeopleManager createPeopleManager() {
		return new PeopleManagerImpl();
	}

}
