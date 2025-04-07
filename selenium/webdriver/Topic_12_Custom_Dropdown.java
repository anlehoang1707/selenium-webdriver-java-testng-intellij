package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class Topic_12_Custom_Dropdown {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void initialBroswer() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_Run_On_Firefox() {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));

        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")));

        List<WebElement> allItems = driver.findElements(By.cssSelector(""));

        for (WebElement item: allItems) {
            System.out.print("item.getText()");
            if (item.getText().equals("")) {
                item.click();
                break;
            }
        }



    }

    private void selectCustomDropDownJQuery() {

    }
    @AfterClass
        public void closeBrowser() {
        driver.quit();
    }
}