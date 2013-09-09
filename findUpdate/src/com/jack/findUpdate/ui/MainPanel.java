/*
 * MainPanel.java
 *
 * Created on __DATE__, __TIME__
 */

package com.jack.findUpdate.ui;

import java.util.Date;

/**
 *
 * @author  __USER__
 */
public class MainPanel extends javax.swing.JPanel {

	/** Creates new form MainPanel */
	public MainPanel() {
		initComponents();
		startDt.setDate(new Date());
		endDt.setDate(new Date());
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		toolsGroup = new javax.swing.ButtonGroup();
		appTypeGroup = new javax.swing.ButtonGroup();
		jSeparator1 = new javax.swing.JSeparator();
		startDt = new org.jdesktop.swingx.JXDatePicker();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		endDt = new org.jdesktop.swingx.JXDatePicker();
		jRadioButton1 = new javax.swing.JRadioButton();
		jRadioButton2 = new javax.swing.JRadioButton();
		jLabel3 = new javax.swing.JLabel();
		jSeparator2 = new javax.swing.JSeparator();
		jLabel4 = new javax.swing.JLabel();
		jSeparator3 = new javax.swing.JSeparator();
		jLabel5 = new javax.swing.JLabel();
		jRadioButton3 = new javax.swing.JRadioButton();
		jRadioButton4 = new javax.swing.JRadioButton();
		jButton4 = new javax.swing.JButton();
		jSeparator4 = new javax.swing.JSeparator();
		myFileChoose1 = new com.jack.findUpdate.ui.MyFileChoose();
		myFileChoose2 = new com.jack.findUpdate.ui.MyFileChoose();
		myFileChoose3 = new com.jack.findUpdate.ui.MyFileChoose();

		jLabel1.setText("\u5f00\u59cb\u65e5\u671f");

		jLabel2.setText("\u7ed3\u675f\u65e5\u671f");

		toolsGroup.add(jRadioButton1);
		jRadioButton1.setSelected(true);
		jRadioButton1.setText("SVN");
		jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton1ActionPerformed(evt);
			}
		});

		toolsGroup.add(jRadioButton2);
		jRadioButton2.setText("GIT");
		jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton2ActionPerformed(evt);
			}
		});

		jLabel3.setText("\u5de5\u5177\u8def\u5f84");

		jLabel4.setText("\u9879\u76ee\u8def\u5f84");

		jLabel5.setText("\u751f\u6210\u8def\u5f84");

		appTypeGroup.add(jRadioButton3);
		jRadioButton3.setSelected(true);
		jRadioButton3.setText("Web");
		jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton3ActionPerformed(evt);
			}
		});

		appTypeGroup.add(jRadioButton4);
		jRadioButton4.setText("Java");
		jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton4ActionPerformed(evt);
			}
		});

		jButton4.setText("\u751f\u6210");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel3)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				myFileChoose1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel4)
																						.addComponent(
																								jLabel5))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								myFileChoose3,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								myFileChoose2,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(36, Short.MAX_VALUE))
						.addGroup(
								layout.createSequentialGroup().addGap(170, 170,
										170).addComponent(jButton4)
										.addContainerGap(176, Short.MAX_VALUE))
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabel1)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												startDt,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel2)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												endDt,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(143, Short.MAX_VALUE))
						.addComponent(jSeparator1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 403,
								Short.MAX_VALUE)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jRadioButton1)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jRadioButton2)
										.addContainerGap(311, Short.MAX_VALUE))
						.addComponent(jSeparator2,
								javax.swing.GroupLayout.DEFAULT_SIZE, 403,
								Short.MAX_VALUE)
						.addComponent(jSeparator3,
								javax.swing.GroupLayout.DEFAULT_SIZE, 403,
								Short.MAX_VALUE)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jRadioButton3)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jRadioButton4)
										.addContainerGap(305, Short.MAX_VALUE))
						.addComponent(jSeparator4,
								javax.swing.GroupLayout.DEFAULT_SIZE, 403,
								Short.MAX_VALUE));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.CENTER)
														.addComponent(jLabel1)
														.addComponent(
																startDt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel2)
														.addComponent(
																endDt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jSeparator1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jRadioButton1)
														.addComponent(
																jRadioButton2))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.CENTER)
														.addComponent(jLabel3)
														.addComponent(
																myFileChoose1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jSeparator2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.CENTER)
														.addComponent(jLabel4)
														.addComponent(
																myFileChoose2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.CENTER)
														.addComponent(jLabel5)
														.addComponent(
																myFileChoose3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(17, 17, 17)
										.addComponent(
												jSeparator3,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jRadioButton3)
														.addComponent(
																jRadioButton4))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jSeparator4,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												6,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(96, 96, 96).addComponent(
												jButton4).addContainerGap(32,
												Short.MAX_VALUE)));
	}// </editor-fold>
	//GEN-END:initComponents

	// TODO add your handling code here:

	private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.ButtonGroup appTypeGroup;
	private org.jdesktop.swingx.JXDatePicker endDt;
	private javax.swing.JButton jButton4;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JRadioButton jRadioButton1;
	private javax.swing.JRadioButton jRadioButton2;
	private javax.swing.JRadioButton jRadioButton3;
	private javax.swing.JRadioButton jRadioButton4;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JSeparator jSeparator3;
	private javax.swing.JSeparator jSeparator4;
	private com.jack.findUpdate.ui.MyFileChoose myFileChoose1;
	private com.jack.findUpdate.ui.MyFileChoose myFileChoose2;
	private com.jack.findUpdate.ui.MyFileChoose myFileChoose3;
	private org.jdesktop.swingx.JXDatePicker startDt;
	private javax.swing.ButtonGroup toolsGroup;
	// End of variables declaration//GEN-END:variables

}