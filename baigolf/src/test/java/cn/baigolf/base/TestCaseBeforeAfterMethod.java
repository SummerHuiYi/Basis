package cn.baigolf.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
/**
 * @author 李国荣
 *封装了@Tese使用前driver被创建并加入到TheadLocal里面防止driver被Java回收
 *-@Tese使用后回收TheadLocal
 */
public class TestCaseBeforeAfterMethod {

	/* 所有测试方法执行前执行，alwaysRun属性表示方法必须执行 */
	
	@BeforeMethod(alwaysRun=true)
	public void testBeforeMethod() {
		DriverBase.getWebDriver();
//		WebDriverMethod.getWebDriver();
	}

	/* 所有测试方法执行完后执行，下面所有层级都关闭一次 */
	@AfterMethod(alwaysRun=true)
	public void AfterMethod() {
		DriverBase.driverQuit();
//		WebDriverMethod.driverQuit();
	}
}
