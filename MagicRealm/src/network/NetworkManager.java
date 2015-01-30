package network;

import model.ViewModel;
import network.client.Client;
import network.client.ClientApp;
import network.server.ServerApp;

public class NetworkManager {
	
	private ServerApp lServerApp;
	
	private ViewModel lViewModel;
	
	Thread lServerThread;
	
	public NetworkManager(){
	}
	
	
	public void openServer(int aPortNumber){
		lServerApp = new ServerApp(aPortNumber, this);
		lServerThread = new Thread(lServerApp);
		lServerThread.start();
	}
	
	
	public void setViewModel(ViewModel aViewModel){
		lViewModel = aViewModel;
	}
	
	
	public void notifyNewClient(String aClientName){
		lViewModel.notifyMenuNewClient(aClientName);
	}
	
	public void closeServer(){
		if(lServerThread.isAlive()){
			lServerThread.interrupt();
		}
	}
	
	public boolean connectToServer(String aIpAddress, int aPortNumber){
		Client c = ClientApp.connect(aIpAddress, aPortNumber);
		
		if (c == null){
			return false;
		}
		return true;
	}
	

}
