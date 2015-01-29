package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class MagicRealmWindow extends JFrame{
	
	JScrollPane lLeftPanel;
	JScrollPane lRightPanel;
	
	public MagicRealmWindow(){
		super("Magic Realm v 0.0.1");

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//Go Full Screen
		Dimension lScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int)lScreenSize.getWidth()-25;
		int y = (int)lScreenSize.getHeight()-75;
		getContentPane().setPreferredSize(new Dimension(x,y));
		pack();
		setResizable(false);
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		/*
		lLeftPanel = new JScrollPane();
		lRightPanel = new JScrollPane();
		
		
		getContentPane().add(lLeftPanel, c);
		
		
		getContentPane().add(lRightPanel, c);
		
		lLeftPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		lLeftPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		lRightPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		lRightPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
*/
		
		setVisible(true);
	}

}
