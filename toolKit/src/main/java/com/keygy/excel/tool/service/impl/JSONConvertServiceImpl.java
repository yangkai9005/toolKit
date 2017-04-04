package com.keygy.excel.tool.service.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.keygy.excel.tool.model.Node;
import com.keygy.excel.tool.service.AbstractConvertService;

public class JSONConvertServiceImpl extends AbstractConvertService {

	@Override
	public List<Node> parse(String fileName) {
		String jsonStr = getJsonStr(fileName);
		List<Node> nodeList = new ArrayList<Node>();
		try {
			JSONObject json = new JSONObject(jsonStr);
			Iterator<String> it = json.keys();
			while(it.hasNext()){
				String key = it.next();
				Object value = json.get(key);
				Node node = new Node();
				node.setName(key);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return nodeList;
	}

	private String getJsonStr(String fileName) {
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
			String content = null;
			while((content = br.readLine()) != null){
				sb.append(content);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}

	@Override
	public String generateTarget(List<Node> nodeList) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
