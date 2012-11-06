package com.gravypod.Utils.Sanitization;

public class HTMLSanitize implements ISanitize {
	
	@Override
	public String sanitize(String s) {
	
		StringBuilder sb = new StringBuilder();
		
		for (char toSanitize : s.toCharArray()) {
			sb.append("&#").append((int) toSanitize).append(";");
		}
		
		return sb.toString();
	}
	
	@Override
	public String sanitize(char c) {
	
		return "&#" + (int) c + ";";
	}
	
}
