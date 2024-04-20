package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_24_Windows_Tab {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Basic_Form() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        String parentID = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        sleepInSecond(3);

        // Switch qua trang Google
        switchToWindowByTitle("Google");

        driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys("Selenium");
        sleepInSecond(3);

        // Switch để quay lại trang Basic Form
        switchToWindowByTitle("Selenium WebDriver");

        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        sleepInSecond(3);

        // // Switch qua trang Facebook
        switchToWindowByTitle("Facebook – log in or sign up");

        driver.findElement(By.cssSelector("input#email")).sendKeys("hangnguyen@gmail.com");
        sleepInSecond(3);

        // Switch để quay lại trang Basic Form
        switchToWindowByTitle("Selenium WebDriver");

        closeAllWindowWithoutParent(parentID);
    }

    @Test
    public void TC_02_Kyna_English() {
        driver.get("https://skills.kynaenglish.vn/");

        // Click vào pop-up
        driver.findElement(By.cssSelector("div.fancybox-outer img")).click();
        sleepInSecond(3);

        // Switch qua tab đăng nhập
        String loginIDTab = driver.getWindowHandle();
        switchToWindowByID(loginIDTab);
        sleepInSecond(3);

        driver.findElement(By.cssSelector("input#user-login")).sendKeys("Testing");
    }

    @Test
    public void TC_03_Tech_Panda(){
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        sleepInSecond(3);

        driver.findElement(By.xpath("//a[@title='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        sleepInSecond(3);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product Sony Xperia has been added to comparison list.");

        driver.findElement(By.xpath("//a[@title='IPhone']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        sleepInSecond(3);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product IPhone has been added to comparison list.");

        driver.findElement(By.xpath("//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        sleepInSecond(3);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product Samsung Galaxy has been added to comparison list.");

        driver.findElement(By.xpath("//button[@title='Compare']")).click();
        sleepInSecond(3);

        switchToWindowByTitle("Products Comparison List - Magento Commerce");

        Assert.assertEquals(driver.findElement(By.cssSelector("div.page-title h1")).getText(),"COMPARE PRODUCTS");

        driver.findElement(By.xpath("//button[@title='Close Window']")).click();

        switchToWindowByTitle("Mobile");

        driver.findElement(By.cssSelector("input#search")).sendKeys("Samsung Galaxy");
        sleepInSecond(3);
    }

    @Test
    public void TC_04_Cambridge(){
        driver.get("https://dictionary.cambridge.org/vi/");

        String parentID = driver.getWindowHandle();

        driver.findElement(By.cssSelector("span.cdo-login-button")).click();

        switchToWindowByTitle("Login");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Email *']//following-sibling::span[@data-bound-to='loginID']")).getText(), "This field is required");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Password *']//following-sibling::span[@data-bound-to='password']")).getText(), "This field is required");

        closeAllWindowWithoutParent(parentID);

        switchToWindowByTitle("Cambridge Dictionary | Từ điển tiếng Anh, Bản dịch & Từ điển từ đồng nghĩa");

        driver.findElement(By.cssSelector("input#searchword")).sendKeys("Automation" + Keys.ENTER);
        sleepInSecond(3);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='cacd-1']/following-sibling::div/div/span/span")).getText(),"automation");
    }

    @Test
    public void TC_05_Harvard(){
        driver.get("https://courses.dce.harvard.edu/");

        String parentID = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[@class='anon-only']")).click();
        sleepInSecond(5);

        switchToWindowHarvard(parentID);
        sleepInSecond(3);

        driver.findElement(By.cssSelector("button#harvard-key-button")).click();
        sleepInSecond(3);

        driver.findElement(By.xpath("//button[@name='submit']")).click();
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-status-message']")).getText(), "Password is a required field. Username is a required field.");
    }

    @Test
    public void TC_06_Selenium_Version_4(){
        driver.get("https://skills.kynaenglish.vn/");
        System.out.println("Driver ID Kyna = " + driver.toString());

        // New 1 tab mới/ window mới nhưng không có tạo ra driver mới
        WebDriver popupDriver = driver.switchTo().newWindow(WindowType.WINDOW);
        popupDriver.get("https://skills.kynaenglish.vn/trang-ca-nhan/khoa-hoc");
        System.out.println("Driver ID Popup = " + driver.toString());
        System.out.println(popupDriver.getTitle());
        System.out.println(popupDriver.getCurrentUrl());

        popupDriver.findElement(By.cssSelector("input#user-login")).sendKeys("hangnguyen@gmai.com");
        sleepInSecond(3);

        switchToWindowByTitle("Kyna.vn - Học online cùng chuyên gia");

        // Click vào pop-up
        driver.findElement(By.cssSelector("div.fancybox-outer img")).click();
        sleepInSecond(3);
        System.out.println(popupDriver.getTitle());
        System.out.println(popupDriver.getCurrentUrl());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    // Dùng cho 2 window/tabs
    public void switchToWindowByID(String expextedID){
        // lấy ra ID của tất cả các windw/ tab đang có
        Set<String> allIDs = driver.getWindowHandles();

        // Dùng vòng lập duyệt qua từng ID trong Set ở trên
        for (String id: allIDs){
            // Kiểm tra điều kiện trước
            if (!id.equals(expextedID)) {
                // Rồi mới switch sau
                driver.switchTo().window(id);
                // Thoát khỏi còng lặp không cần kiểm tra các giá trị còn lại (nếu có)
                break;
            }
        }
    }

    public void switchToWindowByTitle(String expectedTitle){
        // Lấy hết tất cả ID của các window/tabs
        Set<String> allIDs = driver.getWindowHandles();

        // Dùng vòng lặp duyệt qua Det ID ở trên
        for (String id: allIDs){
            // Cho switch vào từng ID trước
            driver.switchTo().window(id);

            // Lấy ra title của tab/window hiện tại
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedTitle)){
                break;
            }
        }
    }

    public void switchToWindowHarvard(String parentID){
        // Lấy hết tất cả ID của các window/tabs
        Set<String> allIDs = driver.getWindowHandles();

        // Dùng vòng lặp duyệt qua Det ID ở trên
        for (String id: allIDs){

            // Lấy ra title của tab/window hiện tại
            if (!id.equals(parentID)){
                driver.switchTo().window(id);
                break;
            }
        }
    }

    public void closeAllWindowWithoutParent(String parentID){
        Set<String> allIDs = driver.getWindowHandles();

        for (String id: allIDs){
            if (!id.equals(parentID)){
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
