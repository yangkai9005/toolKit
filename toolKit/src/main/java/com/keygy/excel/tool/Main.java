package com.keygy.excel.tool;

import java.awt.EventQueue;

import com.keygy.excel.tool.view.IndexFrame;

/**
 * Hello world!
 *
 */
public class Main 
{
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IndexFrame frame = new IndexFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
