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

public class MenuView extends JInternalFrame{
	
	private static final long serialVersionUID = 3742758020392137899L;

	JButton lNewGameButton;
	JButton lJoinGameButton;
	JButton lLoadGameButton;
	JButton lExitButton;
	
	ViewModel lModel;
	
	public MenuView(ViewModel aModel){
		super("Menu",false,false,false,true);
		
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
		
		lNewGameButton = new JButton("New Game");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0,30,0,30);
		c.weightx = 0.5;
		c.weighty = 0.9;
		c.gridx = 0;
		c.gridy = 0;
		add(lNewGameButton, c);
		
		lJoinGameButton = new JButton("Join Game");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.weighty = 0.9;
		c.gridx = 0;
		c.gridy = 1;
		add(lJoinGameButton, c);

		lLoadGameButton = new JButton("Load Game");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.weighty = 0.9;
		c.gridx = 0;
		c.gridy = 2;
		add(lLoadGameButton, c);
		
		lExitButton = new JButton("Exit Game");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.weighty = 0.9;
		c.gridx = 0;
		c.gridy = 3;
		add(lExitButton, c);
		

		
		createButtonListeners();
	}

	protected void createButtonListeners(){
		
		
		lNewGameButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    lModel.requestNewGame();
		    dispose();
		  }
		});
		
		
		lJoinGameButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    lModel.requestJoinGame();
		    dispose();
		  }
		});
		
		
		lLoadGameButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    lModel.requestLoadGame();
		    dispose();
		  }
		});
		
		
		lExitButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    System.exit(1);
		  }
		});
		
	}
}
