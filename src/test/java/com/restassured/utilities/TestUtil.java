package com.restassured.utilities;

import org.json.JSONObject;

import com.restassured.listeners.ExtentListeners;

public class TestUtil {
	
	public static boolean jsonHasKey(String json, String key) {
		
		JSONObject jsonObject = new JSONObject(json);
		return jsonObject.has(key);
	}

	public static String returnJsonKeyValue(String json, String key) {
		
		JSONObject jsonObject = new JSONObject(json);
		ExtentListeners.testReport.get().info("Validating the presence of key "+key);
		return jsonObject.getString(key).toString();
	}
}
