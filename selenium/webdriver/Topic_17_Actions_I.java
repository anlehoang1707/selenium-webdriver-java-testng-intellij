 package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

 public class Topic_17_Actions_I {
     //Khai báo Driver và Actions.
     WebDriver driver;
     Actions action;

     @BeforeClass
     public void initialBrowser() {
         driver = new FirefoxDriver();
         driver.get("https:/demo.nopcommerce.com/register?returnUrl=%2F");
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
         action = new Actions(driver);--

     }

     @Test
     public void TC_01_() {


     }

     @AfterClass
     public void closeBroswer() {
         driver.quit();
     }

 }