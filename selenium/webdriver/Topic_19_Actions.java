package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_19_Actions {
    WebDriver driver;
    Actions actions;
    String fullName;

    public String getFullName(){
        return fullName;
    }

    public String setFullName(String fullName){
        this.fullName = fullName;
        return fullName;
    }
    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
