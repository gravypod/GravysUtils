package com.gravypod.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;

import com.gravypod.Utils.networking.NetworkCode;
import com.gravypod.Utils.networking.ServerNetwork;

public class Testing {
	
	public static void main(String[] args) throws MalformedURLException, IOException {
	
		// Testing things inside the utils goes here
		
		new ServerNetwork(98).giveCodeAndRun(new NetworkCode() {
			
			OutputStream os;
			
			@Override
			public void run() {
			
				try {
					os.write("hello world".getBytes());
					os.flush();
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
			@Override
			public void setVars(InputStream is, OutputStream os) {
			
				this.os = os;
				
			}
			
		});
		
		while(true);
		
	}
	
}
