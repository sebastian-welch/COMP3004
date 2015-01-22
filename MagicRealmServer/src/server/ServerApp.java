package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.ServerSocket;

import config.Config;

public class ServerApp{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3476429851550188958L;
	

	public static void main(String[] args){
		
		
		
		try{		
			int lOpenConnections = 0;
			ServerSocket lServer = new ServerSocket(Config.lPort);
			System.out.println("Waiting for connections on port " + Config.lPort);
		    
			while (true){                                              
		    	Socket lNewSocket = lServer.accept();
		        
		    	System.out.println("Incoming connection from: " + lNewSocket.getLocalAddress().getHostName());
		        
		    	Server lNewServer = new Server(lNewSocket);
		    	Thread t = new Thread(lNewServer);
		    	t.start();
		    	System.out.println("Thread Created");

		    	lOpenConnections++;
		 	}
			
		}
		catch (Exception e)
		{
			System.out.println("Error in MagicRealmServer ServerApp.java");
		}

	}

}
