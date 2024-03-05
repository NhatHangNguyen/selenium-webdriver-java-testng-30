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

import java.time.Duration;
import java.util.List;

public class Topic_14_Custom_Dropdown {
    WebDriver driver;

    // Tường minh: trạng thái cụ thể của element
    // Visible /  Invisible / Presence / Number / Clicka /...
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Wait ngầm định: không rõ  cho 1 trạng thái cụ thể của element hết
        // Cho việc tìm element nào đó - findElement
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_JQuery() {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        selectItemDropdown("span#speed-button","ul#speed-menu div","Faster");
        sleepInSecond (3);

        selectItemDropdown("span#files-button","ul#files-menu div","ui.jQuery.js");
        sleepInSecond(3);

        selectItemDropdown("span#number-button", "ul#number-menu div","15");
        sleepInSecond(3);

        selectItemDropdown("span#salutation-button","ul#salutation-menu div","Dr.");
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(),"Faster");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#files-button>span.ui-selectmenu-text")).getText(),"ui.jQuery.js");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(),"15");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(),"Dr.");
    }

    @Test
    public void TC_02_React() {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

        selectItemDropdown("i.dropdown.icon", "div.item>span.text","Christian");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Christian");
        sleepInSecond(3);

        selectItemDropdown("i.dropdown.icon","div.item>span.text","Jenny Hess");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText (),"Jenny Hess");
        sleepInSecond(3);

        selectItemDropdown("i.dropdown.icon","div.item>span.text","Justen Kitsune");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Justen Kitsune");
        sleepInSecond(3);
    }

    @Test
    public void TC_03_VueJS() {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");

        selectItemDropdown("li.dropdown-toggle","ul.dropdown-menu a","Second Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Second Option");
        sleepInSecond(3);

        selectItemDropdown("li.dropdown-toggle","ul.dropdown-menu a","First Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "First Option");
        sleepInSecond(3);

        selectItemDropdown("li.dropdown-toggle","ul.dropdown-menu a","Third Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Third Option");
        sleepInSecond(3);
    }

    @Test
    public void TC_04_Editable() {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");

        selectItemEditableDropdown("input.search", "div.item span", "Algeria");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Algeria");
        sleepInSecond(3);

        selectItemEditableDropdown("input.search", "div.item span", "Australia");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Australia");
        sleepInSecond(3);

        selectItemEditableDropdown("input.search", "div.item span", "Belgium");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Belgium");
        sleepInSecond(3);
    }

    @Test
    public void TC_05_NopCommerce() {
        driver.get("https://demo.nopcommerce.com/register");

        selectItemDropdown("select[name='DateOfBirthDay']","select[name='DateOfBirthDay']>option","18");
        Assert.assertTrue(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']>option[value='18']")).isSelected ());
        sleepInSecond(2);

        selectItemDropdown("select[name='DateOfBirthMonth']","select[name='DateOfBirthMonth']>option","September");
        Assert.assertTrue(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']>option[value='9']")).isSelected());
        sleepInSecond(2);

        selectItemDropdown("select[name='DateOfBirthYear']","select[name='DateOfBirthYear']>option","1995");
        Assert.assertTrue(driver.findElement (By.cssSelector("select[name='DateOfBirthYear']>option[value= '1995']")).isSelected ());
        sleepInSecond(2);
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

    // Những dữ liệu dùng để truyền vào sẽ xem là tham số
    public void selectItemDropdown(String parentCss, String childCss, String itemTextExpected){
        driver.findElement(By.cssSelector(parentCss)).click();
        sleepInSecond(5);

        // 2.1 - Nó sẽ xổ ra chứa hêt tât cả các item
        // 2.2 - Nó sẽ xổ ra nhưng chi chứa 1 phan và dang load thêm
        // Chờ cho nó xổ ra hêt tât ca các item trong dropdown

        // Có case item hông visible hết tất cả (Angular/ React,...)
        // Xuất hiện đầy đủ trong HMTL
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));

        List<WebElement> allItem = driver.findElements(By.cssSelector(childCss));
        // allItems đang lưu trữ 19 item bên

        for (WebElement item: allItem){
            String textItem = item.getText();
            System.out.println("Text item = " + textItem);

            if(textItem.equals(itemTextExpected)){
                item.click();
                break;
            }
        }
        // 3.1 Nếu item cần chọn nó hiển thị thì click vào
        // 3.2 Nếu item cần chọn nằm bên dưới thì 1 số TH cần srcoll xuống để hiển thị lên rồi mới chọn  (Angular/ React, VueJS,...)
        // 4. Trước khi click cần kiểm tra nếu như text của item bằng với item cần chọn thì click
    }

    public void selectItemEditableDropdown(String parentCss, String childCss, String itemTextExpected){
        driver.findElement(By.cssSelector(parentCss)).clear();
        driver.findElement(By.cssSelector(parentCss)).sendKeys(itemTextExpected);
        sleepInSecond(1);

        List<WebElement> allItem = explicitWait.until(ExpectedConditions.
                    presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));
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
