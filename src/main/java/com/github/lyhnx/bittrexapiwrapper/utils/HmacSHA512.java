package com.github.lyhnx.bittrexapiwrapper.utils;

import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import static java.lang.String.format;

/**
 * @author Lyhnx
 *
 *         Provides a static method to hash a given value
 */
public final class HmacSHA512 {

	private static final Log LOG = LogFactory.getLog(HmacSHA512.class);

	private HmacSHA512() {
	}

	/**
	 * Tries to create a hmac-SHA512 hash.
	 * 
	 * @param value
	 *            will be hashed
	 * @param secret
	 *            your secret key
	 * @return hashed uri or null if the process failed
	 */
	public static String hash(String value, String secret) {
		final String ALGORITHM = "HmacSHA512";
		final String CHARSET = "UTF-8";

		LOG.debug(format("Trying to hash %s using %s algorithm and %s charset", value, ALGORITHM, CHARSET));

		try {
			final Mac hmac = Mac.getInstance(ALGORITHM);
			final SecretKeySpec keySpec = new SecretKeySpec(secret.getBytes(Charset.forName(CHARSET)), ALGORITHM);
			hmac.init(keySpec);
			final byte[] hashBytes = hmac.doFinal(value.getBytes(Charset.forName(CHARSET)));
			final StringBuilder translatedDigest = new StringBuilder();
			for (byte b : hashBytes) {
				translatedDigest.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
			}

			return translatedDigest.toString();
		} catch (NoSuchAlgorithmException e) {
			LOG.error(format("%s algorithm does not exists", ALGORITHM), e);
		} catch (InvalidKeyException e) {
			LOG.error("Key used to hash is invalid. Please check your secret.", e);
		}

		return null;
	}

}
