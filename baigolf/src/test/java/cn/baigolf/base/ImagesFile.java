package cn.baigolf.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * @author 李国荣
 *封装了截图使用的方法
 */
public class ImagesFile {
	private static File srcFile;
	private static Logger logger = LogManager.getLogger(ImagesFile.class);
	public static void setImage(String className,String functionName,String message) {
		try {
			Date dNow = new Date( );
		    SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh-mm-ss-SSS");
			srcFile=((TakesScreenshot)WebDriverMethod.getWebDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile,new File("d:\\imgs\\"+className+"_"+functionName+"_"+message+"_"+ft.format(dNow)+".png"));
			logger.info("截图成功");
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("截图失败");
		}
	}
	
}
