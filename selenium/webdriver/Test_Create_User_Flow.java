 package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

 public class Test_Create_User_Flow {
     WebDriver driver;

     @BeforeClass
     public void initialBrowser() {
         driver = new ChromeDriver();

     }

     @Test
     public void TC_01_View_Add_Employee_Page() throws InterruptedException {
         driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
         Thread.sleep(3000);
         driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
         driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
         driver.findElement(By.xpath("//button[text()=' Login ']")).click();
         Thread.sleep(3000);
         driver.findElement(By.xpath("//a[@href ='/web/index.php/pim/viewPimModule']")).click();
         Thread.sleep(3000);
         driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
         Thread.sleep(3000);
         Assert.assertTrue(driver.findElement(By.cssSelector("input[name='firstName']")).isEnabled());
         Assert.assertTrue(driver.findElement(By.cssSelector("input[name='middleName']")).isEnabled());
         Assert.assertTrue(driver.findElement(By.cssSelector("input[name='lastName']")).isEnabled());
//         Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'oxd-grid-2')]//input[@class = 'oxd-input oxd-input--active']']")).isEnabled());

////a[@class = 'oxd-main-menu-item' and @href ='/web/index.php/pim/viewPimModule']
     }

     @AfterClass
     public void closeBroswer() {
         driver.quit();
     }
 }