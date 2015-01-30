package network.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.ServerSocket;

import network.NetworkManager;
import config.Config;

public class ServerApp implements Runnable{

	int lPortNumber;
	NetworkManager lNetworkManager;
	
	public ServerApp(int aPortNumber, NetworkManager aNetworkManager){
		lPortNumber = aPortNumber;
		lNetworkManager = aNetworkManager;
	}
	
	public void run(){
	
		
		try{		
			int lOpenConnections = 0;
			ServerSocket lServer = new ServerSocket(lPortNumber);
			System.out.println("Waiting for connections on port " + lPortNumber);
		    
			while (!Thread.interrupted()){                                              
		    	Socket lNewSocket = lServer.accept();
		        
		    	System.out.println("Incoming connection from: " + lNewSocket.getLocalAddress().getHostName());
		        
		    	Server lNewServer = new Server(lNewSocket);
		    	Thread t = new Thread(lNewServer);
		    	t.start();
		    	System.out.println("Thread Created");
		    	
		    	lNetworkManager.notifyNewClient(lNewSocket.getLocalAddress().getHostName());

		    	lOpenConnections++;
		 	}
			
		}
		catch (Exception e)
		{
			System.out.println("Exception caught in network.server.ServerApp.java");
		}

		System.out.println("Closing Server");
	}
	

}
