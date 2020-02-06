package com.AppiumFramework.script;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class InstallAPK {
	AndroidDriver driver;
	@BeforeMethod
	public void Bmethod() throws MalformedURLException
	{
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/Apps");
		File app = new File(appDir,"General-Store.apk");
		DesiredCapabilities cap=  new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
		cap.setCapability(MobileCapabilityType.UDID, "33008b8e4242a271");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy");
		cap.setCapability("app", app.getAbsolutePath());
		cap.setCapability("appPackage", "com.androidsample.generalstore");
		cap.setCapability("appActivity", ".SplashActivity");
		cap.setCapability("noReset", "true");
	
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	@Test
	public void mainScript() throws InterruptedException, IOException
	{
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Spinner").click();
		Dimension size = driver.manage().window().getSize();
		int startx=(int)(size.width*0.50);
		int starty=(int)(size.height*0.90);
		int endy=(int)(size.height*0.20);
		for(int i=0;i<10;i++)
		{
		driver.swipe(startx, starty, startx, endy, 1000);
		Thread.sleep(2000);
		}
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@text='India']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("hsaan");
driver.hideKeyboard();
	Thread.sleep(2000);
driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
Thread.sleep(2000);
driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Button").click();
Thread.sleep(2000);
	Dimension size1 = driver.manage().window().getSize();
	startx=(int)(size1.width*0.50);
	starty=(int)(size1.height*0.90);
	endy=(int)(size1.height*0.10);
	driver.swipe(startx, starty, startx, endy, 1000);
	Thread.sleep(2000);
	
	 driver.findElementByXPath("//android.widget.TextView[@text='ADD TO CART']").click();
	Thread.sleep(2000);
	driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.ImageButton").click();
	Thread.sleep(2000);
 WebElement product=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ImageView");
        File src=product.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("./Screenshot/shoe.png"));
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.Button[@text='Visit to the website to complete purchase']").click();
        Thread.sleep(2000);
      driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.Button").click();;
    Thread.sleep(3000);
	TakesScreenshot ts =(TakesScreenshot)driver;
	File src1 = ts.getScreenshotAs(OutputType.FILE);
	File dest1=new File("./Screenshot/google.png");
	FileUtils.copyFile(src1, dest1);
	Thread.sleep(2000);
	driver.quit();
	}

}
