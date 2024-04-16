package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_23_Frame_iFrame {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Form_Site() {
        // Trang A - domanin: formsite.com
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");
        driver.findElement(By.cssSelector("div#imageTemplateContainer>img")).click();
        sleepInSecond(5);

        // Iframe Element
        WebElement formIframe = driver.findElement(By.cssSelector("div#formTemplateContainer>iframe"));
        Assert.assertTrue(formIframe.isDisplayed());

        // Switch vào frame/ iframe/ trước khi thao tác với các element bên trong -> qua trang B
        //driver.switchTo().frame("frame-one85593366"); // name or id
        //driver.switchTo().frame(0); // index - không chính xác có thể bị thay đổi vị trí
        driver.switchTo().frame(formIframe); // element - ưu tiên

        // Tìm element trong iframe (tương tác với default dropdown list)
        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-2"))).selectByVisibleText("Sophomore");
        sleepInSecond(3);

        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-3"))).selectByVisibleText("West Dorm");
        sleepInSecond(3);

        driver.findElement(By.xpath("//label[text()='Male']")).click();

        // Switch ra lại trang A
        driver.switchTo().defaultContent();

        // Thao tác vs 1 element bên ngoài iframe (thuộc A)
        driver.findElement(By.cssSelector("nav.header--desktop-floater a.menu-item-login")).click();
        sleepInSecond(3);

        driver.findElement(By.cssSelector("button#login")).click();
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#message-error")).getText(), "Username and password are both required.");
    }

    @Test
    public void TC_02_Form_Site() {
        driver.get("https://skills.kynaenglish.vn/");

        // Switch vafo iFrame WeChat
        driver.switchTo().frame("cs_chat_iframe");

        driver.findElement(By.cssSelector("div.button_bar")).click();
        sleepInSecond(3);

        driver.findElement(By.cssSelector("input.input_name")).sendKeys("John Wick");
        driver.findElement(By.cssSelector("input.input_phone")).sendKeys ("0987655322");
        new Select(driver.findElement(By.cssSelector("select#serviceSelect"))).selectByVisibleText("TƯ VẤN TUYỂN SINH");
        driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys("Đăng kí khoá học");
        sleepInSecond(3);
    }

    @Test
    public void TC_03_Frame_HDFC_Bank() {
        driver.get("https://netbanking.hdfcbank.com/netbanking/");

        driver.switchTo().frame("login_page");

        driver.findElement(By.cssSelector("input[name='fldLoginUserId']")).sendKeys("luis_suarez");
        sleepInSecond(3);

        driver.findElement(By.cssSelector("a.login-btn")).click();
        sleepInSecond(5);

        driver.switchTo().defaultContent();

        driver.findElement(By.cssSelector("input#keyboard")).sendKeys("12312151235");
        sleepInSecond(5);
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
