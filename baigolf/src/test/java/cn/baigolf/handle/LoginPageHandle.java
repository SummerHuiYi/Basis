package cn.baigolf.handle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import cn.baigolf.base.BaseHandle;
import cn.baigolf.base.WaitMethod;
import cn.baigolf.page.LoginPage;


public class LoginPageHandle extends BaseHandle{
	public LoginPage loginPage;
	
	public LoginPageHandle() {
		this.loginPage=new LoginPage();
	}	
	//模拟鼠标移动到账号元素上
	public void zhanghao() {
		clickAndHold(loginPage.getZhanghao());
	}
	//点击登录按钮
	public void denglu() {
		findElementClick(loginPage.getDenglu());
	}
	//输入用户名信息
	public void user(String value) {
		findElementSendKeys(loginPage.getUser(), value);
	}
	//输入密码
	public void password(String value) {
		findElementSendKeys(loginPage.getPassword(), value);
	}
	//登录
	public void blue_btn() {
		findElementClick(loginPage.getBlue_btn());
	}
	//判断用户名是否存在
	public boolean user_account() {
		return WaitMethod.visibilityOfElementLocated(loginPage.getUser_account());
	}
	//返回没有登录成功元素
	public WebElement getPrompt_text() {
		return loginPage.getPrompt_text();
	}
}
