package com.jack.findUpdate;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jack.findUpdate.ui.MainPanel;

public class Start {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		System.setProperty("java.awt.im.style", "on-the-spot");
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame j = new JFrame("findUpate");
//				j.setSize(800, 200);
				j.add(new MainPanel());
				j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				j.pack();
				j.setLocationRelativeTo(null);
				j.setVisible(true);
			}
		});

	}
	
}
