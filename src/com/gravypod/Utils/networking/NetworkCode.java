package com.gravypod.Utils.networking;

import java.io.InputStream;
import java.io.OutputStream;

public interface NetworkCode extends Runnable {
	
	/**
	 * Set steams from every connection
	 * 
	 * @param is
	 *            - Input stream of every connection
	 * @param os
	 *            - Output stream of every connection
	 */
	void setStreams(InputStream is, OutputStream os);
	
}
