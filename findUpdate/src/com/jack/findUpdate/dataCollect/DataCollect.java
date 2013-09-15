package com.jack.findUpdate.dataCollect;

import java.util.Date;
import java.util.List;

import com.jack.findUpdate.dto.ModifyPath;
import com.jack.findUpdate.dto.UserData;

public interface DataCollect {
	List<ModifyPath> findModifyPathsFromVersion(UserData userData)throws Exception;
}
