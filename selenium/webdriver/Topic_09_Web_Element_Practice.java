package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Topic_09_Web_Element_Practice {
    WebDriver driver;

@BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
}

@Test
    public void TC_01_Verify_Url() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='email' and @id='mail']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='email' and @id='mail']")).isDisplayed());

}



@AfterClass
    public void closeBrowser() {
        driver.quit();
}
}
