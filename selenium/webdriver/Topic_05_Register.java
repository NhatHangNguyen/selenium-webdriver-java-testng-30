package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_05_Register {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");
    String username, password;
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
    public void TC_01_Register() {
        // Truy cập trang register - https://demo.guru99.com/
        // Nhập vào 1 email bất kì
        // Click submit button
        // Get cái User/ Password lưu vào 1 biến
         username = driver.findElement(By.xpath("")).getText();
         password = driver.findElement(By.xpath("")).getText();
    }

    public void TC_02_Login() {
        // Truy cập trang login - https://demo.guru99.com/v4/
        // Nhập Username/ Password ở màn hình Register
        driver.findElement(By.name("uid")).sendKeys(username);
        driver.findElement(By.name("uid")).sendKeys(password);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
