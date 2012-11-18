package com.gravypod.Utils.Files;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileConversion {
	
	/**
	 * Turn a file into bytes
	 * 
	 * @param file
	 *            - File to read
	 * @return - Returns an empty string byte[] if file is not found
	 */
	public static byte[] read(final File file) {
	
		if (file != null && file.exists() && file.canRead() && !file.isDirectory()) {
			final byte[] buffer = new byte[4096];
			
			final ByteArrayOutputStream ous = new ByteArrayOutputStream();
			
			InputStream ios = null;
			try {
				ios = new FileInputStream(file);
			} catch (final FileNotFoundException e) {
				return "".getBytes();
			}
			
			int read = 0;
			
			try {
				
				while((read = ios.read(buffer)) != -1) {
					ous.write(buffer, 0, read);
				}
				
				if (ous != null) {
					
					ous.close();
					
				}
				
				if (ios != null) {
					ios.close();
				}
				
			} catch (final IOException e) {
				return "".getBytes();
			}
			
			return ous.toByteArray();
			
		} else {
			return "".getBytes();
		}
		
	}
	
	/**
	 * Convert a string to a file.
	 * 
	 * @param fileContents
	 *            - String that will be turned into a file
	 * @param file
	 *            - File to put the data into
	 * @throws IOException
	 */
	public static void stringToFile(final String fileContents, final File file) throws IOException {
	
		FileConversion.bytesToFile(fileContents.getBytes(), file);
	}
	
	/**
	 * Writes the contents of a byte[] to a file.
	 * 
	 * @param source
	 *            - Byte[] to write.
	 * @param file
	 *            - File to write to.
	 * @throws IOException
	 */
	public static void bytesToFile(final byte[] source, final File file) throws IOException {
	
		final FileOutputStream out = new FileOutputStream(file);
		
		out.write(source);
		
		out.close();
		
	}
	
	/**
	 * Converts a file to a String
	 * 
	 * @param file
	 *            - The file you want the contents of.
	 * @return
	 */
	public static String fileToString(final File file) {
	
		if (file != null && file.exists() && file.canRead() && !file.isDirectory()) {
			final byte[] buffer = new byte[4096];
			
			final ByteArrayOutputStream ous = new ByteArrayOutputStream();
			
			InputStream ios = null;
			try {
				ios = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				return "";
			}
			
			int read = 0;
			
			try {
				
				while((read = ios.read(buffer)) != -1) {
					ous.write(buffer, 0, read);
				}
				
				if (ous != null) {
					
					ous.close();
					
				}
				
				if (ios != null) {
					ios.close();
				}
				
			} catch (IOException e) {
				return "";
			}
			
			return ous.toString();
			
		} else {
			return "";
		}
		
	}
	
}
