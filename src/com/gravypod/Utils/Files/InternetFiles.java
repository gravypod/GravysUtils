package com.gravypod.Utils.Files;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.net.URL;

public class InternetFiles {
	
	/**
	 * Download a file from a URL
	 * 
	 * @param url
	 *            - URL we are downloading from
	 * @param dest
	 *            - File to download to
	 * @throws IOException
	 */
	public static void downloadFrom(final URL url, final File dest) throws IOException {
	
		InternetFiles.downloadFrom(url.openConnection().getInputStream(), dest);
	}
	
	/**
	 * Download a file from a URL with a proxy
	 * 
	 * @param url
	 *            - URL we are downloading from
	 * @param proxy
	 *            - proxy to connect to
	 * @param dest
	 *            - File to download to
	 * @throws IOException
	 */
	public static void downloadFrom(final URL url, final Proxy proxy, final File dest) throws IOException {
	
		InternetFiles.downloadFrom(url.openConnection(proxy).getInputStream(), dest);
	}
	
	/**
	 * Download a file from a Stream
	 * 
	 * @param stream
	 * @param dest
	 * @throws IOException
	 */
	public static void downloadFrom(final InputStream stream, final File dest) throws IOException {
	
		final InputStream in = stream;
		final ByteArrayOutputStream fout = new ByteArrayOutputStream();
		
		final byte[] buffer = new byte[1024];
		
		int n;
		
		while((n = in.read(buffer)) != -1) {
			
			fout.write(buffer, 0, n);
			
		}
		
		in.close();
		
		FileConversion.bytesToFile(fout.toByteArray(), dest);
		
	}
	
}
