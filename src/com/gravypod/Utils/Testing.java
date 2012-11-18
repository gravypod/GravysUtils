package com.gravypod.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.gravypod.Utils.networking.NetworkCode;
import com.gravypod.Utils.networking.ServerNetwork;

public class Testing {
	
	public static void main(String[] args) throws IOException {
	
		new ServerNetwork(99).giveCodeAndRun(new NetworkCode() {
			
			OutputStream os;
			
			@Override
			public void run() {
			
				try {
					os.write("Hello World".getBytes());
					os.flush();
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
			@Override
			public void setStreams(InputStream is, OutputStream os) {
			
				this.os = os;
				
			}
			
		});
		
	}
	
}
