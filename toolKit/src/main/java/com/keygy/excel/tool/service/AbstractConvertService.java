package com.keygy.excel.tool.service;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.keygy.excel.tool.model.Message;
import com.keygy.excel.tool.model.Node;

/**
 * 
 * @author kaiyang
 *
 */
public abstract class AbstractConvertService {
	public Message covert(String fileName,String targetFileName){
		List<Node> nodeList = parse(fileName);
		String content = generateTarget(nodeList);
		writeFile(targetFileName, content);
		return new Message("0", "成功");
	}
	
	public abstract List<Node> parse(String fileName);
	
	public abstract String generateTarget(List<Node> nodeList);
	
	public void writeFile(String targetFileName,String content){
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetFileName),"UTF-8"));
			bw.write(content);
			bw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(bw != null){
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
