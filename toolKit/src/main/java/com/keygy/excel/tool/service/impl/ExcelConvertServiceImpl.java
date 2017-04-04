package com.keygy.excel.tool.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.keygy.excel.tool.constant.Constants;
import com.keygy.excel.tool.constant.Item;
import com.keygy.excel.tool.model.Node;
import com.keygy.excel.tool.service.AbstractConvertService;
import com.keygy.excel.tool.service.Target;

public class ExcelConvertServiceImpl extends AbstractConvertService {
	private final Item item ;
	private final Target xmlTarget = new XmlTargetImpl();
	private final Target jsonTarget = new JsonTargetImpl();
	public ExcelConvertServiceImpl(Item item) {
		this.item = item;
	}
	@Override
	public List<Node> parse(String fileName) {
		Workbook workbook = null;
		List<Node> nodeList = new ArrayList<Node>();
		try {
			workbook = new XSSFWorkbook(new File(fileName));
			int sheetNums = workbook.getNumberOfSheets();
			for (int i = 0; i < sheetNums; i++) {
				Sheet sheet = workbook.getSheetAt(i);
				int numRows = sheet.getPhysicalNumberOfRows();
				if(numRows > 0){
					parseRow(sheet,sheet.getFirstRowNum() + 2,sheet.getLastRowNum(),nodeList);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(workbook != null){
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return nodeList;
	}
	private void parseRow(Sheet sheet,int begin,int end,List<Node> nodeList) {
		for(int i = begin;  i < end;){
			Row row = sheet.getRow(i);
			if(checkRow(row)){
				Node node = new Node();
				node.setName(row.getCell(0).getStringCellValue());
				node.setValue(row.getCell(1).getStringCellValue());
				node.setType(row.getCell(2).getStringCellValue());
				node.setComment(row.getCell(3).getStringCellValue());
				CellType cellType =row.getCell(4).getCellTypeEnum();
				node.setNum(cellType == CellType.STRING?row.getCell(4).getStringCellValue():(row.getCell(4).getNumericCellValue()+"").substring(0,1));
				if(Constants.NumType.MORE.equals(node.getNum())){
					i = getChildren(sheet, i, node);
				}else{
					i++;
				}
				nodeList.add(node);
			}
			
		}
	}
	private int getChildren(Sheet sheet, int i, Node node) {
		List<Node> children = new ArrayList<Node>();
		int j = i + 1;
		Row childRow = null;
		while(!(childRow = sheet.getRow(j)).getCell(0).getStringCellValue().equals(node.getName())){
			if(checkRow(childRow)){
				Node childNode = new Node();
				childNode.setName(childRow.getCell(0).getStringCellValue());
				childNode.setValue(childRow.getCell(1).getStringCellValue());
				childNode.setType(childRow.getCell(2).getStringCellValue());
				childNode.setComment(childRow.getCell(3).getStringCellValue());
				CellType childCellType =childRow.getCell(4).getCellTypeEnum();
				childNode.setNum(childCellType == CellType.STRING?childRow.getCell(4).getStringCellValue():(childRow.getCell(4).getNumericCellValue()+"").substring(0,1));
				childNode.setParent(node);
				children.add(childNode);
				if(Constants.NumType.MORE.equals(childNode.getNum())){
					j = getChildren(sheet, j, childNode);
				}else{
					j++;
				}
			}
		}
		node.setChildren(children);
		return j+1;
	}
	
	private boolean checkRow(Row row){
		if(row.getCell(0) != null && !"".equals(row.getCell(0).getStringCellValue())){
			return true;
		}
		return false;
	}

	@Override
	public String generateTarget(List<Node> nodeList) {
		switch (item) {
		case EXCEL2XML:
			return xmlTarget.target(nodeList);
		case EXCEL2JSON:
			return jsonTarget.target(nodeList);
		default:
			return xmlTarget.target(nodeList);
		}
	}
	
}
