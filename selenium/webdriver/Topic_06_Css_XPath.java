package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_06_Css_XPath {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");
    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void Register_01_Empty_Data() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Actions
        driver.findElement(By.id("txtFirstname")).clear();
        driver.findElement(By.id("txtEmail")).clear();
        driver.findElement(By.id("txtCEmail")).clear();
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtCPassword")).clear();
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type = 'submit']")).click();

        // Verify the error messages display in register form
        // Cach 1
        String emailAddressErrorMessage = driver.findElement(By.id("txtFirstname-error")).getText();
        Assert.assertEquals(emailAddressErrorMessage, "Vui lòng nhập họ tên");

        // Cach 2 --> should use
        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
    }

    @Test
    public void Register_02_Invalid_Email_Address() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Actions
        driver.findElement(By.id("txtFirstname")).sendKeys("Hang Nhat");
        driver.findElement(By.id("txtEmail")).sendKeys("123@123@123");
        driver.findElement(By.id("txtCEmail")).sendKeys("123@123@123");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456");
        driver.findElement(By.id("txtPhone")).sendKeys("0973307326");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type = 'submit']")).click();

        // Verify the error message displays in Email and Confirm Email field
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
    }

    @Test
    public void Register_03_Incorrect_Confirm_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Actions
        driver.findElement(By.id("txtFirstname")).sendKeys("Hang Nhat");
        driver.findElement(By.id("txtEmail")).sendKeys("hangnguyen@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("hangnguyen@gmail.net");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456");
        driver.findElement(By.id("txtPhone")).sendKeys("0973307326");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type = 'submit']")).click();

        // Verify the error message displays in Confirm Email field
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
    }

    @Test
    public void Register_04_Invalid_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Actions
        driver.findElement(By.id("txtFirstname")).sendKeys("Hang Nhat");
        driver.findElement(By.id("txtEmail")).sendKeys("hangnguyen@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("hangnguyen@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("123");
        driver.findElement(By.id("txtCPassword")).sendKeys("123");
        driver.findElement(By.id("txtPhone")).sendKeys("0973307326");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type = 'submit']")).click();

        // Verify the error messages display in Password and Confirm Password field
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
    }

    @Test
    public void Register_05_Invalid_Confirm_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Actions
        driver.findElement(By.id("txtFirstname")).sendKeys("Hang Nhat");
        driver.findElement(By.id("txtEmail")).sendKeys("hangnguyen@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("hangnguyen@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123457");
        driver.findElement(By.id("txtPhone")).sendKeys("0973307326");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type = 'submit']")).click();

        // Verify the error messages display in Password and Confirm Password field
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");
    }

    @Test
    public void Register_06_Invalid_Phone_Number() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Phone less than 10 char
        driver.findElement(By.id("txtFirstname")).sendKeys("Hang Nhat");
        driver.findElement(By.id("txtEmail")).sendKeys("hangnguyen@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("hangnguyen@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456");
        driver.findElement(By.id("txtPhone")).sendKeys("097330732");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type = 'submit']")).click();

        // Verify the error messages displays in Phone field
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");

        // Phone more than 10 char
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("097330732678");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type = 'submit']")).click();

        // Verify the error messages displays in Phone field
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");

        // Phone # Phone Center number
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("1234567890");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type = 'submit']")).click();

        // Verify the error messages displays in Phone field
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }
}
