package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_25_JavascriptExcecutor {

    WebDriver driver;

    JavascriptExecutor jsExecutor;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();

        //Ép kiểu tường minh
        // Từ kiểu dữ liệu này qua kiểu khác
        jsExecutor = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Panda() {
        executeForBrowser("window.location= 'http://live.techpanda.org/'");
        sleepInSecond(5);

        String techPandaDomain = (String) executeForBrowser("return document.domain;");
        Assert.assertEquals(techPandaDomain, "live.techpanda.org");

        String homePageUrl = (String) executeForBrowser("return document.URL");
        Assert.assertEquals(homePageUrl, "http://live.techpanda.org/");

        hightlightElement("//a[text()='Mobile']");
        clickToElementByJS("//a[text()='Mobile']");;

        hightlightElement("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button");
        clickToElementByJS("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button");;

        Assert.assertTrue(getInnerText().contains("Samsung Galaxy was added to your shopping cart."));

        hightlightElement("//a[text()='Customer Service']");
        clickToElementByJS("//a[text()='Customer Service']");;

        String customerServiceTitle = (String) executeForBrowser("return document.title;");
        Assert.assertEquals(customerServiceTitle, "Customer Service");

        scrollToBottomPage();

        hightlightElement("//input[@type='email']");
        sendkeyToElementByJS("//input[@type='email']", getEmailAddress());

        hightlightElement("//button[@title='Subscribe']");
        clickToElementByJS("//button[@title='Subscribe']");;

        //Assert.assertTrue(isExpectedTextInInnerText("Thank you for your subscription."));
        Assert.assertTrue(getInnerText().contains("Thank you for your subscription."));

        navigateToUrlByJS("https://www.facebook.com/");
        sleepInSecond(3);

        Assert.assertEquals(executeForBrowser("return document.domain;"), "facebook.com");
    }

    @Test
    public void TC_02_Automationfc(){
        driver.get("https://automationfc.github.io/html5/index.html");

        driver.findElement(By.xpath("//input[@type='submit']")).click();
        sleepInSecond(2);

        Assert.assertEquals(getElementValidationMessage("//input[@type='name']"),"Please fill out this field.");
        sleepInSecond(2);

        driver.findElement(By.xpath("//input[@type='name']")).sendKeys("Testing");
        sleepInSecond(2);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        sleepInSecond(2);

        Assert.assertEquals(getElementValidationMessage("//input[@type='password']"),"Please fill out this field.");
        sleepInSecond(2);

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("test123@");
        sleepInSecond(2);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        sleepInSecond(2);

        Assert.assertEquals(getElementValidationMessage("//input[@type='email']"),"Please fill out this field.");
        sleepInSecond(2);

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("test123@gmail.com@@@");
        sleepInSecond(2);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        sleepInSecond(2);

        Assert.assertEquals(getElementValidationMessage("//input[@type='email']"),"Please enter an email address.");
        sleepInSecond(2);

        driver.findElement(By.xpath("//input[@type='email']")).clear();

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("hangnguyen@gmail.com");
        sleepInSecond(2);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        sleepInSecond(2);

        Assert.assertEquals(getElementValidationMessage("//select[@required='']"),"Please select an item in the list.");
        sleepInSecond(2);
    }

    @Test
    public void TC_03_Sieu_Thi_May_Moc(){
        driver.get("https://sieuthimaymocthietbi.com/account/register");

        driver.findElement(By.xpath("//button[text()='Đăng ký']")).click();
        sleepInSecond(3);

        Assert.assertEquals(getElementValidationMessage("//input[@id='lastName']"),"Please fill out this field.");

        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys ("Automation");
        driver.findElement (By.xpath("//button[text()='Đăng ký']")).click();
        sleepInSecond(3);

        Assert.assertEquals(getElementValidationMessage("//input[@id='firstName']"),"Please fill out this field.");

        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys ("Testing");
        driver.findElement (By.xpath("//button[text()='Đăng ký']")).click();
        sleepInSecond(3);

        Assert.assertEquals(getElementValidationMessage("//input[@id='email']"),"Please fill out this field.");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys ("aa@bb@cc");
        driver.findElement (By.xpath("//button[text()='Đăng ký']")).click();
        sleepInSecond(3);

        Assert.assertEquals(getElementValidationMessage("//input[@id='email']"),"Please enter an email address.");
    }

    @Test
    public void TC_03_Ubuntu(){
        navigateToUrlByJS("https://login.ubuntu.com/");
        sleepInSecond(2);

        if(driver.findElement(By.cssSelector("div.p-modal__dialog")).isDisplayed()){
            driver.findElement(By.cssSelector("button#cookie-policy-button-accept")).click();
        }

        driver.findElement(By.xpath("//button[@data-qa-id='login_button']")).click();
        sleepInSecond(3);

       Assert.assertEquals(getElementValidationMessage("//label[@for='id_email']/following-sibling::input[@class='textType']"), "Please fill out this field.");

       driver.findElement(By.xpath("//label[@for='id_email']/following-sibling::input[@class='textType']")).sendKeys("a");
       sleepInSecond(3);

        driver.findElement(By.xpath("//button[@data-qa-id='login_button']")).click();
        sleepInSecond(3);

        Assert.assertEquals(getElementValidationMessage("//label[@for='id_email']/following-sibling::input[@class='textType']"), "Please enter an email address.");
    }

    @Test
    public void TC_05_Tech_Panda(){
        driver.get("http://live.techpanda.org/");

        clickToElementByJS("//div[@class='block-title']/following-sibling::ul/li/a[@title='My Account']");
        sleepInSecond(3);

        clickToElementByJS("//span[text()='Create an Account']");
        sleepInSecond(3);

        String firstName = "Autonmation", lastName = "FC", emailAddress = getEmailAddress() , password = "123456789";

        sendkeyToElementByJS("//input[@id='firstname']", firstName);
        sendkeyToElementByJS("//input[@id='lastname']", lastName);
        sendkeyToElementByJS("//input[@id='email_address']", emailAddress);
        sendkeyToElementByJS("//input[@id='password']", password);
        sendkeyToElementByJS("//input[@id='confirmation']", password);
        clickToElementByJS("//button[@title='Register']");
        sleepInSecond(3);

        Assert.assertEquals(getElement("//li[@class='success-msg']//span").getText(), "Thank you for registering with Main Website Store.");

        clickToElementByJS("//div[@class='account-cart-wrapper']//span[text()='Account']");
        sleepInSecond(3);

        clickToElementByJS("//a[@title='Log Out']");
        sleepInSecond(3);

        Assert.assertEquals(getElement("//div[@class='page-title']/h2").getText(), "THIS IS DEMO SITE FOR");
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

    public Object executeForBrowser(String javaScript) {
        return jsExecutor.executeScript(javaScript);
    }

    public String getInnerText() {
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean isExpectedTextInInnerText(String textExpected) {
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage() {
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(String url) {
        jsExecutor.executeScript("window.location = '" + url + "'");
        sleepInSecond(3);
    }

    public void hightlightElement(String locator) {
        WebElement element = getElement(locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(String locator) {
        jsExecutor.executeScript("arguments[0].click();", getElement(locator));
        sleepInSecond(3);
    }

    public void scrollToElementOnTop(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
    }

    public void scrollToElementOnDown(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
    }

    public void setAttributeInDOM(String locator, String attributeName, String attributeValue) {
        jsExecutor.executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue +"');", getElement(locator));
    }

    public void removeAttributeInDOM(String locator, String attributeRemove) {
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
    }

    public void sendkeyToElementByJS(String locator, String value) {
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
    }

    public String getAttributeInDOM(String locator, String attributeName) {
        return (String) jsExecutor.executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(locator));
    }

    public String getElementValidationMessage(String locator) {
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
    }

    public boolean isImageLoaded(String locator) {
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(locator));
        return status;
    }

    public WebElement getElement(String locator) {
        return driver.findElement(By.xpath(locator));
    }

    public String getEmailAddress() {
        Random rand = new Random();
        return "automationfc" + rand.nextInt(99999) + "@gmail.com";
    }
}
