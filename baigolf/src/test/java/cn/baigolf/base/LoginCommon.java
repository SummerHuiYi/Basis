package cn.baigolf.base;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import cn.baigolf.handle.LoginPageHandle;
import cn.baigolf.page.LoginPage;
/**
 * @author 李国荣
 *封装了登录统一使用的方法
 */
public class LoginCommon {
	private static Logger logger = LogManager.getLogger(LoginCommon.class);
	public static boolean login(String url,String user,String paw,String expectedResult,WebDriver driver) {
		logger.info("访问连接开始");
		driver.get(url);
		logger.info("访问连接结束");
		LoginPageHandle loginPageHandle=new LoginPageHandle(driver);
		logger.info("初始化化登录数据结束");
		loginPageHandle.zhanghao();		
		loginPageHandle.denglu();
		loginPageHandle.user(user);
		loginPageHandle.password(paw);
		loginPageHandle.blue_btn();
		//判断登录成功
		if(loginPageHandle.user_account()) return true;
		else return false;
	}	
}
