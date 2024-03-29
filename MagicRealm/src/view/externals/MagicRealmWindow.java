package view.externals;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class MagicRealmWindow extends JFrame{
	
	private static final long serialVersionUID = 5188626554272104722L;
	JDesktopPane lDesktop;
	
	
	public MagicRealmWindow(){
		super("Magic Realm v-0.0.1");

		//Go Full Screen
		Dimension lScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int)lScreenSize.getWidth()-25;
		int y = (int)lScreenSize.getHeight()-75;
		setPreferredSize(new Dimension(x,y));
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		pack();

		//Exit on window close
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		lDesktop = new JDesktopPane();
		lDesktop.setBackground(Color.gray);


		add(lDesktop, BorderLayout.CENTER);
		setVisible(true);
	}

	
	
	public void addWindow(JInternalFrame aFrame){
		lDesktop.add(aFrame);
		
		try {
			aFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}
	}
	
	
}
