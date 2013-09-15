package com.jack.findUpdate.util;

import java.io.File;
import java.text.MessageFormat;

public class ValidateUtil {
	public static enum TYPE {
		REQUIRE, INTEGER, FILE_EXIST
	}

	public static void validate(String fieldName, String fieldValue, TYPE... rules) throws Exception{
		for (TYPE rule : rules) {
			if (rule == TYPE.REQUIRE) {
				if (fieldValue == null || fieldValue.trim().length() == 0) {
					throw new Exception(MessageFormat.format(PropertiesUtil.getErrorText("fieldValidate.require.msg"), fieldName));
				}
			} else if (rule == TYPE.INTEGER) {
				if (!fieldValue.matches("[0-9]+")) {
					throw new Exception(MessageFormat.format(PropertiesUtil.getErrorText("fieldValidate.integer.msg"), fieldName));
				}
			} else if (rule == TYPE.FILE_EXIST) {
				File file = new File(fieldValue);
				if (!file.exists()) {
					throw new Exception(MessageFormat.format(PropertiesUtil.getErrorText("fieldValidate.fileExist.msg"), fieldName));
				}
			}
		}
	}
	
	
}
