/*
 * MainPanel.java
 *
 * Created on __DATE__, __TIME__
 */

package com.jack.findUpdate.ui;

import java.text.MessageFormat;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import com.jack.findUpdate.SystemPara;
import com.jack.findUpdate.dto.ModifyPath;
import com.jack.findUpdate.dto.UserData;
import com.jack.findUpdate.service.MainService;
import com.jack.findUpdate.util.PropertiesUtil;
import com.jack.findUpdate.util.ValidateUtil;

/**
 *
 * @author  Jack
 */
public class MainPanel extends javax.swing.JPanel {

	private Logger log = Logger.getLogger(MainPanel.class);

	/** Creates new form MainPanel */
	public MainPanel() {
		initComponents();
		loadParas();
		initData();
	}

	private void initData() {
		svnBtn.setActionCommand(svnBtn.getText());
		gitBtn.setActionCommand(gitBtn.getText());
		webBtn.setActionCommand(webBtn.getText());
		javaBtn.setActionCommand(javaBtn.getText());

	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		toolTypeGroup = new javax.swing.ButtonGroup();
		appTypeGroup = new javax.swing.ButtonGroup();
		jSeparator1 = new javax.swing.JSeparator();
		startVersionTxt = new javax.swing.JLabel();
		endVersionTxt = new javax.swing.JLabel();
		svnBtn = new javax.swing.JRadioButton();
		gitBtn = new javax.swing.JRadioButton();
		toolPathTxt = new javax.swing.JLabel();
		jSeparator2 = new javax.swing.JSeparator();
		projectPathTxt = new javax.swing.JLabel();
		jSeparator3 = new javax.swing.JSeparator();
		buildPathTxt = new javax.swing.JLabel();
		webBtn = new javax.swing.JRadioButton();
		javaBtn = new javax.swing.JRadioButton();
		buildBtn = new javax.swing.JButton();
		jSeparator4 = new javax.swing.JSeparator();
		toolPath = new com.jack.findUpdate.ui.MyFileChoose();
		projectPath = new com.jack.findUpdate.ui.MyFileChoose();
		buildPath = new com.jack.findUpdate.ui.MyFileChoose();
		startVersion = new javax.swing.JTextField();
		endVersion = new javax.swing.JTextField();
		usernameTxt = new javax.swing.JLabel();
		username = new javax.swing.JTextField();
		passwordTxt = new javax.swing.JLabel();
		previewBtn = new javax.swing.JButton();
		password = new javax.swing.JTextField();
		headVersion = new javax.swing.JCheckBox();

		startVersionTxt.setText("\u5f00\u59cb\u7248\u672c");

		endVersionTxt.setText("\u7ed3\u675f\u7248\u672c");

		toolTypeGroup.add(svnBtn);
		svnBtn.setSelected(true);
		svnBtn.setText("SVN");

		toolTypeGroup.add(gitBtn);
		gitBtn.setText("GIT");
		gitBtn.setEnabled(false);

		toolPathTxt.setText("\u5de5\u5177\u8def\u5f84");

		projectPathTxt.setText("\u9879\u76ee\u8def\u5f84");

		buildPathTxt.setText("\u751f\u6210\u8def\u5f84");

		appTypeGroup.add(webBtn);
		webBtn.setSelected(true);
		webBtn.setText("Web");

		appTypeGroup.add(javaBtn);
		javaBtn.setText("Java");
		javaBtn.setEnabled(false);

		buildBtn.setText("\u751f\u6210");
		buildBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buildBtnActionPerformed(evt);
			}
		});

		toolPath.setChooseDir(false);

		projectPath.setChooseDir(true);

		buildPath.setChooseDir(true);

		endVersion.setText("0");

		usernameTxt.setText("\u7528\u6237\u540d");

		passwordTxt.setText("\u5bc6\u7801");

		previewBtn.setText("\u9884\u89c8");
		previewBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				previewBtnActionPerformed(evt);
			}
		});

		headVersion.setText("\u6700\u65b0\u7248\u672c");
		headVersion.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				headVersionMouseClicked(evt);
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
										.addContainerGap()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																toolPathTxt)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								startVersionTxt)
																						.addComponent(
																								usernameTxt))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addComponent(
																												startVersion,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												69,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																										.addComponent(
																												endVersionTxt))
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addComponent(
																												username,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												69,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(
																												18,
																												18,
																												18)
																										.addComponent(
																												passwordTxt)))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addComponent(
																												endVersion,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												77,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																										.addComponent(
																												headVersion))
																						.addComponent(
																								password,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								69,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addComponent(
																projectPathTxt)
														.addComponent(
																buildPathTxt))
										.addContainerGap(159, Short.MAX_VALUE))
						.addGroup(
								layout.createSequentialGroup().addGap(10, 10,
										10).addComponent(jSeparator4,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										506, Short.MAX_VALUE))
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(10, 10, 10)
										.addComponent(webBtn)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(javaBtn).addContainerGap(
												414, Short.MAX_VALUE))
						.addGroup(
								layout.createSequentialGroup().addGap(10, 10,
										10).addComponent(jSeparator3,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										506, Short.MAX_VALUE))
						.addGroup(
								layout.createSequentialGroup().addGap(10, 10,
										10).addComponent(jSeparator2,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										506, Short.MAX_VALUE))
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout
										.createSequentialGroup()
										.addContainerGap(386, Short.MAX_VALUE)
										.addComponent(previewBtn)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(buildBtn)
										.addContainerGap())
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(svnBtn)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(gitBtn).addContainerGap(
												424, Short.MAX_VALUE))
						.addComponent(jSeparator1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 516,
								Short.MAX_VALUE).addGroup(
								layout.createSequentialGroup().addGap(62, 62,
										62).addComponent(buildPath,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(155, Short.MAX_VALUE))
						.addGroup(
								layout.createSequentialGroup().addGap(62, 62,
										62).addComponent(projectPath,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(155, Short.MAX_VALUE))
						.addGroup(
								layout.createSequentialGroup().addGap(62, 62,
										62).addComponent(toolPath,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(155, Short.MAX_VALUE)));

		layout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
				new java.awt.Component[] { endVersion, password, startVersion,
						username });

		layout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
				new java.awt.Component[] { buildPath, projectPath, toolPath });

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
														.addComponent(
																startVersionTxt)
														.addComponent(
																startVersion,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																endVersionTxt)
														.addComponent(
																endVersion,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																headVersion))
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
														.addComponent(svnBtn)
														.addComponent(gitBtn))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.CENTER)
														.addComponent(
																toolPathTxt)
														.addComponent(
																toolPath,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.CENTER)
														.addComponent(
																usernameTxt)
														.addComponent(
																username,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																passwordTxt)
														.addComponent(
																password,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
														.addComponent(
																projectPathTxt)
														.addComponent(
																projectPath,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.CENTER)
														.addComponent(
																buildPathTxt)
														.addComponent(
																buildPath,
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
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(webBtn)
														.addComponent(javaBtn))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jSeparator4,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												6,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												93, Short.MAX_VALUE)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(buildBtn)
														.addComponent(
																previewBtn))
										.addContainerGap()));
	}// </editor-fold>
	//GEN-END:initComponents

	private void buildBtnActionPerformed(java.awt.event.ActionEvent evt) {
		if (validateForm()) {
			final UserData userData = createUserData();
			saveParas(userData);

			try {
				boolean ret = MainService.saveUpdate(userData);
				if (ret) {
					JOptionPane.showMessageDialog(this, "build OK");
				} else {
					JOptionPane.showMessageDialog(this, "build fail");
				}
			} catch (Exception e) {
				log.error("buildBtnActionPerformed", e);
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}
	}

	private void headVersionMouseClicked(java.awt.event.MouseEvent evt) {
		if (headVersion.isSelected()) {
			endVersion.setText("0");
			endVersion.setEditable(false);
		} else {
			endVersion.setEditable(true);
		}
	}

	private void previewBtnActionPerformed(java.awt.event.ActionEvent evt) {
		if (validateForm()) {
			final UserData userData = createUserData();
			saveParas(userData);
			final Preview pre = new Preview(null, false);
			pre.setLocationRelativeTo(this);
			pre.setVisible(true);
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					try {
						List<ModifyPath> paths = MainService
								.getModifyPath(userData);
						for (ModifyPath path : paths) {
							pre.addInfo(MessageFormat.format("{0}\t{1}\t{2}\n",
									path.getModifyType().toString(), path
											.getPathType().toString(), path
											.getPath()));
						}
					} catch (Exception e) {
						log.error("previewBtnActionPerformed", e);
						JOptionPane.showMessageDialog(MainPanel.this,
								PropertiesUtil.getErrorText("get.data.error"));
						pre.dispose();
					}
				}
			});

		}
	}

	private UserData createUserData() {
		UserData userData = new UserData();
		userData.setAppType(appTypeGroup.getSelection().getActionCommand());
		userData.setBuildPath(buildPath.getChoosePath());
		userData.setEndVersion(Integer.parseInt(endVersion.getText()));
		userData.setPassword(password.getText());
		userData.setProjectPath(projectPath.getChoosePath());
		userData.setStartVersion(Integer.parseInt(startVersion.getText()));
		userData.setToolPath(toolPath.getChoosePath());
		userData.setToolType(toolTypeGroup.getSelection().getActionCommand());
		userData.setUsername(username.getText());
		return userData;
	}

	private boolean validateForm() {
		try {
			ValidateUtil.validate(startVersionTxt.getText(), startVersion
					.getText(), ValidateUtil.TYPE.REQUIRE,
					ValidateUtil.TYPE.INTEGER);
			ValidateUtil.validate(endVersionTxt.getText(),
					endVersion.getText(), ValidateUtil.TYPE.REQUIRE,
					ValidateUtil.TYPE.INTEGER);
			ValidateUtil.validate(toolPathTxt.getText(), toolPath
					.getChoosePath(), ValidateUtil.TYPE.REQUIRE,
					ValidateUtil.TYPE.FILE_EXIST);
			ValidateUtil.validate(usernameTxt.getText(), username.getText(),
					ValidateUtil.TYPE.REQUIRE);
			ValidateUtil.validate(passwordTxt.getText(), password.getText(),
					ValidateUtil.TYPE.REQUIRE);
			ValidateUtil.validate(projectPathTxt.getText(), projectPath
					.getChoosePath(), ValidateUtil.TYPE.REQUIRE,
					ValidateUtil.TYPE.FILE_EXIST);
			ValidateUtil.validate(buildPathTxt.getText(), buildPath
					.getChoosePath(), ValidateUtil.TYPE.REQUIRE);
		} catch (Exception e) {
			log.error("validateForm", e);
			JOptionPane.showMessageDialog(this, e.getMessage());
			return false;
		}
		return true;
	}

	private void loadParas() {
		SystemPara.getProperties(SystemPara.Type.appType, "");
		buildPath.setChoosePath(SystemPara.getProperties(
				SystemPara.Type.buildPath, ""));
		endVersion.setText(SystemPara.getProperties(SystemPara.Type.endVersion,
				""));
		startVersion.setText(SystemPara.getProperties(
				SystemPara.Type.startVersion, ""));
		password
				.setText(SystemPara.getProperties(SystemPara.Type.password, ""));
		username
				.setText(SystemPara.getProperties(SystemPara.Type.username, ""));
		projectPath.setChoosePath(SystemPara.getProperties(
				SystemPara.Type.projectPath, ""));
		toolPath.setChoosePath(SystemPara.getProperties(
				SystemPara.Type.toolPath, ""));
		SystemPara.getProperties(SystemPara.Type.toolType, "");
	}

	private void saveParas(UserData userData) {
		SystemPara
				.setProperties(SystemPara.Type.appType, userData.getAppType());
		SystemPara.setProperties(SystemPara.Type.buildPath, userData
				.getBuildPath());
		SystemPara.setProperties(SystemPara.Type.endVersion, userData
				.getEndVersion()
				+ "");
		SystemPara.setProperties(SystemPara.Type.startVersion, userData
				.getStartVersion()
				+ "");
		SystemPara.setProperties(SystemPara.Type.password, userData
				.getPassword());
		SystemPara.setProperties(SystemPara.Type.username, userData
				.getUsername());
		SystemPara.setProperties(SystemPara.Type.projectPath, userData
				.getProjectPath());
		SystemPara.setProperties(SystemPara.Type.toolPath, userData
				.getToolPath());
		SystemPara.setProperties(SystemPara.Type.toolType, userData
				.getToolType());
		try {
			SystemPara.saveParas();
		} catch (Exception e) {
			log.error("saveParas", e);
			JOptionPane.showMessageDialog(this, PropertiesUtil
					.getErrorText("save.configfile.fail"));
		}
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.ButtonGroup appTypeGroup;
	private javax.swing.JButton buildBtn;
	private com.jack.findUpdate.ui.MyFileChoose buildPath;
	private javax.swing.JLabel buildPathTxt;
	private javax.swing.JTextField endVersion;
	private javax.swing.JLabel endVersionTxt;
	private javax.swing.JRadioButton gitBtn;
	private javax.swing.JCheckBox headVersion;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JSeparator jSeparator3;
	private javax.swing.JSeparator jSeparator4;
	private javax.swing.JRadioButton javaBtn;
	private javax.swing.JTextField password;
	private javax.swing.JLabel passwordTxt;
	private javax.swing.JButton previewBtn;
	private com.jack.findUpdate.ui.MyFileChoose projectPath;
	private javax.swing.JLabel projectPathTxt;
	private javax.swing.JTextField startVersion;
	private javax.swing.JLabel startVersionTxt;
	private javax.swing.JRadioButton svnBtn;
	private com.jack.findUpdate.ui.MyFileChoose toolPath;
	private javax.swing.JLabel toolPathTxt;
	private javax.swing.ButtonGroup toolTypeGroup;
	private javax.swing.JTextField username;
	private javax.swing.JLabel usernameTxt;
	private javax.swing.JRadioButton webBtn;
	// End of variables declaration//GEN-END:variables

}