package com.gravypod.Utils.networking;

interface INetwork {
	
	/**
	 * Give the NetworkCode to run every time we get a connection
	 * 
	 * @param code
	 *            - Class that implements
	 *            com.gravypod.Utils.networking.NetworkCode
	 */
	void giveCodeAndRun(NetworkCode code);
	
}
