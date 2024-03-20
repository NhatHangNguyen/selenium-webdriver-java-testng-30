package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class Topic_16_Button_Exercise {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Fahasa_Button() {
        driver.get("https://www.fahasa.com/customer/account/create");

        // Navigate to Dăng nhâp tab
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
        sleepInSecond(2);

        WebElement loginButton = driver.findElement(By.cssSelector("button.fhs-btn-login"));

        // Verify Dang nhap button disable
        Assert.assertFalse(loginButton.isEnabled());

        // Verify Dang nhap button co backgroud color la mau xam
        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(),"#000000");

        // Input dữ liệu hợp lệ vào Email/Mật khẩu texbox
        driver.findElement(By.cssSelector("input#login_username")).sendKeys("hangcnnguyen@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456");
        sleepInSecond(2);

        // Verify Dang nhap button enable
        Assert.assertTrue(loginButton.isEnabled());

        // Verify Dang nhap button co background color la mau do
        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(),"#c92127");
    }

    @Test
    public void TC_02_DesignWise_Button() {
        driver.get("https://play.goconsensus.com/u5d5156df");
        sleepInSecond(5);

        WebElement continueButton = driver.findElement(By.xpath("//button[@data-testid='lead form continue']"));
        WebElement countryButton = driver.findElement(By.cssSelector("button#downshift-0-toggle-button"));

        // Verify Continue button disable
        Assert.assertFalse(continueButton.isEnabled());

        // Input valid firstName/ lastName/ email/ phone/ organization/ country
        driver.findElement(By.cssSelector("input#firstName")).sendKeys("Hang");
        driver.findElement(By.cssSelector("input#lastName")).sendKeys("Nguyen");
        driver.findElement(By.cssSelector("input#email")).sendKeys("hangcnnguyen@gmail.com");
        driver.findElement(By.cssSelector("input#phoneNumber")).sendKeys("0978547389");
        driver.findElement(By.cssSelector("input#organization")).sendKeys("Viet Nam");

        selectItemDropdown("//label[text()='Country']//following::button[@id='downshift-0-toggle-button']","//label[text()='Country']//following::div[@data-testid='select menu item']", "AE");
        sleepInSecond(1);

        selectItemDropdown("//label[text()='State']//following::button[@class='src-shared-ui-dropdown-select-ui-menu-menu-toggle--root-mL2+o']","//label[text()='State']//following::div[@data-testid='select menu item']", "AZ");
        sleepInSecond(1);

        // Verify continue button enable
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

    public void selectItemDropdown(String parentCss, String childCss, String itemTextExpected){
        driver.findElement(By.xpath(parentCss)).click();
        sleepInSecond(2);

        List<WebElement> allItem = explicitWait.until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.xpath(childCss)));
        for (WebElement item: allItem){
            String textItem = item.getText();
            System.out.println("Text item = " + textItem);
            if(textItem.equals(itemTextExpected)){
                item.click();
                break;
            }
        }
    }
}
