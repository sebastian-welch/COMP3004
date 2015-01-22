package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {

	private Socket socket;
	ObjectOutputStream lOutputStream;
	ObjectInputStream lInputStream;
	boolean lIsStreamsOpened;
	
	public Client(Socket s)
	{
		socket = s;
		lIsStreamsOpened = false;
	}
	
	@Override
	public void run()
	{
		
		try
		{
			lOutputStream = new ObjectOutputStream(socket.getOutputStream());
			lInputStream = new ObjectInputStream(socket.getInputStream());	
			lIsStreamsOpened = true;
			
			while (true)
			{						
				Thread.sleep(1000);
				sendTest();
			}
			
		}
		catch (Exception e)
		{
			//Dump stack
			System.out.println("Error in Client Run");
			e.printStackTrace();
			try{
				socket.close();
			}catch(Exception o){
				//stuff 
			}
		} 
	}
	
	public boolean sendTest(){
		try{
			String lRequest = "Server Test";
			lOutputStream.writeObject(lRequest);
			lOutputStream.reset();	
			
			System.out.println((String)lInputStream.readObject());
		}
		catch (Exception e)
		{
			//Dump stack
			System.out.println("Client Error:");
			e.printStackTrace();
		}
		return false;
	}

	
	
	public boolean isStreamsOpened(){
		return lIsStreamsOpened;			
	}
	
	

}
