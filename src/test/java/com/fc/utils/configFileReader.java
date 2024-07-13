package com.fc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configFileReader {
	
	
	String userDir = System.getProperty("user.dir");
	String configFilePath = userDir+"/src/test/java/com/fc/config/Config.properties";
	
	//Method to initialize and setup config.properties file
	public Properties getConfigFile() throws IOException {
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(configFilePath);
		prop.load(fs);
		return prop;
	}
	
	//Method to get data from config.properties file
	public String getDataFromConfigFile(String caseString) throws IOException {
		String strData = null;
		Properties pro = getConfigFile();
		switch(caseString) {
			case "baseURI":
				strData = pro.getProperty("APIBASEURI");
				break;
			case "todosEndpoint":
				strData = pro.getProperty("FCTODOSENDPOINT");
				break;
			case "userEndpoint":
				strData = pro.getProperty("FCUSERSENDPOINT");
				break;
		}
		
		return strData;
	}
	
	
}