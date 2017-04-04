package com.keygy.excel.tool.service.impl;

import java.util.List;

import com.keygy.excel.tool.constant.Constants;
import com.keygy.excel.tool.model.Node;
import com.keygy.excel.tool.service.Target;

public class XmlTargetImpl implements Target {

	@Override
	public String target(List<Node> nodeList) {
		StringBuffer sb = new StringBuffer();
		for(Node node : nodeList){
			sb.append(beginLable(node.getName()));
			if(Constants.NumType.MORE.equals(node.getNum()) && node.getChildren() != null){
				sb.append(FILE_SPERATOR);
				sb.append(target(node.getChildren()));
			}else{
				sb.append(node.getValue() == null?"":node.getValue());
			}
			sb.append(endLable(node.getName())).append(comment(node.getComment())).append(FILE_SPERATOR);
		}
		return sb.toString();
	}
	
	private String beginLable(String name){
		return "<" + name + ">";
	}
	
	private String endLable(String name){
		return "</" + name + ">";
	}
	
	private String comment(String comment){
		return "<!--" + comment + "-->";
	}

}
