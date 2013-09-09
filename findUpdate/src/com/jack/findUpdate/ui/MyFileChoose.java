/*
 * MyFileChoose.java
 *
 * Created on __DATE__, __TIME__
 */

package com.jack.findUpdate.ui;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author  __USER__
 */
public class MyFileChoose extends javax.swing.JPanel {

	/** Creates new form MyFileChoose */
	public MyFileChoose() {
		initComponents();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		choosePathTxt = new javax.swing.JTextField();
		chooseBtn = new javax.swing.JButton();

		choosePathTxt.setEditable(false);
		choosePathTxt.setText("jTextField1");

		chooseBtn.setText("\u6d4f\u89c8");
		chooseBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				chooseBtnActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addComponent(
												choosePathTxt,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												235,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												chooseBtn,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												58,
												javax.swing.GroupLayout.PREFERRED_SIZE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createParallelGroup(
						javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(chooseBtn).addComponent(choosePathTxt,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)));
	}// </editor-fold>
	//GEN-END:initComponents

	private void chooseBtnActionPerformed(java.awt.event.ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		int result = fc.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			choosePathTxt.setText(fc.getSelectedFile().getAbsolutePath());
		}
	}

	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		System.setProperty("java.awt.im.style", "on-the-spot");
		JFrame j = new JFrame();
		j.setSize(300, 200);
		j.add(new MyFileChoose());
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setVisible(true);
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton chooseBtn;
	private javax.swing.JTextField choosePathTxt;
	// End of variables declaration//GEN-END:variables

}