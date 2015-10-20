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
public class BloodType {

	public static final BloodType Unknown = new BloodType();
	
	private final ABOGroup aboGroup;
	private final RhesusGroup rhGroup;

	private BloodType() {
		this.aboGroup =ABOGroup.Unknown;
		this.rhGroup = RhesusGroup.Unknown;
	}

	public BloodType(final ABOGroup aboGroup, final RhesusGroup rhGroup) {
		if (aboGroup == null || rhGroup == null || aboGroup == ABOGroup.Unknown || rhGroup == RhesusGroup.Unknown) {
			throw new IllegalArgumentException("Groups can not be null.");
		}
		
		this.aboGroup = aboGroup;
		this.rhGroup = rhGroup;
	}

	public ABOGroup getAboGroup() {
		return aboGroup;
	}
	
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof BloodType) {
			return equals((BloodType) obj);
		}

		return false;
	}

	private boolean equals(final BloodType other) {
		return this.aboGroup == other.aboGroup && this.rhGroup == other.rhGroup;
	}

	@Override
	public int hashCode() {
		return this.aboGroup.hashCode();
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s=%s; %s=%s)", this.getClass().getSimpleName(), "aboGroup", this.aboGroup, "rhGroup", this.rhGroup);
	}
}
