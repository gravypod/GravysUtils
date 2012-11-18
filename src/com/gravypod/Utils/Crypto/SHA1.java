package com.gravypod.Utils.Crypto;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1 {
	
	static MessageDigest md;
	
	static {
		try {
			SHA1.md = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public static String encrypte(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
	
		byte[] sha1hash = new byte[40];
		
		md.update(text.getBytes("iso-8859-1"), 0, text.length());
		
		sha1hash = md.digest();
		
		return convToHex(sha1hash);
		
	}
	
	private static String convToHex(byte[] data) { // TODO: Move to a better place
	
		StringBuilder buf = new StringBuilder();
		
		for (int i = 0; i < data.length; i++) {
			
			int halfbyte = (data[i] >>> 4) & 0x0F;
			
			int two_halfs = 0;
			
			do {
				
				if ((0 <= halfbyte) && (halfbyte <= 9))
					buf.append((char) ('0' + halfbyte));
				else
					buf.append((char) ('a' + (halfbyte - 10)));
				
				halfbyte = data[i] & 0x0F;
				
			} while(two_halfs++ < 1);
			
		}
		
		return buf.toString();
	}
	
}
