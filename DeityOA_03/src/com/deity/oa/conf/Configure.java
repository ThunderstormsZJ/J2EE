package com.deity.oa.conf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configure {
	public static int pageSize;
	
	static{
		InputStream is = null;
		try {
			Properties properties = new Properties();
			is = Configure.class//
				.getClassLoader().getResourceAsStream("pageConf.properties");
			properties.load(is);
			if(properties.containsKey("pageSize")){
				pageSize = new Integer((properties.getProperty("pageSize")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
