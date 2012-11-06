package com.gravypod.Utils.networking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;

public class ClientProxyConnection extends Thread implements INetwork {
	
	final InetSocketAddress dest;
	
	final Proxy proxy;
	
	NetworkCode executionCode;
	
	/**
	 * Connect with a proxy
	 * 
	 * @param dest
	 *            - person you want to connect to.
	 * @param proxy
	 *            - Proxy we are using
	 */
	public ClientProxyConnection(final InetSocketAddress dest, final Proxy proxy) {
	
		this.dest = dest;
		this.proxy = proxy;
	}
	
	@Override
	public void giveCodeAndRun(final NetworkCode code) {
	
		executionCode = code;
		start();
	}
	
	@Override
	public void run() {
	
		Socket s = null;
		
		while(s == null) {
			
			try {
				
				s = new Socket(proxy);
				s.connect(dest);
				executionCode.setVars(s.getInputStream(), s.getOutputStream());
			} catch (final IOException e) {
				e.printStackTrace();
			} finally {
				executionCode.run();
			}
			
		}
		
	}
	
}
