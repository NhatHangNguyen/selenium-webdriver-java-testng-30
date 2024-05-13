package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.regex.Pattern;

public class Topic_31_Wait_05_Explicit_01_Knowledge {

    WebDriver driver;

    WebDriverWait explicitWait; // Khai báo chưa khởi tạo

    @BeforeClass // Pre-condition - khởi tạo dữ liệu/ data test/ page class/ variable
    public void beforeClass() {
        driver = new FirefoxDriver();

        // Khởi tạo explicit Wait có tổng thời gian là 10s - polling là 0.5s mặc định
        // 500 miliseconds = 0.5 second
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Khởi tạo explicit Wait có tổng thời gian là 10s - polling là 0.3s tự set
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(300));
    }

    @Test
    public void TC_01_() {
        // Chờ cho 1 Alert presence trong HTML/ DOM trước khi thao tác lên
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());

        // Chờ cho element không còn ở trong DOM
        explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(""))));

        // Chờ cho element có trong DOM (không quan tâm có trên UI không)
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));

        // Chờ cho 1 list element có trong DOM (không quan tâm có trên UI không)
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")));

        // Chờ cho 1-n element được hiện thị trên UI
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));
        explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(""))));
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.cssSelector(""))));
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.cssSelector("")), driver.findElement(By.cssSelector(""))));
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.cssSelector("")), driver.findElement(By.cssSelector("")),driver.findElement(By.cssSelector(""))));

        // Chờ cho 1 elemnt được phép click: link/ button/ checkbox/ radio/...
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));

        // Chờ cho page hiện tại có title như mong đợi
        explicitWait.until(ExpectedConditions.titleIs("Create New Cusstomer Account"));
        driver.getTitle();

        // Kết hợp nhiều điều kiện - 2 điều kiện đều đúng
        explicitWait.until(ExpectedConditions.and(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")),
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(""))));

        // Kết hợp nhiều điều kiện - 1 trong 2 điều kiện đều đúng là được
        explicitWait.until(ExpectedConditions.or(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")),
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(""))));

        // Chờ cho 1 element có attribute chứa giá trị mong đợi (tương đối)
        explicitWait.until(ExpectedConditions.attributeContains(By.cssSelector("input#search"), "placeholder", "Search entire"));
        explicitWait.until(ExpectedConditions.attributeContains(By.cssSelector("input#search"), "placeholder", "store here... "));
        explicitWait.until(ExpectedConditions.attributeContains(By.cssSelector("input#search"), "placeholder", "Search entire store here..."));

        // Chờ cho 1 element có attribute chứa giá trị mong đợi (tuyệt đối)
        explicitWait.until(ExpectedConditions.attributeToBe(By.cssSelector("input#search"), "placeholder", "Search entire store here..."));

        // Chờ cho 1 element có attribute khác NULL
        explicitWait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(By.cssSelector("input#search")), "placeholder"));

        explicitWait.until(ExpectedConditions.domAttributeToBe(driver.findElement(By.cssSelector("input#search")),"namespaceURI","http://www.w3.org/1999/xhtm"));
        explicitWait.until(ExpectedConditions.domPropertyToBe(driver.findElement(By.cssSelector("input#search")),"namespaceURI","http://www.w3.org/1999/xhtm"));

        // Chờ cho 1 element được selected thành công
        // Checkbox/ Radio/ Dropdown Item (default)
        explicitWait.until(ExpectedConditions.elementToBeSelected(By.cssSelector("")));

        // Chờ cho 1 element được selected rồi
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""),true));

        // Chờ cho 1 element chưa được selected (trạng thái từ selected -> unslected)
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""),false));

        // Chờ cho 1 frame/iframe được avaiable và switch qua
        // Name or ID
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(""));

        // Index
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));

        // By or Element
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("")));
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.cssSelector(""))));

        // Chờ cho 1 element biến mất (không hiện thị trên UI)
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        // Chờ cho 1 đoạn code JS cần trả về giá trị
        explicitWait.until(ExpectedConditions.jsReturnsValue("document.documentElement.innerText;"));

        // Chờ cho 1 đoạn code JS được thực thi không ném ra ngoại lệ nào hết
        // Không ném ra: true
        // Có ngoại lệ: false
        explicitWait.until(ExpectedConditions.javaScriptThrowsNoExceptions("document.documentElement.innerText;"));
        Assert.assertTrue(explicitWait.until(ExpectedConditions.javaScriptThrowsNoExceptions("document.documentElement.innerText;")));
        Assert.assertFalse(explicitWait.until(ExpectedConditions.javaScriptThrowsNoExceptions("document.documentElement.innerText;")));

        // Chờ số lượng element
        explicitWait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("select[title='Sort By']>option"), 6));
        explicitWait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector("select[title='Sort By']>option"), 6));
        explicitWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("select[title='Sort By']>option"), 6));

        // Chờ cho Window/ Tab là bao nhiêu
        explicitWait.until(ExpectedConditions.numberOfWindowsToBe(3));

        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("div.category-title>h1"), "Mobile"));

        Pattern pattern = Pattern.compile("This is root of mobile", Pattern.CASE_INSENSITIVE);
        explicitWait.until(ExpectedConditions.textMatches(By.cssSelector ("div category-description"), pattern));

        // Bắt buộc cái text này phải có trong DOM/HTML
        explicitWait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div.category-title>h1"), "This is root of mobile"));

        explicitWait.until(ExpectedConditions.urlToBe("http://live.techpanda.org/index.php/mobile.html"));
        explicitWait.until(ExpectedConditions.urlContains("/index.php/mobile.html"));
        explicitWait.until(ExpectedConditions.urlMatches("[^abc]"));

        // Chờ cho 1 ĐK mà element này nó bị update trạng thái - load lại HTML
        explicitWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.cssSelector(""))));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
