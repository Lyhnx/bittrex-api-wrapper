package com.github.lyhnx.bittrex.utils;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.github.lyhnx.bittrexapiwrapper.utils.HmacSHA512;

public class HmacSHA512Test {

	@Test
	public void hashValueShouldBeCorrect() {
		final String value = "My name is";
		final String secret = "350befd97b8ae2512e5b7bc";
		
		// Generated @https://www.liavaag.org
		final String expected = "d372c92d1ff793684625834effdb16f4ccb35160e95d1998d2db4307a9ead45b2706b93f8051af00196ebb3e72f29c6af7ee112617aff56f3ec5407252b9df90";
		assertEquals("Hashvalues should be equal", expected, HmacSHA512.hash(value, secret));
	}

}
