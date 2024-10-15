package com.omnicon.common.util;

import java.util.UUID;

public class KeyGenerator {

	public static String generateUUIDKey() {
		return UUID.randomUUID().toString();
	}

}
