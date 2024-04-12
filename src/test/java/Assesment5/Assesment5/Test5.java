package Assesment5.Assesment5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test5 {
	@Test(dataProvider="testdata")
	public void Test(String a,String b,String c) throws InterruptedException {
	WebDriver driver;
	System.setProperty("webdriver.chrome.driver","D:\\all_drivers\\chromedriver-win64_new\\chromedriver.exe");
	driver = new ChromeDriver();
    driver.get("https://tutorialsninja.com/demo/");
    
  driver.manage().window().maximize();
  driver.navigate().to("https://tutorialsninja.com/demo/index.php?route=account/login");
  driver.findElement(By.id("input-email")).sendKeys(a);
  driver.findElement(By.id("input-password")).sendKeys(b);
  WebElement loginbutton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/form/input"));
  loginbutton.click();
  
  WebElement home =driver.findElement(By.xpath("/html/body/header/div/div/div[1]/div/h1/a"));
  home.click();
  WebElement mac = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/h4/a"));
  mac.click();
  
  WebElement addtocartmac = driver.findElement(By.id("button-cart"));
  addtocartmac.click();
  driver.navigate().to("https://tutorialsninja.com/demo/");
  WebElement addtocartiphone = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div[3]/button[1]"));
  addtocartiphone.click();
  Thread.sleep(3000);
  WebElement addtocart = driver.findElement(By.xpath("/html/body/header/div/div/div[3]/div/button"));
  addtocart.click();
  Thread.sleep(3000);
  WebElement checkout1 = driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]/strong"));
  checkout1.click();
  WebElement checkout2 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[3]/div[2]/a"));
  checkout2.click();
  
  WebElement continueShoping = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[3]/div[2]/a"));
  continueShoping.click();
  Assert.assertTrue(driver.getTitle().equals("Shopping Cart"), "Title does not match expected title");
  driver.quit();
	}
	@DataProvider (name = "testdata")
	public Object[][] loginTC(){
		return new Object[][] {{"BothCorrect", "k.sakthi55555@gmail.com","sakthi"},
                               {"User", "standard_user","Admin123"},
                               {"Password", "tct","secret_sauce"},
                               {"BothInCoorect", "admin","admin"}
                                       };
							}
} 
