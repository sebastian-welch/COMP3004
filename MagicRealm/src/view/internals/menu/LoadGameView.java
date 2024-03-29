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

public class LoadGameView extends JInternalFrame{
	
	private static final long serialVersionUID = 3742758020392137899L;

	JButton lMenuButton;
	
	ViewModel lModel;
	
	public LoadGameView(ViewModel aModel){
		super("Load Game",false,false,false,true);
		
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
		
		lMenuButton = new JButton("Main Menu");
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 3;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0,30,0,30);
		add(lMenuButton, c);
		

		
		createButtonListeners();
	}

	protected void createButtonListeners(){
		
		
		lMenuButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    lModel.requestMainMenu();
		    dispose();
		  }
		});
		
		
	}
}
