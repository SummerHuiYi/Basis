package test;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cn.baigolf.base.TestCaseBeforeAfterMethod;
import cn.baigolf.base.WebDriverMethod;

public class Test{
	
	@org.testng.annotations.Test
	public void test() throws InterruptedException {
//		String a="SESSION=b20ecfc7-baee-4f78-b0a7-8a070b079ea8; isHide=true; pwdKey=150e44d4494fda25879355514e4ee97b; sid=sidb76ba5cc5ab33eae2517eceac5faab69; umckey=f0d1d8249b420f969fed4b6fbc454644; CmLocation=200|200; CmProvid=gd; appId=501143; token=5011430719205855Uxy8OkPz2liGkHuk; ST=201907192058560t518177LA6g32c9; _st=201907192058560t518177LA6g32c9; _a_m_b_b=13660870393~GZ~2; UC=201907192058560t518177LA6g32c9&1&&13660870393&BrandSzx&200; _a_h_b_c=GZ; CmLocationB=200%7C200; BIGipServerng3dmz_web=!U7W+bnqFRmxffkaAsTWMYBNpmm18lc9Pv4DQyAMvXvKnG5tVqCPRuEWKHL7iuwR0iCDRmPMJPrN3; _t_y_t_b_ip=; _gscu_1502255179=63541139r7nxso20; _gscbrs_1502255179=1; CmWebtokenid=13660870393,gd; WEB_SESSION=WEB_0d396d3f-d83d-410f-b705-159e773b9b75; JSESSIONID=0000jPKhYKWcZqQOkcE1lWQBEfU:1btc2fdg2; sendflag=20190727173422022259; CaptchaCode=QtYZuE; lgToken=180e8045f9464a14a2a810b207d2e173";
//		
//		WebDriverMethod.ThreadDriver.get().get("https://gd.10086.cn/open/index.asp");
//		Thread.sleep(1000);
//		
//		String[] cookieS=a.split(";");
//		
//		for(int i=0;i<cookieS.length;i++) {
//			String[] cookieKVS=cookieS[i].replaceAll("\\s", "").replaceAll("\n", "").split("=");
//			Cookie cookie;
//			if(cookieKVS.length==2) {
//				if(null==cookieKVS[1] || "".equals(cookieKVS[1])) {
//					cookie=new Cookie(cookieKVS[0], "");
//				}else {
//					cookie=new Cookie(cookieKVS[0], cookieKVS[1]);
//				}
//			}else {
//				cookie=new Cookie(cookieKVS[0], "");
//			}
//			
//			WebDriverMethod.ThreadDriver.get().manage().addCookie(cookie);
//		}
//
//	//	WebDriverMethod.ThreadDriver.get().manage().addCookie(new Cookie("WT_FPC", "id=2a2d49d3277219e105f1563541075648:lv=1563541960964:ss=1563541075648"));
//	//	WebDriverMethod.ThreadDriver.get().manage().addCookie(new Cookie("WT_FPC", "id=2a2d49d3277219e105f1563541075648:lv=1564220062909:ss=1564219975026"));
//		Thread.sleep(3000);
//		WebDriverMethod.ThreadDriver.get().navigate().refresh();
		
		
//		System.setProperty("webdriver.chrome.driver", "d:\\chromeDriver.exe");
//		Thread.sleep(3000);
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("user-data-dir=C:\\Users\\admin\\AppData\\Local\\Google\\Chrome\\User Data");
//		WebDriver driver=new ChromeDriver(options);
//		driver.get("https://gd.10086.cn/open/index.asp");
//		Thread.sleep(3000);
//		WebDriverMethod.ThreadDriver.get().navigate().refresh();
//		Thread.sleep(3000);
		
		System.setProperty("webdriver.chrome.driver", "d:\\chromeDriver.exe");
		WebDriver driver=new ChromeDriver();
//		Cookie cookie1=new Cookie("SESSION", "e94c573f-654e-4535-8021-950089492808");
//		Cookie cookie2=new Cookie("isHide", "true");
		driver.get("https://gd.10086.cn/open/index.asp");
		driver.manage().addCookie(new Cookie("SESSION", "e94c573f-654e-4535-8021-950089492808"));
		driver.manage().addCookie(new Cookie("isHide", "true"));
	
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		
	}

	
}
