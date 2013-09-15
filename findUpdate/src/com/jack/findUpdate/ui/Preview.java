/*
 * Preview.java
 *
 * Created on __DATE__, __TIME__
 */

package com.jack.findUpdate.ui;

/**
 *
 * @author  __USER__
 */
public class Preview extends javax.swing.JDialog {

	/** Creates new form Preview */
	public Preview(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
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

		jScrollPane1 = new javax.swing.JScrollPane();
		preview = new javax.swing.JTextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("preview");

		preview.setColumns(20);
		preview.setEditable(false);
		preview.setRows(5);
		jScrollPane1.setViewportView(preview);

		getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
		setBounds((screenSize.width - 504) / 2, (screenSize.height - 330) / 2,
				504, 330);
	}// </editor-fold>
	//GEN-END:initComponents

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				Preview dialog = new Preview(new javax.swing.JFrame(), true);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});
	}

	public void addInfo(String str) {
		this.preview.append(str);
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea preview;
	// End of variables declaration//GEN-END:variables

}