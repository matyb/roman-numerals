package com.pillar.conversions.utils;

public interface Converter<F,T> {

	T from(F f);
	F to(T t);
	
}
