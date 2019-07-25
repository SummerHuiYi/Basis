package cn.baigolf.handle;
import org.openqa.selenium.WebDriver;

import cn.baigolf.base.BaseHandle;
import cn.baigolf.base.WaitMethod;
import cn.baigolf.page.SearchPage;

public class SearchPageHandle extends BaseHandle{
	public SearchPage searchPage;
	public SearchPageHandle() {
		searchPage=new SearchPage();
	}
	
	public void course_search(String value) {
		findElementSendKeys(searchPage.getCourse_search(), value);
	}
	public void selectBox_arrow() {
		findElementClick(searchPage.getSelectBox_arrow());
	}
	public void dateTime() {
		findElementClick(searchPage.getDateTime());
	}
	public void money() {
		findElementClick(searchPage.getMoney());
	}
	public void howMuch() {
		findElementClick(searchPage.getHowMuch());
	}
	public void hp_search() {
		findElementClick(searchPage.getHp_search());
	}
	public boolean view_map() {
		return WaitMethod.visibilityOfElementLocated(searchPage.getView_map());
	}
}
