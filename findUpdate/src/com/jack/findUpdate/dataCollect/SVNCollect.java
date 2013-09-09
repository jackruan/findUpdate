package com.jack.findUpdate.dataCollect;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
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

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private String cmd = "{0} log -v -r {1}:{2} {3}";
	
	@Override
	public List<ModifyPath> findModifyPathsFromDate(Date from, Date to, String path) throws Exception {
		String toStr;
		if(to==null){
			toStr = "HEAD";
		}else{
			toStr = sdf.format(to);
		}
		String fromStr = sdf.format(from);
		String ret = CmdUtil.exeCmd(String.format(cmd, SystemPara.getProperties(SystemPara.Type.svnPath), fromStr, toStr, path));
		if(ret==null){
			throw new Exception("svncollect execmd error");
		}
		return null;
	}

}
