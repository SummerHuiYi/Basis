package cn.baigolf.buss;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import cn.baigolf.base.BasicConfigurationDriver;
import cn.baigolf.base.DriverBase;
import cn.baigolf.base.ImagesFile;

import cn.baigolf.base.TestCaseBeforeAfterMethod;
import cn.baigolf.base.WebDriverMethod;
import cn.baigolf.handle.LoginPageHandle;
import cn.baigolf.page.LoginPage;
import cn.baigolf.util.ExcelUtil;

public class LoginBuss extends TestCaseBeforeAfterMethod{
	private static Logger logger = LogManager.getLogger(LoginBuss.class);
	
	@Test(dataProvider="longin_data")
	public void login(String caseID,String webUrl,String testData,String expectedResult ) {
		Map<String,String> map=ExcelUtil.analysisData(testData, ",", ":");
		String user="";
		String paw="";
		if(map.get("用户名")!=null) user=map.get("用户名");
		if(map.get("密码")!=(null)) paw=map.get("密码");
		WebDriverMethod.ThreadDriver.get().get(webUrl);
		LoginPageHandle loginPageHandle=new LoginPageHandle();
		loginPageHandle.zhanghao();
		loginPageHandle.denglu();
		loginPageHandle.user(user);
		loginPageHandle.password(paw);
		loginPageHandle.blue_btn();
		//判断登录成功
		if(loginPageHandle.user_account()) {
			logger.info("功能：百高-登录；信息：第"+caseID+"用例，登录成功");
			assertEquals(true, true);
		}else {
			if(loginPageHandle.getPrompt_text().getText().equals(expectedResult)) {
				logger.info("功能：百高-登录；信息：第"+caseID+"用例，验证登录失败-成功");
				assertEquals(true, true);
			}
			else {
				ImagesFile.setImage(LoginBuss.class.getName(), "百高-登录", "第"+caseID+"用例，验证登录失败-失败");
				logger.error("功能：百高-登录；信息：第"+caseID+"用例，验证登录失败-失败");
				assertEquals(false, true);
			}
		}

	}
	@DataProvider
	public Object[][] longin_data() {
		return ExcelUtil.getExcelDate("LoginBuss",BasicConfigurationDriver.getTestDataFilePath());
	}

}
