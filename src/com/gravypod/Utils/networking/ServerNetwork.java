package com.gravypod.Utils.networking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerNetwork extends Thread implements INetwork {
	
	private final ServerSocket ss;
	
	private NetworkCode executionCode;
	
	private boolean continueRunning;
	
	/**
	 * Listen on one given IP
	 * 
	 * @param ip
	 *            - IP to listen on
	 * @param port
	 *            - Port to listen on
	 * @throws IOException
	 */
	public ServerNetwork(String ip, int port) throws IOException {
	
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
	public ServerNetwork(int port) throws IOException {
	
		ss = new ServerSocket();
		ss.bind(new InetSocketAddress("0.0.0.0", port));
	}
	
	public void giveCodeAndRun(NetworkCode code) {
	
		executionCode = code;
		this.start();
	}
	
	@Override
	public void run() {
	
		while(continueRunning) {
			
			Socket connection = null;
			
			try {
				connection = ss.accept();
				executionCode.setVars(connection.getInputStream(), connection.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				
				executionCode.run();
			}
		}
		
	}
	
	/**
	 * Set to false to stop the network thread
	 * 
	 * @param continueRunning
	 *            - Bool, true or false. True lets us run, false stops us. We
	 *            are false by default
	 */
	public void setContinueRunning(boolean continueRunning) {
	
		this.continueRunning = continueRunning;
	}
	
}
