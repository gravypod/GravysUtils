package com.gravypod.Utils.Sanitization;

public interface ISanitize {
	
	/**
	 * Sanitize all characters in a string
	 * 
	 * @param s
	 * @return
	 * 
	 */
	String sanitize(String s);
	
	/**
	 * Sanitize the character
	 * 
	 * @param c
	 * @return
	 */
	String sanitize(char c);
	
}
