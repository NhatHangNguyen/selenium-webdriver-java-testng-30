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

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class Topic_17_Checkbox_Radio_Exercise {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Default_Checkbox_Telerik() {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        sleepInSecond(5);

        By dualZoneCheckBox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::input");
        By rearSideAirbagsCheckBox = By.xpath("//label[text()='Rear side airbags']/preceding-sibling::input");

        // Chọn 2 checkbox
        // Case 1: nếu như app này mở ra mà checkbox chưa được chọn thì sao
        checkToElement(dualZoneCheckBox);

        // Case 2: Nếu như app này mở ra mà checkbox đã được chọn thì sao
        checkToElement(rearSideAirbagsCheckBox);

        // Verify checkbox đã được chọn chọn thành công
        Assert.assertTrue(driver.findElement(dualZoneCheckBox).isSelected());
        Assert.assertTrue(driver.findElement(rearSideAirbagsCheckBox).isSelected());

        // Bỏ chọn 2 checkbox
        unCheckToElement(dualZoneCheckBox);
        unCheckToElement(rearSideAirbagsCheckBox);

        // Verify checkbox đã bỏ chọn chọn thành công
        Assert.assertFalse(driver.findElement(dualZoneCheckBox).isSelected());
        Assert.assertFalse(driver.findElement(rearSideAirbagsCheckBox).isSelected());
    }

    @Test
    public void TC_02_Default_Radio_Telerik() {
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");

        By twoPetrolRadio = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::input");
        By twoDieselRadio = By.xpath("//label[text()='2.0 Diesel, 103kW']/preceding-sibling::input");

        // Click chon 1 trong 2
        checkToElement(twoPetrolRadio);

        // Verify
        Assert.assertTrue(driver.findElement(twoPetrolRadio).isSelected());
        Assert.assertFalse(driver.findElement(twoDieselRadio).isSelected());

        checkToElement(twoDieselRadio);

        // Verify
        Assert.assertTrue(driver.findElement(twoDieselRadio).isSelected());
        Assert.assertFalse(driver.findElement(twoPetrolRadio).isSelected());
    }

    @Test
    public void TC_03_Default_Checkbox_And_Radio() {
        driver.get("https://material.angular.io/components/radio/examples");

        By summerRadioButton = By.xpath("//input[@value='Summer']");

        // Nếu radio CHƯA ĐƯỢC CHỌN thì mới click
        checkToElement(summerRadioButton);

        // Verify radio được chọn thành công
        Assert.assertTrue(driver.findElement(summerRadioButton).isSelected());

        driver.get("https://material.angular.io/components/checkbox/examples");

        By checkedBoxButton = By.xpath("//label[text()='Checked']/preceding-sibling::div/input");
        By indeterminateCheckboxButton = By.xpath("//label[text()='Indeterminate']/preceding-sibling::div/input");

        // Click 2 checkbox
        checkToElement(checkedBoxButton);
        checkToElement(indeterminateCheckboxButton);

        // Verify
        Assert.assertTrue(driver.findElement(checkedBoxButton).isSelected());
        Assert.assertTrue(driver.findElement(indeterminateCheckboxButton).isSelected());

        // Click 1 lần nữa để bỏ chọn
        unCheckToElement(checkedBoxButton);
        unCheckToElement(indeterminateCheckboxButton);

        // Verify
        Assert.assertFalse(driver.findElement(checkedBoxButton).isSelected());
        Assert.assertFalse(driver.findElement(indeterminateCheckboxButton).isSelected());
    }

    @Test
    public void TC_04_Select_All_Default_Checkboxes_And_1_In_All(){
        driver.get("https://automationfc.github.io/multiple-fields/");

        List<WebElement> allCheckboxes = driver.findElements(By.cssSelector("div.form-single-column input[type='checkbox']"));

        // Chọn tất cả checkbox/ radio trong màn hình đó
        // Tạo 1 biến tạm có kiểu List đg chứa duyệt qua tất cả checkboxes
        for(WebElement checkbox: allCheckboxes){
            if(!checkbox.isSelected()){
                checkbox.click();
                sleepInSecond(2);
            }
        }

        // Veify hết toàn bộ checkbox đã được chọn thành công
        for(WebElement checkbox: allCheckboxes){
            Assert.assertTrue(checkbox.isSelected());
        }

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        allCheckboxes = driver.findElements(By.cssSelector("div.form-single-column input[type='checkbox']"));

        // Chọn 1 checkbox/ radio nào đó trong tất cả các checkbox/
        for(WebElement checkbox : allCheckboxes){
            if(checkbox.getAttribute("value").equals(" Heart Attack ") && !checkbox.isSelected()){
                checkbox.click();
                sleepInSecond(2);
            }
        }

        // Veify hết toàn bộ checkbox
        for (WebElement checkbox : allCheckboxes){
            if(checkbox.getAttribute("value").equals(" Heart Attack ")){
                Assert.assertTrue(checkbox.isSelected());
            } else {
                Assert.assertFalse(checkbox.isSelected());
            }
        }
    }

    @Test
    public void TC_05_Custom_Radio(){
        driver.get("https://tiemchungcovid19.gov.vn/portal/register-person");

        // Case 1: Dùng thẻ input để click => Thẻ input bị che bởi 1 element khác => Failed
        // Hàm click của webElement.click(): The element must be visible and it gust have a height and width greater than o
        // isSelected: only applies to input elements


        // Case 2
        // Dùng thẻ div bên ngoài để click => Passed
        // Dùng thẻ div để verify => Failed
        driver.findElement(By.xpath("//div[text()='Đăng ký cho người thân']/preceding-sibling::div/div[@class='mat-radio-outer-circle']")).click();
        sleepInSecond(3);
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Đăng ký cho người thân']/preceding-sibling::div/div[@class='mat-radio-outer-circle']")).isSelected());

        // Case 3
        // Dùng thẻ div bên ngoài để click => Passed
        // Dùng thẻ input để verify => Passed
        // 1 element mà cần define tới 2 locator thì sau này => Maintain mất nhiều thời gian hơn
        driver.findElement(By.xpath("//div[text()='Đăng ký cho người thân']/preceding-sibling::div/div[@class='mat-radio-outer-circle']")).click();
        sleepInSecond(3);
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Đăng ký cho người thân']/preceding-sibling::div/input")).isSelected());

        // Case 4:
        // Dùng thẻ input để click => JavascriptExcutor (JS)
        // Dùng thẻ input để verify
        // Chỉ cần 1 locator
        By registerRadio = By.xpath("//div[text()='Đăng ký cho người thân']/preceding-sibling::div/input");

        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",
                driver.findElement(registerRadio));

        Assert.assertTrue(driver.findElement(registerRadio).isSelected());

//        // Khai bao bien
//        // interface WebDriver
//        // interface JavascriptExecutor
//        // Ép kiểu Interface qua kiểu interface khác
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("");
    }

    @Test
    public void TC_06_Custom_Checkbox_And_Radio_Google(){
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
        sleepInSecond(5);

        By radioButton = By.xpath("//div[@data-value='Cần Thơ']");
        By checkboxButton = By.xpath("//div[@data-answer-value='Quảng Ninh']");

        // Kiểm tra "Cần Thơ" radio button là chưa được chọn
        Assert.assertEquals(driver.findElement(radioButton).getAttribute("aria-checked"),"false");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-value='Cần Thơ' and @aria-checked = 'false']")).isDisplayed());

        // Click chọn Cần Thơ radio button
        driver.findElement(radioButton).click();
        sleepInSecond(5);

        // Kiểm tra "Cần Thơ" radio button đã được chọn
        Assert.assertEquals(driver.findElement(radioButton).getAttribute("aria-checked"),"true");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-value='Cần Thơ' and @aria-checked = 'true']")).isDisplayed());

        // Kiểm tra "Quảng Ninh" checkbox button chưa được chọn
        Assert.assertEquals(driver.findElement(checkboxButton).getAttribute("aria-checked"), "false");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-answer-value='Quảng Ninh' and @aria-checked = 'false']")).isDisplayed());

        // Click chon Qung Ninh
        driver.findElement(checkboxButton).click();
        sleepInSecond(5);

        // Kiểm tra "Quang Ninh" radio button đã được chọn
        Assert.assertEquals(driver.findElement(checkboxButton).getAttribute("aria-checked"),"true");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-answer-value='Quảng Ninh' and @aria-checked= 'true']")).isDisplayed());
        }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }

    // Case 1: nếu như app này mở ra mà checkbox CHƯA ĐƯỢC CHỌN thì mới click
    public void checkToElement(By byXpath){
        if(!driver.findElement(byXpath).isSelected()){
            driver.findElement(byXpath).click();
            sleepInSecond(5);
        }
    }

    // Case 2: nếu như app này mở ra mà checkbox ĐÃ ĐƯỢC CHỌN thì click lần nữa -> BỎ CHỌN
    public void unCheckToElement(By byXpath){
        if(driver.findElement(byXpath).isSelected()){
            driver.findElement(byXpath).click();
            sleepInSecond(5);
        }
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
