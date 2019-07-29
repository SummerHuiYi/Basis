package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cn.baigolf.base.BasicConfigurationDriver;

/**
 * @author 李国荣
 *用于初始化驱动
 */
public class DriverBaseBussTest {
//	public static ThreadLocal<WebDriver> ThreadDriver=new ThreadLocal<WebDriver>();
	WebDriver driver;
//	初始化驱动
	public WebDriver getWebDriver() {
//		Log.startTestCase(className);
//		 WebDriver driver=null;
		try {
			if(BasicConfigurationDriver.getBrowser().equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", BasicConfigurationDriver.getChrome());
				driver = new ChromeDriver();
			}else if(BasicConfigurationDriver.getBrowser().equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", BasicConfigurationDriver.getFirefox());
				driver = new FirefoxDriver();
			}else if(BasicConfigurationDriver.getBrowser().equals("ie")) {
				System.setProperty("webdriver.ie.driver", BasicConfigurationDriver.getIe());
				driver = new InternetExplorerDriver();
			}else {
				System.out.println("这里有一个浏览器不匹配未处理");
			}
		}catch (Exception e) {
			System.out.println("可能出现浏览器版本与驱动不匹配的异常");
		}
//		ThreadDriver.set(driver);
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void driverQuit(){
//		ThreadDriver.get().quit();
//		ThreadDriver.remove();
//		logger.info("关闭driver服务与浏览器，把ThreadDriver里的对象引用移除");
	}
	
}
