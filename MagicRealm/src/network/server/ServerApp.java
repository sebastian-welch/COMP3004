package network.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.ServerSocket;

import config.Config;

public class ServerApp implements Runnable{

	public void run(){
	
		
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
			System.out.println("Exception caught in mr.server.ServerApp.java");
		}

	}

}
