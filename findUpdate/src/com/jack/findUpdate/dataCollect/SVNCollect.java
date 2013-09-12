package com.jack.findUpdate.dataCollect;

import java.text.MessageFormat;
import java.util.List;

import com.jack.findUpdate.SystemPara;
import com.jack.findUpdate.po.ModifyPath;
import com.jack.findUpdate.util.CmdUtil;

/**
 * svn.exe log -v -r {2013-09-05}:HEAD F:\testsvn\test
 * @author jack
 *
 */
public class SVNCollect implements DataCollect{

	private String cmd = "{0} diff -r {1}:{2} --summarize --xml {3}";
	
	@Override
	public List<ModifyPath> findModifyPathsFromVersion(int beginVersion, int endVersion, String path) throws Exception {
		String toStr;
		if(endVersion==0){
			toStr = "HEAD";
		}else{
			toStr = endVersion + "";
		}
		String svnPath = SystemPara.getProperties(SystemPara.Type.svnPath);
		if(svnPath==null){
			svnPath = "H:/svn-win32-1.6.6/bin/svn";
		}
		String ret = CmdUtil.exeCmd(MessageFormat.format(cmd, svnPath, beginVersion, toStr, path));
		if(ret==null){
			throw new Exception("svncollect execmd error");
		}
		System.out.println(ret);
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		new SVNCollect().findModifyPathsFromVersion(2, 3, "F:/testsvn/test");
	}

}
