package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_21_Random_Popup_02_Exercise {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Random_Popup_In_DOM_01() {
        driver.get("https://vnk.edu.vn/");

        By marketingPopup = By.cssSelector("div#tve-p-scroller");

        if (driver.findElement(marketingPopup).isDisplayed()){
            driver.findElement(By.cssSelector("svg.tcb-icon")).click();
            sleepInSecond(3);
            System.out.println("Popup hien thi:");
        }

        driver.findElement(By.cssSelector("button.btn.btn-danger")).click();
        sleepInSecond(3);

        Assert.assertTrue(driver.findElement(By.cssSelector("div.title-content")).isDisplayed());
    }

    @Test
    public void TC_02_Random_Popup_Not_In_DOM_01() {
        driver.get("https://www.javacodegeeks.com/");
        sleepInSecond(10);

        By newLetterPopup = By.cssSelector("div.lepopup-popup-container>div:not([style^='display:none'])");

        // Nếu hiển thị thì nhảy vào close nó đi
        // Luôn chạy được vì element luôn có trong HTML/DOM
        // >0 nghĩa là được render ra rồi nhưng chưa biết hiện thị hay chưa
        if (driver.findElements(newLetterPopup).size() > 0 && driver.findElements(newLetterPopup).get(0).isDisplayed()){
            System.out.println("Popup hien thi:");
            driver.findElement(By.cssSelector("div.lepopup-popup-container>div:not([style^='display:none']) div.lepopup-element-html-content>a:not([class^='lepopup-inherited'])")).click();
            sleepInSecond(3);
        } else {
            System.out.println("Popup khong hien thi:");
        }

        // Nếu không hiện thị thì qua step tiếp theo
        // Nhập vào field Search dữ liệu
        driver.findElement(By.cssSelector("input#search-input")).sendKeys("Agile Testing Explained");
        driver.findElement(By.cssSelector("button#search-submit")).click();
        sleepInSecond(3);

        // Verify
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Agile Testing Explained']")).isDisplayed());
    }

    @Test
    public void TC_03_Random_Popup_Not_In_DOM_02() {
        driver.get("http://www.kmplayer.com/");

        By marketingContent = By.cssSelector("div.pop-container");

        if (driver.findElement(marketingContent).isDisplayed()){
            System.out.println("Popup hien thi:");

            int heightBrowser = driver.manage().window().getSize().getHeight();
            if (heightBrowser < 1920 ){
                ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement((By.cssSelector("div.close"))));
            } else {
                driver.findElement((By.cssSelector("div.close"))).click();
            }
            sleepInSecond(5);
        }
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }

    public void sleepInSecond(long timeInSecond) {
            try {
                Thread.sleep(timeInSecond * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }
}
