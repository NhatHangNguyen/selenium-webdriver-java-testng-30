package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Locator {
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

    // HTML Element: <tagname attribute_name_1='attribute_value' attribute_name_2='attribute_value' ..>

    /* Selenium version: 1.x/ 2.x/ 3.x/ 4.x
        8 loai Locator
        Selenium Locator = HTML Attribute: Id/ Class/ Name = Trûng vs 3 attribute cúa HTML
        LinkText/ Partial LinkText: HTML Link (the a)
        Tagname: HTML Tagname
        Css/ XPath

        Selenium version 4. - GUI (Graphic User Interface)
        Class - Relative Locator: above/ bellow/ near/ leftof / rightof
    */
    @Test
    public void TC_01_ID() {
        driver.findElement(By.id("FirstName"));
    }

    @Test
    public void TC_02_Class() {
        driver.findElement(By.className("header-logo"));
    }

    @Test
    public void TC_03_Name() {

        driver.findElement(By.name("DateOfBirthDay"));
    }

    @Test
    public void TC_04_TagName() {

        driver.findElements(By.tagName("input"));
    }

    @Test
    public void TC_05_LinkText() {
        // Độ chính xác cao = tuyệt đối = toàn bộ
        driver.findElement(By.linkText("Shipping & returns"));
    }

    @Test
    public void TC_06_Partial_LinkText() {
        // Độ chính xác không cao = tương đối = 1 phần (đầu/ giữa/ cuối)
        driver.findElements(By.partialLinkText("vendor account"));
        driver.findElement (By.partialLinkText("vendor account"));
        driver.findElement (By.partialLinkText("Apply for vendor"));
    }

    @Test
    public void TC_07_CSS() {
        // CSS với  ID
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        driver.findElement(By.cssSelector("input#FirstName"));
        driver.findElement(By.cssSelector("#FirstName"));

        // CSS với Class
        driver.findElement (By.cssSelector ("div[class='page-title']"));
        driver.findElement (By.cssSelector ("div.page-title"));
        driver.findElement (By.cssSelector (" .page-title"));

        // CSS với Name
        driver.findElement(By.cssSelector("input[name='FirstName']"));

        // CSS vs tagname
        driver.findElement(By.cssSelector("input"));

        // CSS vs Link
        driver.findElement (By.cssSelector ("a[href='/customer/addresses']"));

        // CSS vs partial Link
        driver.findElement(By.cssSelector("a[href*='addresses']"));
        //driver.findElement (By.cssSelector ("a[href^='addresses']"));
        //driver.findElement (By.cssSelector ("a[href$='addresses']"));
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
        driver.findElement (By.xpath ("//input")) ;

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
