package cn.baigolf.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import cn.baigolf.base.BaseHandle;
import cn.baigolf.base.WebDriverMethod;

public class LoginPage {
	@FindBy(linkText="账号")
	private WebElement zhanghao;//账号按钮
	@FindBy(xpath="/html/body/div[2]/div[1]/div[2]/ul/li[6]/div/div/a[1]")
	private WebElement denglu;//登录按钮
	@FindBy(id="user_name")
	private WebElement user; //用户输入框
	@FindBy(id="password")
	private WebElement password; //密码输入框
	@FindBy(xpath="//*[@id=\"login\"]/div[4]/div/div[2]/button")
	private WebElement blue_btn; //提交按钮
	@FindBy(className="user-account")
	private WebElement user_account; //用户信息的element
	@FindBy(id="prompt_text")
	private WebElement prompt_text;//没有登录成功的element
	
	
	/*
	 * PageFactory.initElements(driver,page)方法来初始化实例化WebElement。
	 * 调用initElements()有两种方法，建议加上隐式等待的的方式。
	 */
	public LoginPage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(WebDriverMethod.getWebDriver(), 10), this);
	}
	
	
	public WebElement getZhanghao() {
		return zhanghao;
	}
	public WebElement getDenglu() {
		return denglu;
	}
	public WebElement getUser() {
		return user;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getBlue_btn() {
		return blue_btn;
	}
	public WebElement getUser_account() {
		return user_account;
	}
	public WebElement getPrompt_text() {
		return prompt_text;
	}
	
	
}
