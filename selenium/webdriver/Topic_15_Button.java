package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_15_Button {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Egov_Button() {
        driver.get("https://egov.danang.gov.vn/reg");


        WebElement registerButton = driver.findElement(By.cssSelector("input.egov-button"));

        // Verify button bị disable khi chưa click vào checkbox
        Assert.assertFalse(registerButton.isEnabled());

        driver.findElement(By.cssSelector("input#chinhSach")).click();
        sleepInSecond(2);

        // Verify button đã được enable khi click vào checkbox
        Assert.assertTrue(registerButton.isEnabled());

        // CÁCH 1
        // Lây ra ma mau nên cúa button
        String registerBackgroundRGB = registerButton.getCssValue("background-color");
        System.out.println("Background color RGB = " + registerBackgroundRGB);

        // Convert tu kiêu String (mâ RGB) qua kiêu Color
        Color registerBackgroundColour = Color.fromString(registerBackgroundRGB);

        // Convert qua kiêu Hexa
        String registerBackgroundHexa = registerBackgroundColour.asHex();
        System.out.println("Background color Hexa = " + registerBackgroundHexa);

        Assert.assertEquals(registerBackgroundHexa,"#ef5a00");

        // CÁCH 2
        //Assert.assertEquals(Color.fromString(registerButton.getCssValue("background-color")).asHex().toLowerCase(),"#ef5a00");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
