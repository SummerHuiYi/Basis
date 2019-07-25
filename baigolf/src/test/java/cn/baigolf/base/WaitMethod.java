package cn.baigolf.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author 李国荣
 *封装了智能等待
 */
public class WaitMethod {
	private static Logger logger = LogManager.getLogger(WaitMethod.class);
	/**
	 * 智能等待，元素不可见时，最多等待10S，10S内找不到元素立即返回
	 * @param 
	 */
	public static boolean visibilityOfElementLocated(WebElement elemnet) {
		boolean waitResult =false;
		/*
		 * 根据源码介绍visibilityOf方法，实际也是通过findElement()方法找到元素然后使用isDisplayed()
		 * 返回true,与webDriverWait等待配个使用，说白点就是isDisplayed()返回True跳出等待
		 */
		try {
			if(JSExecutorMethod.pageDOMLoadComplete()) {	
				WebDriverWait wait=new WebDriverWait(WebDriverMethod.ThreadDriver.get(), 10);
				wait.until(ExpectedConditions.visibilityOf(elemnet));
				logger.info("元素位置"+elemnet+"可见");
				waitResult=true;
			}
		}catch (Exception e) {
			logger.error("元素位置"+elemnet+"不可见，查找异常");
		}

		return waitResult;
	}

}
