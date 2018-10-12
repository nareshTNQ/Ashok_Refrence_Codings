package com.test.task;

import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class Main {
	public static WebDriver driver;
  
  @BeforeTest
  public void beforeTest() {
	  ChromeOptions chrome = new ChromeOptions();
	  chrome.addArguments("--start-maximized");
	  System.setProperty("webdriver.chrome.driver", "C://Users//12819//workspace//task//File//chromedriver.exe");
	  driver = new ChromeDriver(chrome);
	  driver.get("http://api.pcpeqa.tnq.co.in/index.php/clearSession/c5fd9cca64e390656ba5ff150c626237");
	  driver.get("http://ui.pcpeqa.tnq.co.in/en/index.html?token=c5fd9cca64e390656ba5ff150c626237&type=CQ");
  }

  @Test(priority = 1)
  public void fileUpload() throws InterruptedException, IOException {
	  System.out.println("*** Load Success ***");
	  Thread.sleep(20000);
	  driver.findElement(By.xpath("//*[@class='tour__close-btn-svg']")).click();
	  Thread.sleep(3000);
	  
	  Actions act = new Actions(driver);
	  WebElement ele = driver.findElement(By.xpath("//*[@id='body']/div[1]/span[1]"));
	 
	  act.doubleClick(ele).build().perform();
	  Thread.sleep(4000);
	  act.moveToElement(ele).click().perform();
	  act.moveToElement(ele).click().perform();
	  
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//article[@class='editor']//button[@title='Comment']")).click();
	  driver.findElement(By.xpath("//span[@title='Click to attach files']")).click();
	  
	  Thread.sleep(3000);
	  Runtime.getRuntime().exec("C:\\Users\\12819\\workspace\\task\\File\\File_upload_Script.exe");  
  }
  
  @Test(priority = 2)
  public void screenShot() throws IOException, InterruptedException
  {
	    
	    /*driver.get("http://ui.pcpeqa.tnq.co.in/en/index.html?token=c5fd9cca64e390656ba5ff150c626237&type=CQ");
	    Thread.sleep(20000);
		driver.findElement(By.xpath("//*[@class='tour__close-btn-svg']")).click();
		
		Actions act = new Actions(driver);
	    WebElement ele = driver.findElement(By.xpath("//*[@id='body']/div[1]/span[1]"));
	    act.moveToElement(ele).click().perform();*/
	    Thread.sleep(3000);
	    Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
	    ImageIO.write(fpScreenshot.getImage(),"PNG",new File("C:\\Users\\12819\\workspace\\task\\ScreenShots\\Image.png"));
  }
}
  
