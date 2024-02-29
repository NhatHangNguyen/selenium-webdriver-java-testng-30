package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_12_TextBox_TextArea {
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void Login_01_Empty_Email_And_Password() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSecond(3);

        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-email")).getText(), "This is a required field.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-pass")).getText(), "This is a required field.");
    }

    @Test
    public void Login_02_Invalid_Email() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSecond(3);

        driver.findElement(By.cssSelector("input#email")).sendKeys("12341234@1234.1234");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123456");

        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-email-email")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");
    }

    @Test
    public void Login_03_Incorrect_Password() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSecond(3);

        driver.findElement(By.cssSelector("input#email")).sendKeys("hangcnnguyen@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123");

        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-password-pass")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test
    public void Login_04_Incorrect_mail_Or_Password() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSecond(3);

        driver.findElement(By.cssSelector("input#email")).sendKeys("hangcnnguyen@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123123123123");

        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.error-msg")).getText(),"Invalid login or password.");

        driver.findElement(By.cssSelector("input#email")).clear();
        driver.findElement(By.cssSelector("input#pass")).clear();

        driver.findElement(By.cssSelector("input#email")).sendKeys("automationfc@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123456");

        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.error-msg")).getText(),"Invalid login or password.");
    }

    @Test
    public void Login_05_Success() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSecond(3);

        // Dang ki 1 tài kho¢n truöc
        driver.findElement (By.xpath("//a[@title='Create an Account']")).click();
        sleepInSecond(2);

        String firstName = "Autonmation", lastName = "FC", emailAddress = getEmailAddress() , password = "123456789";
        String fullName = firstName + " " + lastName;

        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstName);
        driver.findElement (By.cssSelector ("input#lastname")).sendKeys (lastName);
        driver.findElement (By.cssSelector ("input#email_address")).sendKeys (emailAddress);
        driver.findElement (By.cssSelector("input#password")).sendKeys (password);
        driver.findElement (By.cssSelector ("input#confirmation")).sendKeys(password);
        driver.findElement (By.cssSelector("button[title='Register']")).click();
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"Thank you for registering with Main Website Store.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText(),"Hello, " + fullName + "!");

        String contactInfo = driver.findElement(By.xpath("//h3[text() = 'Contact Information']/parent::div/following-sibling::div/p")).getText();
        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(emailAddress));

        // Logout
        driver.findElement (By.cssSelector ("a.skip-account")).click();
        sleepInSecond(2);
        driver.findElement (By.cssSelector ("a[title='Log Out']")).click();
        sleepInSecond(5);

        // Login
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSecond(5);

        driver.findElement(By.cssSelector("input#email")).sendKeys(emailAddress);
        driver.findElement (By.cssSelector("input#pass")).sendKeys(password);

        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText(),"Hello, " + fullName + "!");

        contactInfo = driver.findElement(By.xpath("//h3[text() = 'Contact Information']/parent::div/following-sibling::div/p")).getText();
        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(emailAddress));

        // Verify Account
        driver.findElement(By.xpath("//a[text () = 'Account Information']")).click();
        sleepInSecond(2);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#firstname")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#lastname")).getAttribute ("value"), lastName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#email")).getAttribute ("value"), emailAddress);
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

    public String getEmailAddress() {
        Random rand = new Random();
        return "automation" + rand.nextInt(99999) + "@gmail.com";
        //return "automation" + new Random().nextInt(99999) + "@gmail.com"; cách 2
    }
}

