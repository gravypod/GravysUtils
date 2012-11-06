package com.gravypod.Utils.Regex;

import java.util.regex.Pattern;

public class PatternBuilder {
	
	final StringBuilder pattern;
	
	public PatternBuilder() {
	
		pattern = new StringBuilder();
	}
	
	/**
	 * Starting with.
	 * 
	 * @return
	 */
	public PatternBuilder atBegining() {
	
		pattern.append("^");
		return this;
	}
	
	/**
	 * Ends with.
	 * 
	 * @return
	 */
	public PatternBuilder atEnd() {
	
		pattern.append("$");
		return this;
	}
	
	/**
	 * Anything but newline.
	 * 
	 * @return
	 */
	public PatternBuilder anything() {
	
		pattern.append(".");
		return this;
	}
	
	/**
	 * Anything inside of a '[]'.
	 * 
	 * @return
	 */
	public PatternBuilder anythingBrackets() {
	
		pattern.append("[...]");
		return this;
	}
	
	public PatternBuilder beginingOfString() {
	
		pattern.append("\\A");
		return this;
	}
	
	public PatternBuilder endOfString() {
	
		pattern.append("\\z");
		return this;
	}
	
	public PatternBuilder endOfStringNoEndline() {
	
		pattern.append("\\Z");
		return this;
	}
	
	public PatternBuilder words() {
	
		pattern.append("\\w");
		return this;
	}
	
	public PatternBuilder nonWords() {
	
		pattern.append("\\W");
		return this;
	}
	
	public PatternBuilder whiteSpace() {
	
		pattern.append("\\s");
		return this;
	}
	
	public PatternBuilder nonWhiteSpace() {
	
		pattern.append("\\S");
		return this;
	}
	
	public PatternBuilder digits() {
	
		pattern.append("\\d");
		return this;
	}
	
	public PatternBuilder nonDigits() {
	
		pattern.append("\\D");
		return this;
	}
	
	public PatternBuilder endLine() {
	
		pattern.append("\\n");
		return this;
	}
	
	public PatternBuilder tab() {
	
		pattern.append("\\t");
		return this;
	}
	
	public PatternBuilder append(String s) {
	
		pattern.append(s);
		return this;
	}
	
	public Pattern make() {
	
		return Pattern.compile(pattern.toString());
		
	}
	
	@Override
	public String toString() {
	
		return pattern.toString();
	}
	
}
