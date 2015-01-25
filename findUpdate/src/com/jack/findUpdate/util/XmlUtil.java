package com.jack.findUpdate.util;

import java.io.File;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class XmlUtil {
	public static <T extends Node> T selectSingleNode(File file, String xpath) throws Exception {  
    	SAXReader reader = new SAXReader();
    	Document doc = reader.read(file);
    	T node = (T)doc.selectSingleNode(xpath);
    	return node;
    }	
	
	public static Attribute selectSingleAttribute(File file, String xpath) throws Exception {  
    	return selectSingleNode(file, xpath);
    }
	
	public static Element selectSingleElement(File file, String xpath) throws Exception {  
    	return selectSingleNode(file, xpath);
    }
	
	public static <T> List<T> selectNodeList(File file, String xpath) throws Exception {  
    	SAXReader reader = new SAXReader();
    	Document doc = reader.read(file);
    	List<T> nodes = doc.selectNodes(xpath);
    	return nodes;
    }
	
	public static List<Element> selectElementList(File file, String xpath) throws Exception{
		return selectNodeList(file, xpath);
	}
	
	public static List<Attribute> selectAttributeList(File file, String xpath) throws Exception{
		return selectNodeList(file, xpath);
	}
	
	public static void main(String[] args) throws Exception{
		List<Attribute> nodes = selectAttributeList(new File("F:\\project\\图书馆项目管理系统\\xmglxt\\code\\fstsg\\.classpath"), "/classpath/classpathentry[@kind='src']/@path");
		for(Attribute node : nodes){
			System.out.println(node.getValue());
		}
		
	}
}
