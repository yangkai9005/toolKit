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

public class ExcelToXmlPane extends JPanel {
	private JTextField modeFileText;
	private final JFileChooser fileChooser = new JFileChooser();
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public ExcelToXmlPane() {
		setBackground(Color.WHITE);
		setLayout(null);
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		JLabel modeNotice = new JLabel("Excel 转 Xml");
		modeNotice.setForeground(new Color(60, 179, 113));
		modeNotice.setFont(new Font("微软雅黑", Font.BOLD, 16));
		modeNotice.setBounds(349, 0, 101, 22);
		add(modeNotice);
		
		JLabel modeFileLable = new JLabel("Excel文件路径:");
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
		
		JButton modeGeBtn = new JButton("转换");
		modeGeBtn.setBounds(157, 180, 93, 23);
		add(modeGeBtn);
		
		JLabel lblXml = new JLabel("Xml文件路径:");
		lblXml.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblXml.setBounds(27, 126, 109, 22);
		add(lblXml);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(157, 128, 152, 21);
		add(textField);
		
		JButton button = new JButton("浏览");
		button.setBounds(308, 127, 93, 23);
		add(button);

	}

}
