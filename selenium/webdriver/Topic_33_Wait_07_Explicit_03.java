package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class Topic_33_Wait_07_Explicit_03 {

    WebDriver driver;

    WebDriverWait explicitWait;

    String projectPath = System.getProperty("user.dir");

    String character = File.separator;

    String dnName = "DaNang.jpg";

    String hnName = "HaNoi.jpg";

    String hcmName = "HoChiMinh.jpg";

    String dnFilePath = projectPath + character + "uploadFiles" + character + dnName;

    String hnFilePath = projectPath + character + "uploadFiles" + character + hnName;

    String hcmFilePath = projectPath + character + "uploadFiles" + character + hcmName;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_AjaxLoading() {
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

        By selectedDate = By.cssSelector("span#ctl00_ContentPlaceholder1_Label1");

        Assert.assertEquals(driver.findElement(selectedDate).getText(), "No Selected Dates to display.");

        driver.findElement(By.xpath("//a[text()='18']")).click();

        // Wait cho Loading biến mất trong vòng x giây
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id*='RadCalendar1']>div.raDiv")));

        Assert.assertEquals(driver.findElement(selectedDate).getText(), "Saturday, May 18, 2024");
    }

    @Test
    public void TC_02_Upload_File() {
        driver.get("https://gofile.io/uploadFiles");

        // Wait + Verify cho Spinner icon biến mất trong vòng x giây
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner-border"))));

        // Wait + Click upload file button
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.col-auto>button.btn-lg"))).click();

        // Wait + Verify cho Spinner icon biến mất trong vòng x giây
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.spinner-border")))));

        // Upload file
        driver.findElement(By.cssSelector("input[type='file']")).sendKeys(dnFilePath + "\n" + hnFilePath + "\n" + hcmFilePath);

        // Wait + Verify cho Spinner icon biến mất trong vòng x giây
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.spinner-border")))));

        // Wait cho progress bar biến mất
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.progress")))));

        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.mainUploadSuccessLink a.ajaxLink"))).click();

        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.spinner-border")))));

        // Wait + Verify button Play có tại từng hình được upload
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + hcmName + "']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Download']"))).isDisplayed());
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + hnName + "']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Download']"))).isDisplayed());
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + dnName + "']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Download']"))).isDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
