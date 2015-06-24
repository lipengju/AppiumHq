package lession1;

/*
 * 
 * Android计数器的测试代码
 * */

import static org.testng.AssertJUnit.assertEquals;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.net.URL;

import javax.management.DescriptorKey;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCalculator 
{
	public AppiumDriver driver;
	
	
	@BeforeClass
	public void initalAppiumSettings()throws MalformedURLException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		
		cap.setCapability("platforName", "Android");
		//deviceName名称见:Google Nexus 10-4.4.4
//		cap.setCapability("deviceName", "Android Emulator");
		cap.setCapability("deviceName", "Google Nexus 10-4.4.4");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appWaitActivity", "com.android.calculator2.Calculator");
		cap.setCapability("appWaitPackage", "com.android.calculator2");
		//不重要的元素可以忽略
		cap.setCapability("ignoreUnimportantViews", "true");
		
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	}
	
	
	@Test
	@DescriptorKey("计算机实现2+2=4的计算过程")
	public void plus()throws InterruptedException
	{
		//点击2
		driver.findElement(By.id("com.android.calculator2:id/digit2")).click();
		//点击+号
		driver.findElement(By.id("com.android.calculator2:id/plus")).click();
		//再点击2
		driver.findElement(By.id("com.android.calculator2:id/digit2")).click();
		//点击=号
		driver.findElement(By.id("com.android.calculator2:id/equal")).click();
		
		String text=driver.findElement(By.className("android.widget.EditText")).getText();
		
//		//初始化操作
//		driver.findElement(By.className("android.widget.ImageButton")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit0")).click();
		
		try{
			Thread.sleep(3000);
		}catch(Exception e){
			e.printStackTrace();
		}
		//断言验证是否正确
		assertEquals("4", text); 
		
	}
	
	@Test
	@DescriptorKey("计算减")
	public void  Redu()
	{
		driver.findElement(By.id("com.android.calculator2:id/digit9")).click();
		//减
		driver.findElement(By.id("com.android.calculator2:id/minus")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit2")).click();
		driver.findElement(By.id("com.android.calculator2:id/equal")).click();
		String text=driver.findElement(By.className("android.widget.EditText")).getText();
		driver.findElement(By.id("com.android.calculator2:id/digit0")).click();
		assertEquals("7", text); 
	}
	
	@Test
	@DescriptorKey("计数器的乘法测试")
	public void take()
	{
		driver.findElement(By.id("com.android.calculator2:id/digit9")).click();
		//乘
		driver.findElement(By.id("com.android.calculator2:id/mul")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit2")).click();
		driver.findElement(By.id("com.android.calculator2:id/equal")).click();
		String text=driver.findElement(By.className("android.widget.EditText")).getText();
		driver.findElement(By.id("com.android.calculator2:id/digit0")).click();
		assertEquals("18", text); 
	}
	
	
	@Test
	@DescriptorKey("计数器的乘法测试")
	public void addition()
	{
		driver.findElement(By.id("com.android.calculator2:id/digit9")).click();
		//除号
		driver.findElement(By.id("com.android.calculator2:id/div")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit2")).click();
		driver.findElement(By.id("com.android.calculator2:id/equal")).click();
		String text=driver.findElement(By.className("android.widget.EditText")).getText();
		driver.findElement(By.id("com.android.calculator2:id/digit0")).click();
		assertEquals("4.5", text); 
	}
	
	
	
	
	@AfterClass
	public void realse()
	{
		driver.quit();
	}
}
