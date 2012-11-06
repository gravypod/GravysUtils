package com.gravypod.Utils.networking;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientDirectConnection extends Thread implements INetwork {
	
	final Socket dest;
	
	NetworkCode executionCode;
	
	final InetAddress host;
	
	final int port;
	
	public ClientDirectConnection(InetAddress host, int port) throws IOException {
	
		this.dest = new Socket();
		this.host = host;
		this.port = port;
	}
	
	@Override
	public void giveCodeAndRun(NetworkCode code) {
	
		executionCode = code;
		this.start();
	}
	
	@Override
	public void run() {
	
		try {
			dest.connect(new InetSocketAddress(host, port));
			executionCode.setVars(dest.getInputStream(), dest.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			executionCode.run();
			
		}
		
	}
	
}
