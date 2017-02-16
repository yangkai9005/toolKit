package com.keygy.excel.tool.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExcelModePane extends JPanel {
	private JTextField modeFileText;
	private final JFileChooser fileChooser = new JFileChooser();

	/**
	 * Create the panel.
	 */
	public ExcelModePane() {
		setBackground(Color.WHITE);
		setLayout(null);
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		JLabel modeNotice = new JLabel("生成Excel模板");
		modeNotice.setForeground(new Color(60, 179, 113));
		modeNotice.setFont(new Font("微软雅黑", Font.BOLD, 16));
		modeNotice.setBounds(341, 0, 109, 22);
		add(modeNotice);
		
		JLabel modeFileLable = new JLabel("生成模板路径:");
		modeFileLable.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		modeFileLable.setBounds(27, 80, 109, 22);
		add(modeFileLable);
		
		modeFileText = new JTextField();
		modeFileText.setEnabled(false);
		modeFileText.setBounds(157, 82, 152, 21);
		add(modeFileText);
		modeFileText.setColumns(10);
		
		JButton modeChoiceBtn = new JButton("浏览");
		modeChoiceBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int returnVal = fileChooser.showSaveDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION)
				{
				    File currentFile = fileChooser.getSelectedFile();
				    modeFileText.setText(currentFile.getAbsolutePath());
				}
			}
		});
		modeChoiceBtn.setBounds(308, 81, 93, 23);
		add(modeChoiceBtn);
		
		JButton modeGeBtn = new JButton("生成模板");
		modeGeBtn.setBounds(157, 180, 93, 23);
		add(modeGeBtn);

	}

}
