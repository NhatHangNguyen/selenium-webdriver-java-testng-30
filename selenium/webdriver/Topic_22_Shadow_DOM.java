package webdriver;

import org.bouncycastle.dvcs.DVCSRequestInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_22_Shadow_DOM {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_shadow_DOM() {
        driver.get("https://automationfc.github.io/shadow-dom/");

        sleepInSecond(2);

        // Đi theo đúng cấu trúc của HTML/ DOM
        // Tìm đến shadow host
        // Lưu chúng thành 1 element
        // Get shadowRoot ra
        // driver = đại diện cho cái Real DOM (DOM bên ngoài)

        // shadowRootContext = đại diện cho cái shadow DOM 1 bên trong
        WebElement shadowHostElement = driver.findElement(By.cssSelector("div#shadow_host"));
        SearchContext shadowRootContext = shadowHostElement.getShadowRoot();

        String someText = shadowRootContext.findElement(By.cssSelector("span#shadow_content>span")).getText();
        System.out.println(someText);
        Assert.assertEquals(someText,"some text");

        WebElement checkboxShadow = shadowRootContext.findElement(By.cssSelector("input[type='checkbox']"));
        Assert.assertFalse(checkboxShadow.isSelected());

        List<WebElement> allInput = shadowRootContext.findElements(By.cssSelector("input"));
        System.out.println(allInput.size());

        // nestedShadowHostElement = đại diện cho cái nested shadow DOM 2 (nằm trong shadow DOM 1)
        WebElement nestedShadowHostElement = shadowRootContext.findElement(By.cssSelector("div#nested_shadow_host"));
        SearchContext nestedShadowRootContent = nestedShadowHostElement.getShadowRoot();

        String nestedText = nestedShadowRootContent.findElement(By.cssSelector("div#nested_shadow_content>div")).getText();
        System.out.println(nestedText);
        Assert.assertEquals(nestedText, "nested text");
    }

    @Test
    public void TC_02_shadow_DOM_Shopee() {
        driver.get("https://shopee.vn/");

        WebElement shadowHostElement = driver.findElement(By.cssSelector("shopee-banner-popup-stateful")); // tìm đến thằng cha
        SearchContext shadowRootContext = shadowHostElement.getShadowRoot(); // get shadow root

        // Có 2 trường hợp có thể xảy ra
        // Nếu có popup hiển thị thì close đi và qua step tiếp theo
        // Nếu không có popup hiển thị thì close đi và qua step tiếp theo
        if (shadowRootContext.findElements(By.cssSelector("div.home-popup_content")).size() > 0
                && shadowRootContext.findElements(By.cssSelector("div.home-popup_content")).get(0).isDisplayed()){
            // Click to close pop-up
            shadowRootContext.findElement(By.cssSelector("div.shopee-popup__close-btn")).click();
            sleepInSecond(2);
        }

        // Không hiện thị/ đã bị đóng r qua step Search
        driver.findElement(By.cssSelector("input.shopee-searchbar-input__input")).sendKeys("iphone 15 Pro Max");
        sleepInSecond(3);
        driver.findElement(By.cssSelector("button.shopee-searchbar__search-button")).click();
        sleepInSecond(3);
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
