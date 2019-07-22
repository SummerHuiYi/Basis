package cn.baigolf.base;

import cn.baigolf.util.ReadProperties;

/**
 * @author 李国荣
 *封装了driver初始化使用的数据
 */
public class BasicConfigurationDriver {
	private static String hubUrl;
	private static String nodeUrl;
	private static String url;
	private static String browser;
	private static String version;
	private static String chrome;
	private static String firefox;
	private static String ie;
	private static String testDataFilePath;
	
	static {
		ReadProperties readProperties=new ReadProperties(BasicConfigurationDriver.class.getSimpleName());
		hubUrl=readProperties.readResource("driver.hubUrl");
		nodeUrl=readProperties.readResource("driver.nodeUrl");
		url=readProperties.readResource("driver.url");
		browser=readProperties.readResource("driver.browser");
		version=readProperties.readResource("driver.version");
		chrome=readProperties.readResource("driver.browserPath.chrome");
		firefox=readProperties.readResource("driver.browserPath.firefox");
		ie=readProperties.readResource("driver.browserPath.ie");
		testDataFilePath=readProperties.readResource("testDataFilePath");
	}
	

	public static String getHubUrl() {
		return hubUrl;
	}

	public static String getUrl() {
		return url;
	}

	public static String getBrowser() {
		return browser;
	}

	public static String getChrome() {
		return chrome;
	}

	public static String getFirefox() {
		return firefox;
	}

	public static String getIe() {
		return ie;
	}

	public static String getTestDataFilePath() {
		return testDataFilePath;
	}

	public static String getVersion() {
		return version;
	}

	public static String getNodeUrl() {
		return nodeUrl;
	}

	
}
