package view.internals.menu;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;

import model.ViewModel;

public class ServerMenuView extends JInternalFrame{
	
	private static final long serialVersionUID = 3742758020392137899L;

	JButton lLockServerButton;
	
	ViewModel lModel;
	
	public ServerMenuView(ViewModel aModel){
		super("Server",false,false,false,true);
		
		lModel = aModel;
		
		int xSize = 300;
		int ySize = 400;
		
		
		setPreferredSize(new Dimension(xSize,ySize));
		setSize(xSize,ySize);
		
		setLocation(0, 0);
		
		
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		//Content
		
		lLockServerButton = new JButton("Lock Server");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(0,30,0,30);
		add(lLockServerButton, c);
		

		
		createButtonListeners();
	}

	protected void createButtonListeners(){
		
		
		lLockServerButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    dispose();
		  }
		});
		
		
	}
}
