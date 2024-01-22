package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_03_Selenium_Relative {
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
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2Fregister");
    }

    @Test
    public void TC_01_Relative_By() {

        // Login button theo by
        By loginButtonBy = By.cssSelector("button.login-button");

        // Remember me checkbox theo by
        By rememberMeCheckBoxBy = By.id("RememberMe");

        // Relative theo By
        RelativeLocator.with(By.tagName("label"))
                .above(loginButtonBy)
                .toRightOf(rememberMeCheckBoxBy);
    }

    @Test
    public void TC_02_Relative_WebElement_Right() {

        // Login button theo WebElement
        WebElement loginButtonByElement = driver.findElement(By.cssSelector("button.login-button"));

        // Remember me checkbox theo WebElement
        WebElement rememberMeCheckBoxElement = driver.findElement(By.name("RememberMe")); //không phải text nên trả ra null

        // Relative theo WebElement
        RelativeLocator.with(By.tagName("label"))
                .above(loginButtonByElement)
                .toRightOf(rememberMeCheckBoxElement);
    }

    @Test
    public void TC_03_Relative_WebElement_Left() {

        // Login button theo WebElement
        WebElement loginButtonByElement = driver.findElement(By.cssSelector("button.login-button"));

        // Remember me checkbox theo WebElement
        WebElement rememberMeCheckBoxElement = driver.findElement(By.name("RememberMe"));

        // Forgot Password Link theo WebElement
        WebElement forgotPasswordElement = driver.findElement(By.cssSelector("span.forgot-password"));

        // Relative theo WebElement
        RelativeLocator.with(By.tagName("label"))
                .above(loginButtonByElement)
                .toRightOf(rememberMeCheckBoxElement)
                        .toLeftOf(forgotPasswordElement);

        // In ra screen
        System.out.println(forgotPasswordElement.getText());
    }

    @Test
    public void TC_04_Relative_WebElement_Below() {

        // Login button theo By
        By loginButtonBy = By.cssSelector("button.login-button");

        // Remember me checkbox theo by
        By rememberMeCheckBoxBy = By.id("RememberMe");

        // Password textbox theo by
        By passwordTextboxBy = By.cssSelector("input#Password");

        // Forgot password theo by
        By forgotPasswordBy = By.cssSelector("span.forgot-password");

        // Relative theo By
        RelativeLocator.with(By.tagName("label"))
                .above(loginButtonBy)
                .toRightOf(rememberMeCheckBoxBy)
                .toLeftOf(forgotPasswordBy)
                .below(forgotPasswordBy)
                .near(forgotPasswordBy);

        List<WebElement> allLinks = driver.findElements(RelativeLocator.with(By.tagName("a")));
        System.out.println(allLinks.size());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
