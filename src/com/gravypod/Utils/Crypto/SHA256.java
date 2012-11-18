package com.gravypod.Utils.Crypto;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class SHA256 {
	
	static MessageDigest md;
	
	static {
		
		try {
	        md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
        }
		
	}
	
	public static String encrypt(String text) throws UnsupportedEncodingException {
		
		md.update(text.getBytes("UTF-8")); 
		
		byte[] digest = md.digest();
		
		return new String(digest);
		
	}
	
	
}
