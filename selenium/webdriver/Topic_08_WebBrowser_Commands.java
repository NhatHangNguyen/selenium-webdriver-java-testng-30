package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Topic_08_WebBrowser_Commands {
    // Các câu lệnh để thao tác với Browser
    // driver.
    WebDriver driver;

    // Các câu lệnh thao tác với
    // element.
    WebElement element;

    @BeforeClass
    public void beforeClass() {
        // Muốn dùng được thì phải khởi tạo
        // Nếu không khởi tạo sẽ gặp lỗi: NullPointertion
        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver = new EdgeDriver();

        //driver = new InternetExplorerDriver();
        //driver = new OperaDrive(); Selenium 4 ngưng support
        //driver = new HTMLUnit(); // Headless Browser
        // Từ năm 2016: Chrome/  có support chạy dạng headless
        // Headless: Crawl data (Data Analyst) Dev FE

        // Selenium version 3
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // Selenium version 4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_() throws MalformedURLException {
        // Set trực tiếp
        //Mở ra page URL bất kì
        driver.get("https://www.facebook.com/");

        System.out.print("Window / Tab ID = " +driver.getWindowHandle());

        // Khai báo biến rồi gắn vào sau
        // Nếu biến này chỉ dùng duy nhất 1 lần thì không nên tạo biến
        String homePageUrl = "https://www.facebook.com/";
        driver.get(homePageUrl);

        // Nếu như có 1 tab/ window thì tính năng tương tự quit
        driver.close();

        // Đóng browser (không care bao nhiêu tab/ window)
        driver.quit();

        // 2 hàm này sẽ bị ảnh hưởng timeout implicitWait
        // findElement / findElements

        // Nó sẽ đi tìm vs loại By nào và trả về 1 element nếu như được tìm thấy (WebElement)
        // Không được tìm thấy -> failed tại step này và throw exception: NoSuchElementException
        // Trả về 1 element - nếu như tìm thấy nhìu  thì cũng chỉ lấy 1 (thao tác vs cái đầu tiên)
        WebElement emailAddressTextBox = driver.findElement(By.id("email"));

        // Nó sẽ đi tìm vs loại By nào và trả về 1 danh sách element nếu như được tìm thấy (List WebElement)
        // Không được tìm thấy -> không bị failed tại step này và trả về 1 list rỗng (O elemnet)
        List<WebElement> checkboxes =  driver.findElements(By.xpath("//input[@type='checkbox']"));
        checkboxes.get(1).click();

        driver.findElement(By.cssSelector("button#login")).click();

        // Dùng để lấy ra URL của màn hình/ page hiện tại đang đứng
        // Verify 1 cách tương đối
        driver.getCurrentUrl();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");

        // Lấy ra page source HMTL/CSS
        driver.getPageSource();
        driver.getPageSource().contains("The Apple and Google Play logos are trademarks of their respective owners.");
        Assert.assertTrue(driver.getPageSource().contains("The Apple and Google Play logos are trademarks of their respective owners."));

        // Lấy ra title của page hiện tại
        driver.getTitle();

        // Lấy ra ID của cửa sổ/ tab hiện tại
        // Handle Window/ Tab
        driver.getWindowHandle();
        driver.getWindowHandles();

        // Cookies - Framework
        driver.manage().getCookies();

        // Get ra những log ở Dev  - Framework
        driver.manage().logs().get(LogType.DRIVER);

        // Apply cho việc tìm element (findElement/ findElements)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        // Chờ cho 1 page được load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        // Set trước khi dùng vs thư viện JavascriptExecutor
        // Inject đoạn code JS vào trong Browser/ Element
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

        // Selenium 4 mói có
        driver.manage().timeouts().getImplicitWaitTimeout();
        driver.manage().timeouts().getPageLoadTimeout();
        driver.manage().timeouts().getScriptTimeout();

        // Chạy full màn hình
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();
        driver.manage().window().minimize();

        // Test GUI
        // Test Responsive (Resolution khác nhau)
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().window().setSize(new Dimension(2560, 1440));

        driver.manage().window().getSize();

        // Set cho browser ở vị trí nào so với độ phân giải màn hình (run trên màn hình có kích thước bao nhiêu)
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().getPosition();

        // Điều hướng trang web
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        // Thao tác tốt vs history của web  (back/ forward)
        driver.navigate().to("https://www.facebook.com/");
        driver.navigate().to(new URL("https://www.facebook.com/"));

        // Alert/ Window (Tab) / Frame (iFrame)
        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("Text");

        // Lấy ra ID của cửa sổ/ tab hiện tạ
        // Handle Window/ tab
        String homePageWindowID = driver.getWindowHandle();
        driver.switchTo().window(homePageWindowID);

        Set<String> allWindowIDs = driver.getWindowHandles();

        // Switch/ handle frame (iFrame)
        // Index/ ID (name)/ Element
        driver.switchTo().frame(0);
        driver.switchTo().frame("3567");
        driver.switchTo().frame(driver.findElement(By.id("")));

        // Switch về HTML chứa frame trc đó
        driver.switchTo().defaultContent();

        // Từ cái frame trong đi ra frame ngoài chứa nó
        driver.switchTo().parentFrame();

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
