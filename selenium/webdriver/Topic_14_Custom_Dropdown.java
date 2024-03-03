package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
}
