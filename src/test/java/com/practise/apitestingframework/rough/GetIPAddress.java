package com.practise.apitestingframework.rough;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIPAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("IP address is: "+InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
