package com.gravypod.Utils.Crypto;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	
	private static MessageDigest Md5Digest;
	
	static {
		try {
			Md5Digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public static String encrypt(String s) {
	
		Md5Digest.reset();
		Md5Digest.update(s.getBytes());
		return new BigInteger(1, Md5Digest.digest()).toString(16);
		
	}
}
