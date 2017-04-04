package com.keygy.excel.tool.service.impl;

import java.util.List;

import com.keygy.excel.tool.constant.Constants;
import com.keygy.excel.tool.model.Node;
import com.keygy.excel.tool.service.Target;

public class JsonTargetImpl implements Target {

	@Override
	public String target(List<Node> nodeList) {
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		for (Node node : nodeList) {
			if(isParentString(node)){
				sb.append("\\\"").append(node.getName()).append("\\\"").append(":");
			}else{
				sb.append("\"").append(node.getName()).append("\"").append(":");
			}
			if(Constants.NumType.MORE.equals(node.getNum())){
				if(isString(node) && !isString(node.getParent())){
					sb.append("\"[").append(target(node.getChildren())).append("]\"");
				}else if(isString(node) && isString(node.getParent())){
					sb.append("\\\"[").append(target(node.getChildren())).append("]\\\"");
				}
				else if(!isString(node)){
					sb.append("[").append(target(node.getChildren())).append("]");
				}
			}else{
				if(Constants.Type.STRING.equals(node.getType())){
					if(isParentString(node)){
						sb.append("\\\"").append(node.getValue()).append("\\\"");
					}else{
						sb.append("\"").append(node.getValue()).append("\"");
					}
				}else{
					sb.append(node.getValue());
				}
			}
			sb.append(",");
		}
		System.out.println(sb.toString());
		sb.delete(sb.length()-1, sb.length());
		sb.append("}");
		return sb.toString();
	}

	private boolean isParentString(Node node) {
		if(node != null){
			return node.getParent() != null && Constants.Type.STRING.equals(node.getParent().getType());
		}
		return false;
	}

	private boolean isString(Node node) {
		if(node != null){
			return Constants.Type.STRING.equals(node.getType()) && node.getChildren() != null;
		}
		return false;
	}

}
