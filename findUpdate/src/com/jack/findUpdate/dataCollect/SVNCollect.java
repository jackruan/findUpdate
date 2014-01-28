package com.jack.findUpdate.dataCollect;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.jack.findUpdate.dto.ModifyPath;
import com.jack.findUpdate.dto.UserData;
import com.jack.findUpdate.service.MainService;
import com.jack.findUpdate.util.CmdUtil;

/**
 * svn.exe log -v -r {2013-09-05}:HEAD F:\testsvn\test
 * @author jack
 *
 */
public class SVNCollect implements DataCollect{

	private static Logger log = Logger.getLogger(SVNCollect.class);
	@Override
	public List<ModifyPath> findModifyPathsFromVersion(UserData userData) throws Exception {
		String toStr;
		if(userData.getEndVersion()==0){
			toStr = "HEAD";
		}else{
			toStr = userData.getEndVersion() + "";
		}
		String cmd = "{0} diff -r {1}:{2} --summarize --xml --username {3} --password {4} --non-interactive {5}";
		String ret = CmdUtil.exeCmd(MessageFormat.format(cmd, userData.getToolPath(), userData.getStartVersion() + "", toStr, userData.getUsername(), userData.getPassword(), userData.getProjectPath()));
		if(ret==null){
			throw new Exception("svncollect execmd error");
		}
		ByteArrayInputStream is = new ByteArrayInputStream(ret.getBytes(System.getProperty("file.encoding")));
		List<ModifyPath> paths = new TranslateXMLtoModifyPath().getModifyPaths(is);
		return paths;
	}
	
	public static void main(String[] args) throws Exception {
//		List<ModifyPath> paths = new SVNCollect().findModifyPathsFromVersion(2, 4, "F:/testsvn/test", "jack", "123", "H:/svn-win32-1.6.6/bin/svn");
//		System.out.println(paths);
	}
	
	public class TranslateXMLtoModifyPath extends DefaultHandler{
		
		private List<ModifyPath> paths;
		
		private ModifyPath temp;
		
		private String currentTag;
		
		public List<ModifyPath> getModifyPaths(InputStream input) throws SAXException, IOException, ParserConfigurationException{
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			parser.parse(input, this);
			return paths;
		}
		
		@Override
		public void startDocument() throws SAXException {
			paths = new ArrayList<ModifyPath>();
		}
		
		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			if("path".equals(qName)){
				temp = new ModifyPath();
				temp.setModifyType(attributes.getValue("item"));
				temp.setPathType(attributes.getValue("kind"));
				currentTag = "path";
			}
		}
		
		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			if("path".equals(qName)){
				paths.add(temp);
				currentTag = null;
			}
		}
		
		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			if("path".equals(currentTag)){
				temp.setPath(new String(ch, start, length));
			}
		}
	}

	@Override
	public int getCurrentVersion(UserData userData) throws Exception {
		return getVersion(userData, "base");
	}
	
	private int getVersion(UserData userData, String key)throws Exception{
		log.info("getVersion execute cmd");
		String cmd = "{0} info {1} -r " + key + " --xml ";
		String ret = CmdUtil.exeCmd(MessageFormat.format(cmd, userData.getToolPath(), userData.getProjectPath()));
		if(ret==null){
			throw new Exception("svncollect execmd error");
		}
		log.info("getVersion parse result");
		ByteArrayInputStream is = new ByteArrayInputStream(ret.getBytes(System.getProperty("file.encoding")));
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(is);
		Node node = document.getRootElement().selectSingleNode("//entry");
		Element e = (Element)node;
		log.info("getVersion parse result end");
		return Integer.parseInt(e.attribute("revision").getValue());
	}

	@Override
	public int getHeadVersion(UserData userData) throws Exception{
		return getVersion(userData, "head");
	}

}
