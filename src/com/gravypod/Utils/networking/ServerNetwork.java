package com.gravypod.Utils.networking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerNetwork extends Thread implements INetwork {
	
	private final ServerSocket ss;
	
	private NetworkCode executionCode;
	
	private boolean continueRunning = true;
	
	/**
	 * Listen on one given IP
	 * 
	 * @param ip
	 *            - IP to listen on
	 * @param port
	 *            - Port to listen on
	 * @throws IOException
	 */
	public ServerNetwork(final String ip, final int port) throws IOException {
	
		ss = new ServerSocket();
		ss.bind(new InetSocketAddress(ip, port));
		
	}
	
	/**
	 * Listen on all IPs
	 * 
	 * @param port
	 *            - Port to listen on
	 * @throws IOException
	 * 
	 */
	public ServerNetwork(final int port) throws IOException {
	
		ss = new ServerSocket();
		ss.bind(new InetSocketAddress("0.0.0.0", port));
	}
	
	@Override
	public void giveCodeAndRun(final NetworkCode code) {
		
		executionCode = code;
		start();
		
	}
	
	@Override
	public void run() {
	
		while(continueRunning) {
			
			Socket connection = null;
			
			try {
				connection = ss.accept();
				connection.setTcpNoDelay(true);
				executionCode.setStreams(connection.getInputStream(), connection.getOutputStream());
			} catch (final IOException e) {
				e.printStackTrace();
			}
			
			executionCode.run();
		}
		
	}
	
	/**
	 * Set to false to stop the network thread
	 * 
	 * @param continueRunning
	 *            - Bool, true or false. True lets us run, false stops us. We
	 *            are false by default
	 */
	public void setContinueRunning(final boolean continueRunning) {
	
		this.continueRunning = continueRunning;
	}
	
}
