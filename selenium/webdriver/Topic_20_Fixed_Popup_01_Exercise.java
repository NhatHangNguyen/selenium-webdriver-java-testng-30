package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_20_Fixed_Popup_01_Exercise {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Fixed_Popup_In_DOM_01() {
        driver.get("https://ngoaingu24h.vn/");

        driver.findElement(By.cssSelector("button.login_")).click();
        sleepInSecond(3);

        By loginPopup = By.cssSelector("div[id='modal-login-v1'][style]>div");

        // Kiểm tra Đăng nhập popup hiển thị
        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());

        // Enter username/password = automationfc
        driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] input#account-input")).sendKeys("automationfc");
        driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] input#password-input")).sendKeys("automationfc");
        driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] button.btn-login-v1")).click();
        sleepInSecond(3);

        // Verify msg hien thi
        Assert.assertEquals(driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] div.error-login-panel")).getText(),"Tài khoản không tồn tại!");

        // Close pop-up
        driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] button.close")).click();
        sleepInSecond(2);

        // Verify Login pop-up khong hien thi
        Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());
    }

    @Test
    public void TC_02_Fixed_Popup_In_DOM_02() {
        driver.get("https://skills.kynaenglish.vn/");

        driver.findElement(By.xpath("//a[@href='trang-ca-nhan/khoa-hoc']/img")).click();
        sleepInSecond(3);

        // Kiểm tra pop-up Login hiển thị
        Assert.assertTrue(driver.findElement(By.cssSelector("div#k-popup-account-login-mb div.modal-content")).isDisplayed());

        driver.findElement(By.cssSelector("input#user-login")).sendKeys("automationfc@gmail.com");
        driver.findElement(By.cssSelector("input#user-password")).sendKeys("123456");
        driver.findElement(By.cssSelector("button#btn-submit-login")).click();
        sleepInSecond(2);

        // Verify error message hiển thị
        Assert.assertEquals(driver.findElement(By.cssSelector("div#password-form-login-message")).getText(), "Sai tên đăng nhập hoặc mật khẩu");
    }

    @Test
    public void TC_03_Fixed_Popup_Not_In_DOM_01() {
       driver.get("https://tiki.vn/");

       driver.findElement(By.xpath("//span[text()='Tài khoản']")).click();
       sleepInSecond(3);

       // Verify popup display
        Assert.assertTrue(driver.findElement(By.cssSelector("div.ReactModal__Content")).isDisplayed());

        // Click Dang nhap bang email
        driver.findElement(By.cssSelector("p.login-with-email")).click();

        // Khong nhap du lieu > Click Dang nhap
        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
        sleepInSecond(2);

        // Verify error text hien thi duoi field email va password
        Assert.assertEquals(driver.findElement(By.xpath("//input[@type='email']/parent::div/following-sibling::span[1]")).getText(),"Email không được để trống");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@type='password']/parent::div/following-sibling::span[1]")).getText(),"Mật khẩu không được để trống");

        // Close popup
        driver.findElement(By.cssSelector("button.btn-close")).click();
        sleepInSecond(2);

        // Khi popup đóng lại thì HTML không còn trong thẻ DOM nữa
        // findElement should not be used to look for non-present elements, user findElements(By) and assert zero length response
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(driver.findElements(By.cssSelector("div.ReactModal__Content")).size(), 0);
    }

    @Test
    public void TC_04_Fixed_Popup_Not_In_DOM_02() {
        driver.get("https://www.facebook.com/");

        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        sleepInSecond(3);

        Assert.assertTrue(driver.findElement(By.cssSelector("div.registration_redesign")).isDisplayed());

        driver.findElement(By.cssSelector("img._8idr.img")).click();
        sleepInSecond(3);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(driver.findElements(By.cssSelector("div.registration_redesign")).size(),0);
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
