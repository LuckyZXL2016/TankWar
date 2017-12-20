package com.tank;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;


public class PropertyMgr {
	static Properties props = new Properties();
	//单例设计模式
	static {
		try {
			//props.load(PropertyMgr.class.getClass().getClassLoader().getResourceAsStream("config/tank.properties"));
			String tankPath = PropertyMgr.class.getClassLoader().getResource("config/tank.properties").getPath();
			tankPath = URLDecoder.decode(tankPath, "utf-8");
			props.load(new FileReader(tankPath));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private PropertyMgr() {};
	
	public static String getProperty(String key) {
		return props.getProperty(key);
	}
}
