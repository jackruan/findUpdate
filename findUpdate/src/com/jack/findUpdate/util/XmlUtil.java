package com.jack.findUpdate.util;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class XmlUtil {
	public static Node selectSingleNode(String filePath, String xpath) throws Exception {  
    	SAXReader reader = new SAXReader();
    	Document doc = reader.read(new File(filePath));
    	Node node = doc.selectSingleNode(xpath);
    	return node;
    }
	
	public static List<Node> selectSingleNodeList(String filePath, String xpath) throws Exception {  
    	SAXReader reader = new SAXReader();
    	Document doc = reader.read(new File(filePath));
    	List<Node> nodes = doc.selectNodes(xpath);
    	return nodes;
    }
	
	public static void main(String[] args) throws Exception{
	}
}
