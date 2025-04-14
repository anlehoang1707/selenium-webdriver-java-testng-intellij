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

public class Topic_13_Button {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();

    }

    @Test
    public void TC_01Topic_13_Button_Fahasha() {
        driver.get("https://www.fahasa.com/customer/account/create");
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();

        By buttonLoginCss = By.cssSelector("button.fhs-btn-login");
        Assert.assertFalse(driver.findElement(buttonLoginCss).isEnabled());
        String loginBackgroundColor = (driver.findElement(buttonLoginCss).getCssValue("background-color"));
        System.out.println("This is login button background color when nothing is typed:" + loginBackgroundColor);
        System.out.println(loginBackgroundColor);

        Color loginColor = Color.fromString(loginBackgroundColor);
        Assert.assertEquals(loginColor.asHex().toUpperCase(),"#000000");

        WebElement loginUserName = driver.findElement(By.cssSelector("#login_username"));
        WebElement loginPassword = driver.findElement(By.cssSelector("#login_password"));

        loginUserName.sendKeys("automationtest");
        loginPassword.sendKeys("123456789");
        Assert.assertFalse(driver.findElement(buttonLoginCss).isEnabled());

        loginUserName.clear();
        loginPassword.clear();

        loginUserName.sendKeys("automationtest@gmail.com");
        loginPassword.sendKeys("123456789");
        System.out.println(Color.fromString(driver.findElement(buttonLoginCss).getCssValue("background-color")).asHex().toUpperCase());
        System.out.println("This is login button background color when email is input in right format (using loginBackgroundColor):"+ loginBackgroundColor);
        System.out.println("This is login button background color when email is input in right format (NOT using loginBackgroundColor):" + driver.findElement(buttonLoginCss).getCssValue("background-color"));
        Assert.assertEquals(Color.fromString(driver.findElement(buttonLoginCss).getCssValue("background-color")).asHex().toUpperCase(),"#C92127");

        driver.findElement(By.cssSelector("button.fhs-btn-login")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.fhs-login-msg")).getText(),"Số điện thoại/Email hoặc Mật khẩu sai!");





    }

    @Test
    public void TC01_Button() {
        WebElement name = driver.findElement(By.id("name"));
    }

    @AfterClass
    public void closeBroswer() {
        driver.quit();
    }

}