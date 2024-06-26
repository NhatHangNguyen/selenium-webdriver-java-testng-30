package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_28_Wait_02_Find_Element {

    WebDriver driver;

    WebDriverWait explicitWait;

    FluentWait<WebDriver> fluentWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        // Implicit Wait
        // Set implicit = Selenium version 4.x trở lên
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_01_FindElement() {
        // Case 1 - Element được tìm thấy chỉ 1
        // Sẽ không cần chờ hết timeout
        // Tìm thấy sẽ trả về 1 WebElement
        // Qua step tiếp theo
        System.out.println("Start step: " + getDateTimeNow());
        driver.findElement(By.cssSelector("input#email"));
        System.out.println("End step: " + getDateTimeNow());

        // Case 2 - Element được tìm thấy nhưng có nhiều hơn 1
        // Sẽ không cần chờ hết timeout
        // Lấy element đầu tiên dù có cả n node
        System.out.println("Start step: " + getDateTimeNow());
        driver.findElement(By.cssSelector("input[type='text'],[type='password']")).sendKeys("hangcnnguyen@gmail.com");
        System.out.println("End step: " + getDateTimeNow());

        // Case 3 - Element không được tìm thấy
        // Chờ hết timeout là 10s
        // Trong thời gian 10s này cứ mỗi nửa s sẽ tìm lại 1 lần
        // Case 1: Nếu tìm lại mà không thấy thì failed testcase này và throw exception: NoSuchElementException
        // Các step còn lại không chạy nữa
        System.out.println("Start step: " + getDateTimeNow());
        driver.findElement(By.cssSelector("input#not-found"));
        System.out.println("End step: " + getDateTimeNow());

        // Case 2: Nếu tìm lại mà thấy thì cũng trả về element rồi qua step tiếp theo
        System.out.println("Start step: " + getDateTimeNow());
        driver.findElement(By.cssSelector("input[name='reg_email__']"));
        System.out.println("End step: " + getDateTimeNow());
    }

    @Test
    public void TC_02_FindElements() {
        List<WebElement> elementList;

        // Case 1 - Element được tìm thấy chỉ có 1 element
        // Không cần chờ hết timeout 10s
        // Trả về List element chứa đúng 1 element
        System.out.println("Start step: " + getDateTimeNow());
        elementList = driver.findElements(By.cssSelector("input#email"));
        System.out.println("List have: " + elementList.size());
        System.out.println("End step: " + getDateTimeNow());

        // Case 2 - Element được tìm thấy nhưng có nhiều hơn 1
        // Không cần chờ hết timeout 10s
        // Trả về List element chứa nhiều element
        System.out.println("Start step: " + getDateTimeNow());
        elementList = driver.findElements(By.cssSelector("input[type='text'],[type='password']"));
        System.out.println("List have: " + elementList.size());
        System.out.println("End step: " + getDateTimeNow());

        // Case 3 - Element không được tìm thấy
        // Chờ hết timeout là 10s
        // Mỗi nửa s cũng tìm lại 1 lần (polling)
        // Nếu trong thời gian tìm lại mà thấy element thì cũng trả về List chứa các element đó
        // Nếu hết thời gian tìm lại mà không thấy thì trả về 1 List rỗng (empty) và không đánh failed test case
        // Qua step tiếp thep
        System.out.println("Start step: " + getDateTimeNow());
        elementList = driver.findElements(By.cssSelector("input[name='reg_email__']"));
        System.out.println("List have: " + elementList.size());
        System.out.println("End step: " + getDateTimeNow());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    // Lúc bắt đầu chạy và lúc kết thúc
    public static String getDateTimeNow() {
        Date date = new Date();
        return  date.toString();
    }
}
