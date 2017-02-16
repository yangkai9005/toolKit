package com.keygy.excel.tool.view;

import javax.swing.JPanel;

import com.keygy.excel.tool.constant.Item;

public class PanelFactory {
	public static JPanel getPanel(Item item){
		switch (item) {
		case EXCEL:
			return new ExcelModePane();
		case EXCEL2JSON:
			return new ExcelToJsonPane();
		case EXCEL2XML:
			return new ExcelToXmlPane();
		case JSON2JAVA:
			return new JsonToJavaPane();
		case XML2JAVA:
			return new XmlToJavaPane();
		default:
			return new ExcelModePane();
		}
	}
}
