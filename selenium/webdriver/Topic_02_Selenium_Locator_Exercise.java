package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Locator_Exercise {
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
        driver.get("https://demo.nopcommerce.com/register");
    }

    @Test
    public void TC_01_ID() {
        driver.findElement(By.id("Password"));
    }

    @Test
    public void TC_02_Class() {

        driver.findElement(By.className("header-links-wrapper"));
        driver.findElement(By.className("cart-label"));
    }

    @Test
    public void TC_03_TC_03_Name() {
        driver.findElement(By.name("Email"));
        driver.findElement(By.name("Password"));
    }

    @Test
    public void TC_04_TagName() {
        driver.findElements(By.tagName("div"));
    }

    @Test
    public void TC_05_LinkText() {
        // Độ chính xác cao = tuyệt đối = toàn bộ
        driver.findElement(By.linkText("New products"));
    }

    @Test
    public void TC_06_Partial_LinkText() {
        // Độ chính xác không cao = tương đối = 1 phần (đầu/ giữa/ cuối)
        driver.findElements(By.partialLinkText("products"));
        driver.findElement (By.partialLinkText("New"));
    }

    @Test
    public void TC_07_CSS() {
        // CSS với  ID
        driver.findElement(By.cssSelector("input[id='Password']"));
        driver.findElement(By.cssSelector("input#Password"));
        driver.findElement(By.cssSelector("#Password"));

        // CSS với Class
        driver.findElement (By.cssSelector ("div[class='header-selectors-wrapper']"));
        driver.findElement (By.cssSelector ("div.header-selectors-wrapper"));
        driver.findElement (By.cssSelector (".header-selectors-wrapper"));

        // CSS với Name
        driver.findElement(By.cssSelector("input[name='Email']"));

        // CSS vs tagname
        driver.findElement(By.cssSelector("div"));

        // CSS vs Link
        driver.findElement (By.cssSelector ("a[href='/conditions-of-use']"));

        // CSS vs partial Link
        driver.findElement(By.cssSelector("a[href*='conditions']"));
    }

    @Test
    public void TC_08_XPath() {
        // XPath vs ID
        driver.findElement (By.xpath ("//input[@id='FirstName' ]"));

        // XPath vs Class
        driver.findElement (By.xpath ("//div[@class='page-title']"));

        // XPath vs Name
        driver.findElement (By.xpath ("//input [@name= 'FirstName']"));

        // XPath vs tagname
        driver.findElement (By.xpath ("//div")) ;

        // XPath vs link
        driver.findElement (By.xpath ("//a[@href='/customer/addresses']"));
        driver.findElement (By.xpath ("//a[text ()='Addresses']"));

        //XPath vs partial link
        driver.findElement (By.xpath ("//a[contains (@href, 'addresses')]"));
        driver.findElement (By.xpath ("//a[contains(text(), 'Addresses')]")) ;
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
