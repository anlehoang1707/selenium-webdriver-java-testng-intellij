package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Xpath_Css {
    WebDriver driver;

    @BeforeClass
        public void initialBrowser() {
            driver = new FirefoxDriver();


    }

    @Test
        public void Register_01_Empty_Data() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        //Action
        driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();

        //Assert
        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(),"Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Vui lòng nhập mật khẩu");

    }

    @Test
    public void Register_02_Invalid_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        //Action
        driver.findElement(By.id("txtFirstname")).sendKeys("John Doe");
        driver.findElement(By.id("txtEmail")).sendKeys("123@123@123");
        driver.findElement(By.id("txtCEmail")).sendKeys("123@123@123");
        driver.findElement(By.id("txtPassword")).sendKeys("abcdefg");
        driver.findElement(By.id("txtCPassword")).sendKeys("abcdefg");
        driver.findElement(By.id("txtPhone")).sendKeys("0909090909");



        driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();

        //Assert
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");
    }

    @Test
    public void Register_03_Invalid_Confirm_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        //Action
        driver.findElement(By.id("txtFirstname")).sendKeys("John Wick");
        driver.findElement(By.id("txtEmail")).sendKeys("johnwick@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("johnwicky@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("abcdefg");
        driver.findElement(By.id("txtCPassword")).sendKeys("abcdefg");
        driver.findElement(By.id("txtPhone")).sendKeys("0909090909");



        driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();

        //Assert
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");
    }

    @Test
    public void Register_04_Invalid_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        //Action
        driver.findElement(By.id("txtFirstname")).sendKeys("John Wick");
        driver.findElement(By.id("txtEmail")).sendKeys("johnwick@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("johnwick@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("abcd");
        driver.findElement(By.id("txtCPassword")).sendKeys("abcd");
        driver.findElement(By.id("txtPhone")).sendKeys("0909090909");



        driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();

        //Assert
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
    }

    @Test
    public void Register_05_Incorrect_Confirm_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        //Action
        driver.findElement(By.id("txtFirstname")).sendKeys("John Wick");
        driver.findElement(By.id("txtEmail")).sendKeys("johnwick@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("johnwick@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("abcdefg");
        driver.findElement(By.id("txtCPassword")).sendKeys("abcdefh");
        driver.findElement(By.id("txtPhone")).sendKeys("0909090909");



        driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();

        //Assert
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu bạn nhập không khớp");
    }

    @Test
    public void Register_06_Invalid_Phone() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        //Action
        driver.findElement(By.id("txtFirstname")).sendKeys("John Wick");
        driver.findElement(By.id("txtEmail")).sendKeys("johnwick@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("johnwick@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("abcdefg");
        driver.findElement(By.id("txtCPassword")).sendKeys("abcdefg");
        driver.findElement(By.id("txtPhone")).sendKeys("093132");


        driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();

        //Assert
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");


        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("0134456789");

        driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();

        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
    }



    @AfterClass
    public void cleanBrowser() { driver.quit(); }

}
