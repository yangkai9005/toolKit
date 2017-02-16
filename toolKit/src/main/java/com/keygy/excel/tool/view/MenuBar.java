package com.keygy.excel.tool.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.keygy.excel.tool.constant.Item;

public class MenuBar extends JMenuBar {
	private final JFrame mainFrame;
	public MenuBar(JFrame mainFrame) {
		// TODO Auto-generated constructor stub
		super();
		this.mainFrame = mainFrame;
		JMenu menuChoice = new JMenu("选项");
		add(menuChoice);
		
		JMenuItem generatorExcelMode = new JMenuItem("生成Excel模板");
		menuChoice.add(generatorExcelMode);
		generatorExcelMode.addActionListener(new ActionListenerImpl(Item.EXCEL));
		
		JMenuItem excelToXmlMenu = new JMenuItem("Excel To Xml");
		menuChoice.add(excelToXmlMenu);
		excelToXmlMenu.addActionListener(new ActionListenerImpl(Item.EXCEL2XML));
		
		JMenuItem excelToJsonMenu = new JMenuItem("Excel To Json");
		menuChoice.add(excelToJsonMenu);
		excelToJsonMenu.addActionListener(new ActionListenerImpl(Item.EXCEL2JSON));
		
		JMenuItem xmlToJavaMenu = new JMenuItem("Xml To Java");
		menuChoice.add(xmlToJavaMenu);
		xmlToJavaMenu.addActionListener(new ActionListenerImpl(Item.XML2JAVA));
		
		JMenuItem jsonToJavaMenu = new JMenuItem("Json To Java");
		menuChoice.add(jsonToJavaMenu);
		jsonToJavaMenu.addActionListener(new ActionListenerImpl(Item.JSON2JAVA));
		
		JMenu menuHelp = new JMenu("帮助");
		add(menuHelp);
		
		JMenuItem helpMemu = new JMenuItem("Help?");
		menuHelp.add(helpMemu);
	}
	
	private class ActionListenerImpl implements ActionListener{
		private Item item;
		public ActionListenerImpl(Item item) {
			this.item = item;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			mainFrame.getContentPane().removeAll();
			mainFrame.getContentPane().repaint();
			JPanel panel = PanelFactory.getPanel(item);
			panel.setBounds(0, 0, 484, 221);
			mainFrame.getContentPane().add(panel);
		}
	}
}
