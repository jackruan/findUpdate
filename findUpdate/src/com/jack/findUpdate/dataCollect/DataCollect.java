package com.jack.findUpdate.dataCollect;

import java.util.List;

import com.jack.findUpdate.dto.ModifyPath;
import com.jack.findUpdate.dto.UserData;

public interface DataCollect {
	List<ModifyPath> findModifyPathsFromVersion(UserData userData)throws Exception;
	int getCurrentVersion(UserData userData)throws Exception;
	int getHeadVersion(UserData userData)throws Exception;
}
