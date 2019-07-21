package cn.baigolf.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class ReadProperties {
	//获取properties的配置文件
	private ResourceBundle resourceBundle;
	
	public ReadProperties(){
		
	}
	//获取对应的properties配置文件
	public ReadProperties(String className){
		this.resourceBundle=ResourceBundle.getBundle(className, Locale.CHINA);
	}
	
	//获取对应的properties配置文件
	public ResourceBundle getResourceBundle(String className) {
		this.resourceBundle=ResourceBundle.getBundle(className, Locale.CHINA);
		return resourceBundle;
	}

	//获取对应的值
	public String readResource(String key) {
		return resourceBundle.getString(key);	
	}

}
