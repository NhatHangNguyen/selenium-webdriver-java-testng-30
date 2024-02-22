package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
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
    public void TC_01_() {
        // Set trực tiếp
        //Mở ra page URL bất kì
        driver.get("https://www.facebook.com/");

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



    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
