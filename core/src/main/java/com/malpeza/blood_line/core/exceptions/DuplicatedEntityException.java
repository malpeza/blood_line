/*
 * Copyright (c) 2015, 2015, Malpeza and/or its affiliates. 
 * All rights reserved. Use is subject to license terms. 
 */

package com.malpeza.blood_line.core.exceptions;

public class DuplicatedEntityException extends RuntimeException {
	private static final long serialVersionUID = -3724250207170775989L;
	
	public DuplicatedEntityException(String message) {
		super(message);
	}
}
