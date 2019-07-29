package test;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import cn.baigolf.base.TestCaseBeforeAfterMethod;
import cn.baigolf.base.WebDriverMethod;

public class Test1 {
	@Test
	public void test1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "d:\\chromeDriver.exe");
		
//		WebDriverMethod.ThreadDriver.get().get("http://www.qiqidongman.com/");
		Thread.sleep(3000);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-features=EnableEphemeralFlashPermission");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player","0");
		options.setExperimentalOption("prefs", prefs);
		WebDriver driver=new ChromeDriver(options);
		driver.get("http://www.qiqidongman.com/v/180576/1_34.html");
	}
	
}
