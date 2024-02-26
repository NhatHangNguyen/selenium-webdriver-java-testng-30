package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_09_WebElement_Commands {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_01_Element() {
        // HTML Element: Textbox/ TextArea/  Dropdown/ Checkbox/ Link/ Button,...
        // Tìm và trả về 1 element, chưa tương tác lên
        driver.findElements(By.id(""));

        // Tìm và tương tác lên
        driver.findElement(By.id("")).click();
        driver.findElement(By.id("")).sendKeys();

        // Tìm và lưu nó vào 1 biến WebElement (chưa tương tác lên)
        // Khi có dùng biến này ít nhất từ 2 lần trở lên
        WebElement fullNameTextBox =  driver.findElement(By.id(""));

        // Dùng dể xoá dữ liệu trong 1 field cho phép nhập (editable)
        // Textbox / TextArea / Dropdown (Editable)
        // Thường được sử dụng trước hàm sendKeys
        driver.findElement(By.id("")).clear();

        // Dùng dể nhập dữ liệu trong 1 field bên trên
        driver.findElement(By.id("")).sendKeys("Testing");

        // / Dùng dể click leen element
        driver.findElement(By.id("")).click();

        // Tìm từ node cha đến node con
        driver.findElement(By.id("form-validate")).findElement(By.id("firstname"));
        driver.findElement (By.cssSelector ("form#form-validate input#firstname"));

        // Tra vê nhiêu element khop vs diëu kiên
        List<WebElement> textBoxes =  driver.findElements(By.cssSelector(""));

        // Dung de verify 1 checkbok/ radio/ dropdown (default) đã được chon hay chua
        Assert.assertTrue(driver.findElement(By.id("")).isSelected());
        Assert.assertFalse(driver.findElement(By.id("")).isSelected());

        // Dropdown (default/ custom)
        Select select = new Select(driver.findElement (By.id("")));

        // Dung de verify 1 element bât ki có hi§n thi hay ko
        Assert.assertTrue(driver.findElement(By.id("")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.id("")).isDisplayed());

        // Dùng để verify 1 element có được thao tác lên hay không (không phải read-only)
        Assert.assertTrue (driver.findElement (By.id("")).isEnabled ());
        Assert.assertFalse(driver.findElement(By.id("")).isEnabled());

        // HTML Element
        // ‹input type="text" id="firstname" name="firstname" value=""
        // title="First Name" maxlength="255" class="input-text required-entry">
        driver.findElement(By.id("")).getAttribute("title");
        driver.findElement (By.id("")) .getAttribute("type");
        driver.findElement (By.id("")) .getAttribute ("id");

        // Tab Accesibility/ Properties trong Elements
        driver.findElement(By.id("")).getAccessibleName();
        driver.findElement (By.id("")).getDomAttribute("checked");
        driver.findElement(By.id("")).getDomProperty("baseURI");
        driver.findElement (By.id("")).getDomProperty("outerHTML");

        // Tab Styles trong Elements
        // Font / Size / Color / Backgroud ....
        driver.findElement(By.id("")).getCssValue("background-color");
        // rgb (46, 138, 184)
        driver.findElement(By.id("")).getCssValue("font-size");
        driver.findElement (By.id("")).getCssValue("text-transform");

        // Vi tri cúa element so vs dô phân giai man hinh
        Point nameTextboxLocation = driver.findElement(By.id("")).getLocation ();
        nameTextboxLocation.getX();
        nameTextboxLocation.getY();

        // Chiêu cao + rông
        Dimension addressSize = driver.findElement(By.id("")).getSize ();

        // Location + Size
        Rectangle nameTextboxRect = driver.findElement (By.id("")).getRect() ;

        // Location
        Point namePoint = nameTextboxRect.getPoint ();

        // Size
        Dimension nameSize = nameTextboxRect.getDimension();
        nameSize.getHeight ();
        nameSize.getWidth ();

        // Shadow Element (JavascriptExecutor)
        driver.findElement(By.id("")).getShadowRoot();

        // Tu id/ class/ name/ css/ xpath có thể truy ra ngugo lai tagname HTML
        driver.findElement (By.cssSelector ("#firstname")).getTagName (); //input
        driver.findElement(By.id("firstname")).getTagName (); //input
        driver.findElement (By.className("form-instructions")).getTagName (); //p

        // Element A -> dâu ra cúa nó là tagname cúa element A
        String formListTag = driver.findElement(By.xpath("//* [@class='form-list']")).getTagName (); // ul

        // Dâu vão cúa Element B sê nhân tagname cúa element A là tham so
        driver.findElement (By.xpath ("/ /div[@class='remember-me-popup']/preceding-sibling::" + formListTag));

        driver.findElement (By.cssSelector("address.copyright")).getText ();
        // © 2015 Magento Demo Store. All Rights Reserved.
        // Chup hinh bi löi và luu dudi dang não
        // BYTE
        // FILE (Lu thanh 1 hinh có kich thuóc d trong o cúng: png/ .jpg/..)
        // BASE64 (Hinh dang text)
        driver.findElement(By.cssSelector("address.copyright")).getScreenshotAs(OutputType.FILE);
        driver.findElement(By.cssSelector("address.copyright")).getScreenshotAs(OutputType.BASE64);
        driver.findElement(By.cssSelector("address.copyright")).getScreenshotAs(OutputType.BYTES);

        // Form (element não là the form ho¢c nam trong the form)
        // Hanh vi giông phim Enter
        // Register/ Login/ Search/.
        driver.findElement(By.id("")) .submit ();




    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
