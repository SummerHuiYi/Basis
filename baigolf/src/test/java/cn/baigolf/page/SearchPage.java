package cn.baigolf.page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import cn.baigolf.base.WebDriverMethod;
public class SearchPage{
	
	@FindBy(id="course_search")
	private WebElement course_search;//输入地区名称
	@FindBy(className="selectBox-arrow")
	private WebElement selectBox_arrow;// 时间
	@FindBy(linkText="上午")
	private WebElement dateTime;//被选中的时间
	@FindBy(css=".search_table tbody tr td:nth-child(4) .selectBox-arrow")
	private WebElement money;//价格
	@FindBy(linkText="500 - 800")
	private WebElement howMuch;//被选中的价格
	@FindBy(id="hp_search")
	private WebElement hp_search;//搜索
	@FindBy(className="view_map")
	private WebElement view_map;//查看地图；用于判断是否查询成功
	
	/*
	 * PageFactory.initElements(driver,page)方法来初始化实例化WebElement。
	 * 调用initElements()有两种方法，建议加上隐式等待的的方式。
	 */
	public SearchPage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(WebDriverMethod.getWebDriver(), 10), this);
	}
	
	public WebElement getCourse_search() {
		return course_search;
	}
	public WebElement getSelectBox_arrow() {
		return selectBox_arrow;
	}
	public WebElement getDateTime() {
		return dateTime;
	}
	public WebElement getMoney() {
		return money;
	}
	public WebElement getHowMuch() {
		return howMuch;
	}
	public WebElement getHp_search() {
		return hp_search;
	}
	public WebElement getView_map() {
		return view_map;
	}
	
}
