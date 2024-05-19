package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class Topic_35_Wait_09_Fluent_Demo {

    WebDriver driver;

    FluentWait<WebDriver> fluentDriver;

    FluentWait<WebElement> fluentElement;

    FluentWait<String> fluentString;

    @BeforeClass
    public void beforeClass() { driver = new FirefoxDriver();}

    @Test
    public void TC_01_() {
        // KHỞI TẠO
        fluentDriver = new FluentWait<WebDriver>(driver);

        fluentElement = new FluentWait<WebElement>(driver.findElement(By.cssSelector("")));

        fluentString = new FluentWait<String>("Hello World!");

        // SETTING
        // Tổng time
        fluentDriver.withTimeout(Duration.ofSeconds(10));

        // Polling time
        fluentDriver.pollingEvery(Duration.ofMillis(300));

        // Ignore NoSuchElement exceptions
        fluentDriver.ignoring(NoSuchElementException.class);

        // Ignore TimeoutException
        fluentDriver.ignoring(TimeoutException.class);

        // CONDITION 1
        fluentDriver.until(new Function<WebDriver, Object>() { // new Function<T, V>

            @Override
            public Object apply(WebDriver webDriver) {
                return null;
            }
        });

        // CONDITION 2
        fluentDriver.until(new Function<WebDriver, String>() {

            @Override
            public String apply(WebDriver webDriver) {
                return webDriver.findElement(By.cssSelector("")).getText();
            }
        });

        fluentDriver.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(400))
                .ignoring(NoSuchElementException.class, TimeoutException.class)
                .until(new Function<WebDriver, Boolean>() {

                    @Override
                    public Boolean apply(WebDriver webDriver) {
                        return webDriver.findElement(By.cssSelector("")).isDisplayed();
                    }
                });
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
