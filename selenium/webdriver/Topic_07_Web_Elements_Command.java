package webdriver;

import dev.failsafe.internal.util.Durations;
import graphql.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.SocketOption;
import java.time.Duration;

public class Topic_07_Web_Elements_Command {
    WebDriver driver;

    WebElement element;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
    }

    ;

    @Test
    public void TC01_isDisplayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        Assert.assertTrue(driver.findElement(By.cssSelector("input#email")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Under 18')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Education')]")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//h5[contains(text(),'User5')]")).isDisplayed());

    }

    @Test
    public void TC02_isEnabled() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        //Step 02: Kiểm tra các phần tử sau enable trên trang
        Assert.assertTrue(driver.findElement(By.cssSelector("input#email")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Under 18')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Education')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//label[@for = 'job1']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//label[@for = 'job2']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("#development")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("#slider-1")).isDisplayed());

        //Step 03: Kiểm tra csac phần tử sau disable trên trang
        Assert.assertFalse(driver.findElement(By.cssSelector("#disable_password")).isEnabled());
        Assert.assertFalse(driver.findElement(By.cssSelector("#check-disbaled")).isEnabled());
        Assert.assertFalse(driver.findElement(By.cssSelector("#bio")).isEnabled());
        Assert.assertFalse(driver.findElement(By.cssSelector("#job3")).isEnabled());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@type ='checkbox' and @disabled='disabled']")).isEnabled());
        Assert.assertFalse(driver.findElement(By.cssSelector("#slider-2")).isEnabled());

        //Step 04: Log ra Console là phần tử đó có enabled trên trang hay không
    }

    @Test
    public void TC03_isSelected() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        //Step 02: Click chọn
        driver.findElement(By.cssSelector("input#under_18")).click();
        driver.findElement(By.cssSelector("input#java")).click();

        //Step 03: Kiểm tra các phần tử
        Assert.assertTrue(driver.findElement(By.cssSelector("input#under_18")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input#java")).isSelected());

        //Log
        if (driver.findElement(By.cssSelector("input#under_18")).isSelected()) {
            System.out.println("Element is selected");
        } else {
            System.out.println("Element is de-selected");
        };

        if (driver.findElement(By.cssSelector("input#java")).isSelected()) {
            System.out.println("Element is selected");
        } else {
            System.out.println("Element is de-selected");
        }

    };

    @Test
    public void TC04_Register_function_MailChimp () {
        //Step 01: Truy cập vào trang mailchimp
        driver.get("https://login.mailchimp.con/signup/");

        //Step 02: Nhập dữ liệu hợp lệ vào Email

    }
}

