package com.henrique.workshopmongo.domain.enums;

public enum RestaurantEnum {
	ARABE,
	JAPONESA,
	BRAZILEIRA,
	MEXICANA;

	public static RestaurantEnum fromString(String type) {
		return valueOf(type.toUpperCase());
	}
}
