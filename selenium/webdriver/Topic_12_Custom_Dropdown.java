package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
    public void TC_01_JQuery() throws InterruptedException {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        selectCustomDropDown("#speed-button","ul#speed-menu>li>div", "Faster");
        Assert.assertEquals(driver.findElement(By.cssSelector("#speed-button")).getText(),"Faster");

        selectCustomDropDown("#files-button","ul#files-menu>li>div", "Some unknown file");
        Assert.assertEquals(driver.findElement(By.cssSelector("#files-button")).getText(),"Some unknown file");

        selectCustomDropDown("#number-button","ul#number-menu>li>div", "19");
        Assert.assertEquals(driver.findElement(By.cssSelector("#number-button")).getText(),"19");

        selectCustomDropDown("#salutation-button","ul#salutation-menu>li>div", "Mrs.");
        Assert.assertEquals(driver.findElement(By.cssSelector("#salutation-button")).getText(),"Mrs.");

    }

    @Test
    public void TC_02_ReactJS () throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

        selectCustomDropDown("#root","#root>div>div>div>div", "Elliot Fu");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class = 'divider text']")).getText(),"Elliot Fu");
    }

    @Test
    public void TC_03_VueJS () throws InterruptedException {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
        selectCustomDropDown("li.dropdown-toggle","ul.dropdown-menu>li>a", "First Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"First Option");
    }

    @Test
    public void TC_04_Editable () throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
        inputCustomDropDown("input.search","div[role = 'listbox']>div>span", "Argentina");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[role = 'combobox']>div")).getText(),"Argentina");
    }

    private void selectCustomDropDown(String parentCss, String childCss, String itemText) throws InterruptedException {
        // Wait until the parent element (drop down text box, drop down icon) is clickable, then click
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(parentCss))).click();

        //Wait until all elements are presence, the below will return the List <WebElement>
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));
        Thread.sleep(2000);

        for (WebElement item: allItems) {
            System.out.print("item.getText()");
            if (item.getText().equals(itemText)) {
                item.click();
                break;
            }
        }
    }

    private void inputCustomDropDown(String parentCss, String childCss, String itemText) throws InterruptedException {
        // Wait until the parent element (drop down text box, drop down icon) is Input-able, then input
        WebElement textBoxDropDown = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(parentCss)));
        textBoxDropDown.clear();
        textBoxDropDown.sendKeys(itemText);
        Thread.sleep(2000);

        //Wait until all elements are presence, the below will return the List <WebElement>
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));

        for (WebElement item: allItems) {
            System.out.print("item.getText()");
            if (item.getText().equals(itemText)) {
                item.click();
                break;
            }
        }
    }

    @AfterClass
        public void closeBrowser() {
        driver.quit();
    }
}