package view.internals.menu;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import config.Config;
import model.ViewModel;

public class JoinGameView extends JInternalFrame{
	
	private static final long serialVersionUID = -2996765842795567425L;

	JTextField lPortNumberField;
	JTextField lIpAddressField;
	JLabel lPortNumberLabel;
	JLabel lIpAddressLabel;
	
	JTextField lNicknameField;
	JLabel lNicknameLabel;
	
	JButton lConnectButton;
	JButton lMainMenuButton;
	
	ViewModel lModel;
	
	
	public JoinGameView(ViewModel aModel){
		super("Join Game",false,false,false,true);
		
		lModel = aModel;
		
		
		Dimension lScreenSize = lModel.getScreenDimensions();
		
		int xScreen = (int)lScreenSize.getWidth();
		int yScreen = (int)lScreenSize.getHeight();
		
		int xSize = 300;
		int ySize = 400;
		
		
		setPreferredSize(new Dimension(xSize,ySize));
		setSize(xSize,ySize);
		
		setLocation((xScreen/2)-(xSize/2), (yScreen/2)-(ySize/2));
		
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		//Content
		
		lPortNumberLabel = new JLabel("Port Number:");
		c.weightx = .2;
		c.weighty = 1.0;
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20,10,0,5);
		add(lPortNumberLabel, c);
		
		lPortNumberField = new JTextField(Integer.toString(Config.lPort));
		c.weightx = .8;
		c.weighty = 1.0;
		c.gridx = 1;
		c.gridy = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20,0,0,10);
		add(lPortNumberField, c);
		
		lIpAddressLabel = new JLabel("IP Address:");
		c.weightx = .2;
		c.weighty = 1.0;
		c.gridx = 0;
		c.gridy = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0,10,0,5);
		add(lIpAddressLabel, c);
		
		lIpAddressField = new JTextField(Config.lIpAddress);
		c.weightx = .8;
		c.weighty = 1.0;
		c.gridx = 1;
		c.gridy = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0,0,0,10);
		add(lIpAddressField, c);
		
		
		lNicknameLabel = new JLabel("Nickname:");
		c.weightx = .2;
		c.weighty = 1.0;
		c.gridx = 0;
		c.gridy = 2;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0,10,0,5);
		add(lNicknameLabel, c);
		
		lNicknameField = new JTextField("");
		c.weightx = .8;
		c.weighty = 1.0;
		c.gridx = 1;
		c.gridy = 2;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0,0,0,10);
		add(lNicknameField, c);
		
		
		lConnectButton = new JButton("Connect");
		lConnectButton.setEnabled(false);
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0,30,0,30);
		add(lConnectButton, c);
		
		lMainMenuButton = new JButton("Main Menu");
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(150,30,0,30);
		add(lMainMenuButton, c);
		
		
		createButtonListeners();
		createFieldListeners();
	}
	
	
	protected void createButtonListeners(){
		
		lMainMenuButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    lModel.requestMainMenu();
		    dispose();
		  }
		});
		
		
		lConnectButton.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
			    lModel.connectToServer(lIpAddressField.getText(), Integer.parseInt(lPortNumberField.getText()), lNicknameField.getText());
			    dispose();
			  }
			});
		
		
	}
	
	protected void createFieldListeners(){
		lNicknameField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				fieldChanged();
			}
			public void removeUpdate(DocumentEvent e) {
				fieldChanged();
				}
				public void insertUpdate(DocumentEvent e) {
					fieldChanged();
				}

				public void fieldChanged() {
					if (lNicknameField.getText().equals("")){
						lConnectButton.setEnabled(false);
					}
					else {
						lConnectButton.setEnabled(true);
						}

				}
			}
		);
	}

}
