package com.henrique.workshopmongo.domain.enums;

public enum RestaurantEnum {
	ARABIC,
	JAPANESE,
	BRAZILIAN,
	MEXICAN;
	
	public static RestaurantEnum fromString(String type) {
		return valueOf(type.toUpperCase());
	}
}
