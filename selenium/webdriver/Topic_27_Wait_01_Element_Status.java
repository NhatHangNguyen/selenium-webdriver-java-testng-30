package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_27_Wait_01_Element_Status {

    WebDriver driver;

    WebDriverWait explicitWait;

    By reconfirmEmailTextBox = By.cssSelector("input[name='reg_email_confirmation__']");

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_01_Visible() {
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        sleepInSecond(2);

        driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("hangnguyen@gmail.com");
        sleepInSecond(3);

        // Điều kiện 1 - Element có xuất hiện ở trên UI và có trong cây HTML
        // Tại đúng thời điểm này/ step này thì confirm Email textbox đang visible/ displayed
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(reconfirmEmailTextBox));

        // Kiểm tra 1 element đang hiện thị
        Assert.assertTrue(driver.findElement(reconfirmEmailTextBox).isDisplayed());
    }

    @Test
    public void TC_02_Invisible_In_DOM() {
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        sleepInSecond(2);

        // Điều kiện 2 - Element không xuất hiện trên UI và vẫn có trong cây HTML
        driver.findElement(By.cssSelector("input[name='reg_email__']")).clear();
        sleepInSecond(3);

        // Tại đúng thời điểm này/ step này thì confirm Email textbox đang invisible
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(reconfirmEmailTextBox));

        // Kiểm tra 1 element khong hiện thị
        // Chạy nhanh -> Kết quả step này passed
        Assert.assertFalse(driver.findElement(reconfirmEmailTextBox).isDisplayed());
    }

    @Test
    public void TC_02_Invisible_Not_In_DOM() {
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        sleepInSecond(2);

        // Click vào icon close để đóng popup lại
        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
        sleepInSecond(3);

        // Điều kiện 3 - Element không xuất hiện trên UI và cũng không có trong cây HTML
        // Tại đúng thời điểm này/ step này thì confirm Email textbox đang invisible
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(reconfirmEmailTextBox));

        // Kiểm tra 1 element khong hiện thị
        // Chạy lâu -> Kết quả step này failed
        //Assert.assertFalse(driver.findElement(reconfirmEmailTextBox).isDisplayed());
    }

    @Test
    public void TC_03_Presence() {
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        sleepInSecond(2);

        driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("hangnguyen@gmail.com");
        sleepInSecond(3);

        // Điều kiện 1 - Element có xuất hiện ở trên UI và có trong cây HTML
        // Tại đúng thời điểm này/ step này thì confirm Email textbox đang presence (có trong HTML)
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(reconfirmEmailTextBox));

        driver.findElement(By.cssSelector("input[name='reg_email__']")).clear();
        sleepInSecond(3);

        // Điều kiện 2 - Element không xuất hiện trên UI và vẫn có trong cây HTML
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(reconfirmEmailTextBox));
    }

    @Test
    public void TC_04_Staleness() {
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        sleepInSecond(2);

        // Tại thời điểm này element có xuất hiện và mình sẽ findElement
        WebElement reconfirmEmail = driver.findElement(reconfirmEmailTextBox);

        // Click vào icon close để đóng popup lại
        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
        sleepInSecond(3);

        // Điều kiện 3 - Element không xuất hiện trên UI và cũng không có trong cây HTML
        // Wait until an element is no longer attached to the DOM
        explicitWait.until(ExpectedConditions.stalenessOf(reconfirmEmail));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
