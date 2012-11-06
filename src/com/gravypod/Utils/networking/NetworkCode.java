package com.gravypod.Utils.networking;

import java.io.InputStream;
import java.io.OutputStream;

public interface NetworkCode extends Runnable {
	
	/**
	 * Sets input and output streams from the connection a thread recives
	 * 
	 * @param is
	 *            - sockets input stream
	 * @param os
	 *            - sockets output stream
	 */
	void setVars(InputStream is, OutputStream os);
	
}
