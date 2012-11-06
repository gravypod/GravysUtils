package com.gravypod.Utils.networking;

import java.net.InetSocketAddress;
import java.net.Proxy;

public class ProxyCreation {
	
	/**
	 * Easy proxy creation
	 * 
	 * @param proxyIP
	 *            - the IP to connect to
	 * @param proxyPort
	 *            - the port of the proxy
	 * @param type
	 *            - the type of proxy from Proxy.Type's enum
	 * @return
	 */
	public static Proxy createProxy(final String proxyIP, final int proxyPort, final Proxy.Type type) {
	
		return new Proxy(type, new InetSocketAddress(proxyIP, proxyPort));
		
	}
	
}
