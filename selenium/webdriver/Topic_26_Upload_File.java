package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_26_Upload_File {

    WebDriver driver;

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Single_File() {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By uploadBy = By.cssSelector("input[name='files[]']");

        driver.findElement(uploadBy).sendKeys(dnFilePath);
        sleepInSecond(2);

        driver.findElement(uploadBy).sendKeys(hnFilePath);
        sleepInSecond(2);

        driver.findElement(uploadBy).sendKeys(hcmFilePath);
        sleepInSecond(2);

        // Verify file loaded success
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + dnName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + hnName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + hcmName + "']")).isDisplayed());

        List<WebElement> startButtons = driver.findElements(By.cssSelector("td>button.start"));

        // Classic for index - để check điều kiện
        for (int i = 0; i < startButtons.size(); i++) {
            if (startButtons.get(i).isDisplayed()){
                startButtons.get(i).click();
                sleepInSecond(3);
            }
        }

        // For-each - không cần check điều kiện trong vòng for
//        for (WebElement button: startButtons){
//            button.click();
//            sleepInSecond(2);
//        }

        // Verify file uploaded success
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + dnName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + hnName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + hcmName + "']")).isDisplayed());
    }

    @Test
    public void TC_02_Multiple_File() {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By uploadBy = By.cssSelector("input[name='files[]']");

        driver.findElement(uploadBy).sendKeys(dnFilePath + "\n" + hnFilePath + "\n" + hcmFilePath);
        sleepInSecond(2);

        // Verify file loaded success
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + dnName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + hnName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + hcmName + "']")).isDisplayed());

        List<WebElement> startButtons = driver.findElements(By.cssSelector("td>button.start"));

        // Classic for index - để check điều kiện
        for (int i = 0; i < startButtons.size(); i++) {
            if (startButtons.get(i).isDisplayed()){
                startButtons.get(i).click();
                sleepInSecond(3);
            }
        }

        // Verify file uploaded success
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + dnName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + hnName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + hcmName + "']")).isDisplayed());
    }

    @AfterClass
    public void afterClass() {
        // driver.quit();
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
