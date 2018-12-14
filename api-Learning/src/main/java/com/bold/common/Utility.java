package com.bold.common;


import java.io.File;
import java.io.IOException;

import org.json.JSONObject;
import org.testng.reporters.Files;

public final class Utility {


	
	public static String getJsonFile(String fileFormatType) throws IOException{
		String fileContent = Files.readFile(new File("src\\test\\resources\\inputJsonFiles\\SampleDataForDoc.json"));
		
		JSONObject jsnObj = new JSONObject(fileContent);
		 jsnObj.put("FileFormatType", fileFormatType);
		return jsnObj.toString();
	}


	
	
}
