package com.keygy.excel.tool.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;
import javax.swing.JTextField;

import com.keygy.excel.tool.constant.Item;

public class IndexFrame extends JFrame {
	private static final int SCRRENT_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	private static final int SCRRENT_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	private static final int WIDHT = 470;
	private static final int HEIGHT = 400;
	/**
	 * Create the frame.
	 */
	public IndexFrame() {
		setTitle("开发小工具集");
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((SCRRENT_WIDTH - WIDHT) / 2, (SCRRENT_HEIGHT - HEIGHT) / 2,WIDHT, HEIGHT);
		
		JMenuBar menuBar = new MenuBar(this);
		setJMenuBar(menuBar);
		
		
		getContentPane().setLayout(null);
		
		JPanel panel = PanelFactory.getPanel(Item.EXCEL);
		panel.setBounds(0, 0, 484, 221);
		getContentPane().add(panel);
		
	}
}
