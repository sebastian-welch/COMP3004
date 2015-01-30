package model;

import java.awt.Dimension;

import network.NetworkManager;
import view.ViewManager;

public class ViewModel {

	ViewManager lViewManager;
	NetworkManager lNetworkManager;
	
	public ViewModel(NetworkManager aNetworkManager){
		
	}
	
	public Dimension getScreenDimensions(){
		return lViewManager.getScreenDimensions();
	}
	
	public void setViewManager(ViewManager aViewManager){
		lViewManager = aViewManager;
	}
	
	public void setNetworkManager(NetworkManager aNetworkManager){
		lNetworkManager = aNetworkManager;
	}
	
	
	public void requestNewGame(){
		lViewManager.newGame();
	}
	
	public void requestMainMenu(){
		lViewManager.newMenu();
	}
	
	public void requestJoinGame(){
		lViewManager.newJoinGame();
	}
	
	public void requestLoadGame(){
		lViewManager.newLoadGame();
	}
	
	public void requestServerMenu(int aPortNumber){
		lViewManager.newServerMenu();
		lNetworkManager.openServer(aPortNumber);
	}
	
	
	public void notifyMenuNewClient(String aClientName){
		lViewManager.notifyMenuNewClient(aClientName);
	}
	
	public void requestCloseServer(){
		lViewManager.closeServerMenu();
		lNetworkManager.closeServer();
	}
	
	public void connectToServer(String aIpAddress, int aPortNumber){
		boolean lSucceeded = lNetworkManager.connectToServer(aIpAddress, aPortNumber);
		
		if(lSucceeded){
			lViewManager.newClientLobby();
		}else{
			lViewManager.newJoinGame();
		}
	}
}
