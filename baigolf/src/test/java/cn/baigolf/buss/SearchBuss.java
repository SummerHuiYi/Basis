package cn.baigolf.buss;

import static org.testng.Assert.assertEquals;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import cn.baigolf.base.BasicConfigurationDriver;
import cn.baigolf.base.DriverBase;
import cn.baigolf.base.ImagesFile;
import cn.baigolf.base.LoginCommon;
import cn.baigolf.base.TestCaseBeforeAfterMethod;
import cn.baigolf.base.WebDriverMethod;
import cn.baigolf.handle.SearchPageHandle;
import cn.baigolf.util.ExcelUtil;

public class SearchBuss extends TestCaseBeforeAfterMethod{
	private static Logger logger = LogManager.getLogger(SearchBuss.class);
	
	@Test(dataProvider="search_data")
	private void search(String caseID,String webUrl,String testData,String expectedResult) throws InterruptedException {
				
		LoginCommon login=new LoginCommon();
		Map<String,String> map=ExcelUtil.analysisData(testData, ",", ":");
		String user="";
		String paw="";
		String courseSearch="广州";
		if(map.get("用户名")!=null) user=map.get("用户名");
		if(map.get("密码")!=(null)) paw=map.get("密码");
		if(map.get("搜索地区或高尔夫球场")!=(null)) courseSearch=map.get("搜索地区或高尔夫球场");
		//判断用户是否登录成功
		if(!login.login(webUrl, user, paw, expectedResult)) {
			ImagesFile.setImage( SearchBuss.class.getName(), "高尔夫球场-搜索", "第"+caseID+"用例，登录失败");
			logger.error("功能：高尔夫球场-搜索；信息：第"+caseID+"用例，登录失败");		
			assertEquals(false, true);		
		}else { 
			logger.info("功能：高尔夫球场-搜索；信息：第"+caseID+"用例，登录成功");	
			assertEquals(true, true);
			
		}
		SearchPageHandle searchPageHandle=new SearchPageHandle();
		//搜索地区或高尔夫球场
		searchPageHandle.course_search(courseSearch);
		//日期
		Date date=new Date(); 
		SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd"); 
		//无法利用Finby自定义数据初始化element
		//使用javascript写入今天
		((JavascriptExecutor)WebDriverMethod.ThreadDriver.get()).executeScript("$('input[id=datetimepicker]').attr('readonly',false).val('"+ft.format(
				  date)+"')");
		//时间
		searchPageHandle.selectBox_arrow();
		searchPageHandle.dateTime();
		//价格
		searchPageHandle.money();
		searchPageHandle.howMuch();
		//点击搜索
		searchPageHandle.hp_search();
		//判断是否搜索成功
		assertEquals(searchPageHandle.view_map(), true);
		
	}
	@DataProvider
	public Object[][] search_data() {
		return ExcelUtil.getExcelDate(this.getClass().getSimpleName(),BasicConfigurationDriver.getTestDataFilePath());
	}

}
