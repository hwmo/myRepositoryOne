package com.sxt.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyBIOServer {
	public static void main(String[] args) {
		int port = genPort(args);
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(port);
			System.out.println("Server started.");
			while(true){
				Socket socket = server.accept();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static int genPort(String[] args){
		int port = 9999;
		if(args.length > 0){
			try{
				port = Integer.parseInt(args[0]);
			}catch(NumberFormatException e){
				return port;
			}
		}
		return port;
	}
}
