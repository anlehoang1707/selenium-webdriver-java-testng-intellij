 package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
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
     String osName = System.getProperty("os.name");
     Keys keys;
     JavascriptExecutor executor;

     @BeforeClass
     public void initialBrowser() {
         driver = new EdgeDriver();

         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
         action = new Actions(driver);
         keys = osName.startsWith("Windows") ? Keys.CONTROL : Keys.COMMAND;


     }

     @Test
     public void TC_02_DoubleClick() throws InterruptedException {
         driver.get("https://automationfc.github.io/basic-form/index.html");
         driver.manage().window().maximize();
         WebElement doubleClickButton = driver.findElement(By.xpath("//button[text() = 'Double click me']"));
         action.doubleClick(doubleClickButton).perform();
         Assert.assertEquals(driver.findElement(By.cssSelector("div.container p#demo")).getText(),"Hello Automation Guys!");

//

     }

     @Test
     public void TC_02_FHS() throws InterruptedException {
         driver.get("https://www.fahasa.com/");
         Thread.sleep(3000);

         //driver.findElement(By.cssSelector("g#close-popup")).click();
         action.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();
         Thread.sleep(2000);

         action.moveToElement(driver.findElement(By.cssSelector("a[title = 'Hành Trang Đến Trường']"))).perform();
         Thread.sleep(2000);

         driver.findElement(By.xpath("//div[contains(@class, 'fhs_menu_content')]//a[text() = 'Luyện Thi Môn Toán']")).click();

         Assert.assertTrue(driver.findElement(By.xpath("//ol[@class='breadcrumb']//strong[text()='Toán']")).isDisplayed());

         //Câu hỏi: Nếu wait lâu hơn thì pop-up quảng cáo hiện ra, làm Test Case fail làm sao để handle?



     }

     @Test
     public void TC_01_FHS() throws InterruptedException {
         driver.get("https://www.fahasa.com/");
         //Thread.sleep(3000);

         action.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();
         //Thread.sleep(2000);

         action.moveToElement(driver.findElement(By.cssSelector("a[title = 'Hành Trang Đến Trường']"))).perform();
         //Thread.sleep(2000);

         driver.findElement(By.xpath("//div[contains(@class, 'fhs_menu_content')]//a[text() = 'Luyện Thi Môn Toán']")).click();

         Assert.assertTrue(driver.findElement(By.xpath("//ol[@class='breadcrumb']//strong[text()='Toán']")).isDisplayed());

     }


     @AfterClass
     public void closeBroswer() {
         //driver.quit();
     }

 }