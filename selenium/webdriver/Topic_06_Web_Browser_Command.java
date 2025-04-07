package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Web_Browser_Command {
        WebDriver driver;
    @BeforeClass
        public void initialBrowser() {
            driver = new FirefoxDriver();
    }

    @Test
        public void TC01_Verify_Url () {
            driver.get("https://live.techpanda.org/");
            driver.findElement(By.xpath("//div[@class = 'footer']//a[@title = 'My Account']")).click();
            Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/customer/account/login/");
            driver.findElement(By.cssSelector("a[title = \"Create an Account\"]")).click();
            Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/customer/account/create/");
        }

    @Test
        public void TC02_Verify_Title () {
            driver.get("https://live.techpanda.org/");
            driver.findElement(By.xpath("//div[@class = 'footer']//a[@title = 'My Account']")).click();
            Assert.assertEquals(driver.getTitle(),"Customer Login");
            driver.findElement(By.cssSelector("a[title = 'Create an Account']")).click();
            Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
    }

    @Test
        public void TC03_Navigate_function () {
            driver.get("https://live.techpanda.org/");
            driver.findElement(By.xpath("//div[@class = 'footer']//a[@title = 'My Account']")).click();
            driver.findElement(By.cssSelector("a[title = 'Create an Account']")).click();
            Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/customer/account/create/");
            driver.navigate().back();
            Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/customer/account/login/");
            driver.navigate().forward();
            Assert.assertEquals(driver.getTitle(),"Create New Customer Account");

    }

    @Test
        public void TC04_Get_Page_Source () {
            driver.get("https://live.techpanda.org/");
            driver.findElement(By.xpath("//div[@class = 'footer']//a[@title = 'My Account']")).click();
            Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
            driver.findElement(By.cssSelector("a[title = 'Create an Account']")).click();
            Assert.assertTrue(driver.getPageSource().contains("Create an Account"));

    }

    @AfterClass
        public void closeBrowser() {
            driver.quit();
    }
}
