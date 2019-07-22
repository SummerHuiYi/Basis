package cn.baigolf.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author 李国荣
 *封装了本地运行driver的方法
 */
public class DriverBase {
	public static ThreadLocal<WebDriver> ThreadDriver=new ThreadLocal<WebDriver>();
	private static Logger logger = LogManager.getLogger(DriverBase.class);
//	初始化驱动
	public static WebDriver getWebDriver() {
		 WebDriver driver=null;
		try {
			if(BasicConfigurationDriver.getBrowser().equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", BasicConfigurationDriver.getChrome());
				logger.info("创建Chrome驱动开始");
				driver = new ChromeDriver();
				logger.info("创建Chrome驱动结束");
			}else if(BasicConfigurationDriver.getBrowser().equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", BasicConfigurationDriver.getFirefox());
				logger.info("创建firefox驱动开始");
				driver = new FirefoxDriver();
				logger.info("创建firefox驱动结束");
			}else if(BasicConfigurationDriver.getBrowser().equals("ie")) {
				System.setProperty("webdriver.ie.driver", BasicConfigurationDriver.getIe());
				logger.info("创建ie驱动开始");
				driver = new InternetExplorerDriver();
				logger.info("创建ie驱动结束");
			}else {
				logger.error("浏览器不匹配，创建driver失败");
			}
		}catch (Exception e) {
			logger.error("创建驱动失败");
		}
		ThreadDriver.set(driver);
		logger.info("新建driver加入ThreadDriver成功");
		driver.manage().window().maximize();
		logger.info("浏览器窗口放大");
		return driver;
	}
	
	public static void driverQuit(){
		ThreadDriver.get().quit();
		ThreadDriver.remove();
		logger.info("关闭driver服务与浏览器，把ThreadDriver里的对象引用移除");
		
	}
	
}
