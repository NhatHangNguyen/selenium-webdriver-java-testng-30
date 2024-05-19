package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class Topic_36_Wait_09_Fluent_Exercise {

    WebDriver driver;

    FluentWait<WebDriver> fluentDriver;

    FluentWait<WebElement> fluentElement;

    private long fullTimeoutInSecond = 30;

    private long pollingTimeOutInMilisecond = 300;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        fluentDriver = new FluentWait<WebDriver>(driver);
    }

    @Test
    public void TC_01_() {
        driver.get("https://automationfc.github.io/dynamic-loading/");

        waitAndFindElement(By.cssSelector("div#start>button")).click();

//        // Setting
//        fluentDriver.withTimeout(Duration.ofSeconds(10))
//                .pollingEvery(Duration.ofMillis(100))
//                .ignoring(NoSuchElementException.class);
//
//        // Condition trả về kiểu boolean
//        fluentDriver.until(new Function<WebDriver, Boolean>() {
//
//            @Override
//            public Boolean apply(WebDriver webDriver) {
//                return driver.findElement(By.xpath("//div[@id='finish']/h4[text()='Hello World!']")).isDisplayed();
//            }
//        });

        // Condition trả về kiểu string
        String helloText = waitAndFindElement(By.xpath("//div[@id='finish']/h4")).getText();

        Assert.assertEquals(helloText, "Hello World!");


        // Alert
//        fluentDriver.withTimeout(Duration.ofSeconds(10))
//                .pollingEvery(Duration.ofMillis(100))
//                .ignoring(NoAlertPresentException.class);
//
//        fluentDriver.until(new Function<WebDriver, Alert>() {
//
//            @Override
//            public Alert apply(WebDriver webDriver) {
//                return new WebDriverWait(driver, Duration.ofSeconds(15))
//                        .until(ExpectedConditions.alertIsPresent());
//            }
//        });
    }

    @Test
    public void TC_02_() {
        driver.get("https://automationfc.github.io/fluent-wait/");

        WebElement countDownTime = driver.findElement(By.cssSelector("div#javascript_countdown_time"));

        fluentElement = new FluentWait<WebElement>(countDownTime);

        fluentElement.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        fluentElement.until(new Function<WebElement, Boolean>() {

            @Override
            public Boolean apply(WebElement webElement) {
                String text = webElement.getText();
                System.out.println(text);
                return text.endsWith("00");
            }
        });
    }

    public WebElement waitAndFindElement(By locator) {
        FluentWait<WebDriver> fluentDriver = new FluentWait<WebDriver>(driver);
        fluentDriver.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        return fluentDriver.until(new Function<WebDriver, WebElement>() {

            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(locator);
            }
        });
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
