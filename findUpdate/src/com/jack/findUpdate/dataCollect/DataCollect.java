package com.jack.findUpdate.dataCollect;

import java.util.Date;
import java.util.List;

import com.jack.findUpdate.po.ModifyPath;

public interface DataCollect {
	List<ModifyPath> findModifyPathsFromVersion(int beginVersion, int endVersion, String path)throws Exception;
}
