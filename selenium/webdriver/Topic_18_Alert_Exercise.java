package webdriver;

import org.bouncycastle.util.encoders.Base64;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Headers;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Topic_18_Alert_Exercise {
    WebDriver driver;
    WebDriverWait explicitWait;
    By resultText = By.cssSelector("p#result");
    String username = "admin";
    String password = "admin";
    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Accept_Alert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        // Chờ cho alert present
        // Nếu trong thời gian chờ mà xuất hiện thì tự switch vào
        // Nếu hết thời gian chờ mà chưa xuất hiện mới fail
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());
        sleepInSecond(3);

        // Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "I am a JS Alert");

        // Khi mình accept/ cancel rồi thì alert sẽ mất lun
        alert.accept();
        sleepInSecond(3);

        // Verify
        Assert.assertEquals(driver.findElement(resultText).getText(),"You clicked an alert successfully");

        // Cancel alert
        // Chỉ apply cho confirm alert với Prompt alert
        // void dismiss();

        // Accept alert
        // void accept();

        // Get text trong Alert ra
        //String getText();

        // Nhập text vào Alert
        // Chỉ dùng cho Prompt
        // void sendKeys(String keysToSend);
    }

    @Test
    public void TC_02_Confirm_Alert() {
        By jSConfirmButton = By.xpath("//button[text()='Click for JS Confirm']");

        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(jSConfirmButton).click();
        sleepInSecond(3);

        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), "I am a JS Confirm");

        alert.dismiss();
        sleepInSecond(3);

        // Verify
        Assert.assertEquals(driver.findElement(resultText).getText(),"You clicked: Cancel");

        driver.findElement(jSConfirmButton).click();
        sleepInSecond(3);

        alert.accept();
        sleepInSecond(3);

        // Verify
        Assert.assertEquals(driver.findElement(resultText).getText(),"You clicked: Ok");
    }

    @Test
    public void TC_03_Prompt_Alert() {
        By jSPromptButton = By.xpath("//button[text()='Click for JS Prompt']");
        String text = "nguyenchaunhathang";

        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(jSPromptButton).click();
        sleepInSecond(3);

        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), "I am a JS prompt");

        // Nhập text bất kì vào và bấm cancel
        alert.sendKeys(text);
        alert.dismiss();
        Assert.assertEquals(driver.findElement(resultText).getText(), "You entered: null");

        // Nhập text bất kì vào và bấm ok
        driver.findElement(jSPromptButton).click();
        sleepInSecond(3);
        alert.sendKeys(text);
        alert.accept();
        Assert.assertEquals(driver.findElement(resultText).getText(), "You entered: " + text);
    }

    @Test
    public void TC_04_Authentication_ByPass_To_URL() {
        // Cách 1: Truyền thẳng user/ password vào URL
        // Trick - ByPasss
        driver.get("http://" + username + ":" + password +"@" + "the-internet.herokuapp.com/basic_auth");

        // Verify
        Assert.assertTrue(driver.findElement(
                By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());

        // Cách 2: Từ page A thao tác lên 1 element nó sẽ qua page B (cần phải thao tác với Authen Alert trước)
        driver.get("http://the-internet.herokuapp.com/");

        String authenLinkUrl = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");

        String[] authenArray = authenLinkUrl.split("//");
        System.out.println(authenArray[0]);
        System.out.println(authenArray[1]);

        driver.get(authenArray[0] + "//" + username + ":" +  password + "@" + authenArray[1] );

        Assert.assertTrue(driver.findElement(
                By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());
    }

    @Test
    public void TC_05_Authentication_Auto_IT() {
        // Cách 2: Chạy trên Windows (AutoIT)
        // Mac/ linux không thực thi đc
    }

    @Test
    public void TC_06_Authentication_Selenium_4() {
        // Thư viện alert không sử dụng cho Authentication Alert dước
        //  Chrome DevTool Protocol (CDP) - Chrome. Edge (Chromium)

        // Get DevTool object
        DevTools devTools = ((HasDevTools) driver).getDevTools();

        // Start new session
        devTools.createSession();

        // Enable the Network domain of devtools
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Encode username/ password
        Map<String, Object> headers = new HashMap<String, Object>();
        String basicAuthen = "Basic " + new String(new Base64() .encode(String.format("%s:%s", username, password).getBytes()));
        headers.put("Authorization", basicAuthen);

        // Set to Header
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));

        driver.get ("https://the-internet.herokuapp.com/basic_auth");

        Assert.assertTrue(driver.findElement(
                By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());
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
