package com.keygy.excel.tool.service;

import java.util.List;

import com.keygy.excel.tool.model.Node;

public interface Target {
	String FILE_SPERATOR = System.getProperty("line.separator", "\n");;
	String target(List<Node> nodeList);
}
