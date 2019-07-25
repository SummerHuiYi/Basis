package cn.baigolf.buss;



import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cn.baigolf.base.BasicConfigurationDriver;
import cn.baigolf.base.DriverBase;
import cn.baigolf.base.TestCaseBeforeAfterMethod;
import cn.baigolf.base.WebDriverMethod;
import cn.baigolf.util.ExcelUtil;

public class TestBuss extends DriverBaseBussTest{
	
	@BeforeMethod
	public void bfTest() {
		getWebDriver();
	}

	@Test()
	public void test1() throws InterruptedException {
		
//		DriverBase.ThreadDriver.get().get(BasicConfigurationDriver.getUrl());
		System.out.println(BasicConfigurationDriver.getBrowser());
	}
	
	
}
