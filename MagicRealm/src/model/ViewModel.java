package model;

import java.awt.Dimension;

import network.NetworkManager;
import network.client.Client;
import network.packet.PlayerPacket;
import view.ViewManager;

public class ViewModel {

	ViewManager lViewManager;
	NetworkManager lNetworkManager;
	boolean isServer;
	
	public ViewModel(NetworkManager aNetworkManager){
		isServer = false;
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
	
	public void requestServerMenu(int aPortNumber, String aNickName){
		lViewManager.newServerMenu();
		lNetworkManager.openServer(aPortNumber);
		isServer = true;
		boolean lSucceeded = lNetworkManager.connectToServer("localhost", aPortNumber, aNickName);
		
		System.out.println("Connected to self:" + lSucceeded);
	}
	
	
	public void notifyMenuNewClient(PlayerPacket aClientPacket){
		lViewManager.notifyMenuNewClient(aClientPacket);
	}
	
	public void requestCloseServer(){
		lViewManager.closeServerMenu();
		lNetworkManager.closeServer();
	}
	
	public void connectToServer(String aIpAddress, int aPortNumber, String aNickname){
		boolean lSucceeded = lNetworkManager.connectToServer(aIpAddress, aPortNumber, aNickname);
		
		if(lSucceeded){
			lViewManager.newClientLobby();
		}else{
			lViewManager.newJoinGame();
		}
	}
}