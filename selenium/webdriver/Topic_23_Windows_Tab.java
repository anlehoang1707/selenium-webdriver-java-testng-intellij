 package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

 public class Topic_23_Windows_Tab {
     //Khai báo Driver và Actions.
     WebDriver driver;

     @BeforeClass
     public void initialBrowser() {
         driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


     }

     @Test
     public void TC_13_Window() throws InterruptedException {
         driver.get("https://automationfc.github.io/basic-form/index.html");
         Thread.sleep(5000);
         driver.findElement(By.xpath("//a[text() = 'GOOGLE']")).click();
         String githubTitle = driver.getTitle();

        // Lấy Window Id của tab hiện tại là Github
         String githubWindowId = driver.getWindowHandle();
         Thread.sleep(2000);

        // Lấy Window Ids của tất cả các tab
         switchToAnotherWindowById(githubWindowId);
         Thread.sleep(2000);
         //Kiểm tra title của window mới = Google
         Assert.assertEquals(driver.getTitle(),"Google");
         String googleWindowId = driver.getWindowHandle();
         // Switch về parent window là github
         driver.switchTo().window(githubWindowId);
         Thread.sleep(2000);
         // Click Facebook link => switch qua tab mới (lúc này đang ở github)
         driver.findElement(By.xpath("//a[text() = 'FACEBOOK']")).click();

         switchToWindowByTitle("Facebook - log in or sign up");
         Assert.assertEquals(driver.getTitle(),"Facebook – log in or sign up");

         driver.switchTo().window(githubWindowId);
         Thread.sleep(2000);

         driver.findElement(By.xpath("//a[text() = 'TIKI']")).click();

         switchToWindowByTitle("Mua Hàng Trực Tuyến Uy Tín với Giá Rẻ Hơn tại Tiki.vn");
         Assert.assertEquals(driver.getTitle(),"Mua Hàng Trực Tuyến Uy Tín với Giá Rẻ Hơn tại Tiki.vn");


         closeAllOtherWindows(githubWindowId);

//

     }

     private void closeAllOtherWindows(String parentWindowId) throws InterruptedException {
         Set<String> allWindowsId = driver.getWindowHandles();
         for (String id: allWindowsId) {
             if (!id.equals(parentWindowId)) {
                 driver.switchTo().window(id);
                 Thread.sleep(2000);
                 driver.close();
             }
         }
     }

     private void switchToWindowByTitle(String expectedTitle) throws InterruptedException {
         Set<String> allWindowsId = driver.getWindowHandles();
         for (String id :allWindowsId) {
             driver.switchTo().window(id);
             String pageTitle = driver.getTitle();
             Thread.sleep(2000);

             if(pageTitle.equals(expectedTitle)) {
                 break;
             }
         }
         ;
     }

     // Chỉ đúng với 2 window
     private void switchToAnotherWindowById(String WindowId) {
         Set<String> allWindowsId = driver.getWindowHandles();

         for (String id :allWindowsId) {
             if (!id.equals(WindowId)) {
                 driver.switchTo().window(id);
             };
         }
         ;
     }


     @AfterClass
     public void closeBroswer() {
         //driver.quit();
     }

 }