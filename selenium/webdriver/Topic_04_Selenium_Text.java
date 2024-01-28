package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_04_Selenium_Text {
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
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_() {
        driver.get("https://automationfc.github.io/basic-form/");

        // 1 - Truyền cái text vào trong locator để check hiển thị (displayed)
        // Nên dùng vì nó tuyêt đối
        driver.findElement(By.xpath("//h1 [text= 'Selenium WebDriver API']"));

        // Hạn chế vì nó tương đối
        driver.findElement(By.xpath("//p[contains(text(),'Mail Personal or Business Check')]")).isDisplayed();
        driver.findElement(By.xpath( "//p[contains(text(),\"Mail Personal or Business Check, Cashier's Check or money order to\")]")).isDisplayed();

        // 2 - Get cái text ra rồi verify sau
        String text = driver.findElement(By.xpath("//h5[@id='nine']/p[1]")).getText();

        //Mail Personal or Business Check, Cashier's or money order to:
        Assert.assertTrue(text.contains("Mail Personal or Business Check"));
        Assert.assertTrue(text.contains("Cashier's or money order to"));
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
