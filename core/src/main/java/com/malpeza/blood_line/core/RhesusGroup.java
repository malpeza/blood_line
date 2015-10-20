/*
 * Copyright (c) 2015, 2015, Malpeza and/or its affiliates. 
 * All rights reserved. Use is subject to license terms. 
 */

package com.malpeza.blood_line.core;

public enum RhesusGroup {
	Positive("+"), Negative("-"), Unknown("");
	
	private final String sign;

	private RhesusGroup(final String sign){
		this.sign = sign;
	}
	
	public String getSign() {
		return sign;
	}
}
