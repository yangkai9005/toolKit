package com.keygy.excel.tool.excle2JsonAndXml;

import org.junit.Test;

import com.keygy.excel.tool.constant.Item;
import com.keygy.excel.tool.service.AbstractConvertService;
import com.keygy.excel.tool.service.impl.ExcelConvertServiceImpl;

public class ConvertTest {
	@Test
	public void excelToXml(){
		AbstractConvertService convert = new ExcelConvertServiceImpl(Item.EXCEL2XML);
		convert.covert("C:\\Users\\kaiyang\\Desktop\\model.xlsx", "C:\\Users\\kaiyang\\Desktop\\model.xml");
	}
	
	@Test
	public void excelToJSON(){
		AbstractConvertService convert = new ExcelConvertServiceImpl(Item.EXCEL2JSON);
		convert.covert("C:\\Users\\kaiyang\\Desktop\\model.xlsx", "C:\\Users\\kaiyang\\Desktop\\model.json");
	}
}
