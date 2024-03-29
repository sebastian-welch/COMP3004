package view.internals.menu;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import network.packet.PlayerPacket;
import config.Config;
import model.ViewModel;

public class ServerMenuView extends JInternalFrame{
	
	private static final long serialVersionUID = 3742758020392137899L;

	
	ViewModel lModel;
	
	JLabel[] lPlayerNumberLabel;
	JLabel[] lPlayerNameLabel;
	JButton[] lKickPlayerButton;
	
	String[] lPlayers;
	int lCurrentPlayers;
	
	public ServerMenuView(ViewModel aModel){
		super("Server",false,false,false,true);
		
		lModel = aModel;
		
		lPlayers = new String[Config.lMaxPlayers];
		lPlayerNumberLabel = new JLabel[Config.lMaxPlayers];
		lPlayerNameLabel = new JLabel[Config.lMaxPlayers];
		lKickPlayerButton = new JButton[Config.lMaxPlayers];
		
		lCurrentPlayers = 0;
		
		
		
		int xSize = 400;
		int ySize = 400;
		
		
		setPreferredSize(new Dimension(xSize,ySize));
		setSize(xSize,ySize);
		
		setLocation(0, 0);
		
		
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		//Content
		
		
		for(int i = 0; i < Config.lMaxPlayers; i++){
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = .2;
			c.weighty = 1;
			c.gridx = 0;
			c.gridy = i;
			c.insets = new Insets(0,10,0,0);
			lPlayerNumberLabel[i] = new JLabel("Player "+(i+1));
			add(lPlayerNumberLabel[i], c);
			
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = .6;
			c.weighty = 1;
			c.gridx = 1;
			c.gridy = i;
			c.insets = new Insets(0,0,0,0);
			lPlayerNameLabel[i] = new JLabel("Open");
			add(lPlayerNameLabel[i], c);
			
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = .2;
			c.weighty = 1;
			c.gridx = 2;
			c.gridy = i;
			c.insets = new Insets(0,0,0,10);
			lKickPlayerButton[i] = new JButton("Kick");
			lKickPlayerButton[i].setEnabled(false);
			add(lKickPlayerButton[i], c);
			
		}
		lKickPlayerButton[0].setVisible(false);
		


		
		
		createButtonListeners();
	}

	protected void createButtonListeners(){
		
		

		
		
	}
	
	
	public void newClient(PlayerPacket aClientPacket){
		String lClientName = aClientPacket.getNickname();
		lPlayers[lCurrentPlayers] = lClientName;
		lPlayerNameLabel[lCurrentPlayers].setText(lClientName);
		lCurrentPlayers++;
		
	}
}
