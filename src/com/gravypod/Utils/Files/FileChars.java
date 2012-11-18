package com.gravypod.Utils.Files;

public enum FileChars {
	
	/**
	 * Character that separates components of a file path. This is "/" on UNIX
	 * and "\" on Windows.
	 */
	fileSep(System.getProperty("file.separator")),
	
	/** Path separator character used in java.class.path */
	pathSep(System.getProperty("path.separator"));
	
	private final String fileChar;
	
	private FileChars(String s) {
	
		fileChar = s;
	}
	
	public String getChar() {
	
		return fileChar;
	}
	
}
