package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.*;
import java.nio.charset.Charset;
import java.security.Key;
import java.sql.Driver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Topic_19_Actions_Exercise {
    WebDriver driver;
    Actions actions;

    JavascriptExecutor javascriptExecutor;

    @BeforeClass
    public void beforeClass() {
        // Chromium: Chrome/ Edge/ Cốc Cốc/ Opera,...
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();

        // Nó đang giả lập lại hành vi của Mouse/ Keyboard/ Pen nên khi nó đang chạy mình không nên sd các thiết bị
        actions = new Actions(driver);

        javascriptExecutor = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Hover_Tooltop() {
        driver.get("https://automationfc.github.io/jquery-tooltip/");

        WebElement ageTextbox = driver.findElement(By.cssSelector("input#age"));

        actions.moveToElement(ageTextbox).perform();
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(),
                "We ask for your age only for statistical purposes.");
    }

    @Test
    public void TC_02_Hover_Element_Myntra_Page() {
        driver.get("http://www.myntra.com/");

        actions.moveToElement(driver.findElement(By.xpath(
                "//a[text()='Kids' and @class='desktop-main']"))).perform();
        sleepInSecond(3);

        actions.click(driver.findElement(By.xpath(
                "//a[text()='Home & Bath' and @class='desktop-categoryName']"))).perform();
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.xpath("//h1[@class='title-title']")).getText(),
                "Kids Home Bath");
    }

    @Test
    public void TC_03_Hover_Element_Fahasa_Page() {
        driver.get("https://www.fahasa.com/");

        actions.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();
        sleepInSecond(3);

        actions.moveToElement(driver.findElement(By.xpath("//a[@title='Bách Hóa Online - Lưu Niệm']"))).perform();
        sleepInSecond(3);

        driver.findElement(By.xpath("//div[contains(@class,'fhs_menu_content')]//a[text()='Thiết Bị Số - Phụ Kiện Số']")).click();
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("ol.breadcrumb strong")).getText(), "THIẾT BỊ SỐ - PHỤ KIỆN SỐ");

        Assert.assertTrue(driver.findElement(By.xpath("//ol[@class='breadcrumb']//strong[text()='Thiết Bị Số - Phụ Kiện Số' ]")).isDisplayed());
    }

    @Test
    public void TC_04_ClickAndHold_Select_Multiple_Item() {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        // Tổng các số chưa chọn
        List<WebElement> allNumbers = driver.findElements(By.cssSelector("li.ui-state-default"));

        Assert.assertEquals(allNumbers.size(), 20);

        // Chọn theo block - Ngang/Dọc
        // Chọn 1-15
        actions.clickAndHold(allNumbers.get(0)) // Click lên số 1 và giữ chuột
                .pause(2000)
                .moveToElement(allNumbers.get(14)) // Di chuột trái đến số 15
                .pause(2000)
                .release() // Nhả chuột trái ra
                .perform(); // Excute tất cả các action trên

        sleepInSecond(3);

        // Tổng các số đã chọn
        List<WebElement> allNumbersSelected = driver.findElements(By.cssSelector("li.ui-state-default.ui-selected")) ;
        Assert.assertEquals(allNumbersSelected.size(), 12) ;

        // Lấy ra text của các ô đã được chọn
        List<String> allNumberTextExpected = Arrays.asList("1", "2", "3", "5", "6", "7", "9", "10", "11", "13", "14", "15");

        List<String> allNumberTextActual = new ArrayList<String>(); // khởi tạo 1 list chứa all number

        for (WebElement element: allNumbersSelected){ // vòng lặp duyệt qua allNumbersSelected
            allNumberTextActual.add(element.getText()); // mỗi lần chạy add text
        }

        Assert.assertEquals(allNumberTextExpected, allNumberTextActual);
    }

    @Test
    public void TC_05_01_ClickAndHold_Select_Multiple_Item() {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        String osName = System.getProperty("os.name");
        Keys keys;

        if(osName.startsWith("Windowns")){
            keys = Keys.CONTROL;
        } else {
            keys = Keys.COMMAND;
        }

        // Cách 2:
       // Keys cmdCtrl = Platform.getCurrent().is(Platform.MAC) ? Keys.COMMAND : Keys.CONTROL;

        // Tổng các số chưa chọn
        List<WebElement> allNumbers = driver.findElements(By.cssSelector("li.ui-state-default"));
        Assert.assertEquals(allNumbers.size(), 20);

        // Chọn 1-15 theo đủ hàng/ cột
        actions.clickAndHold(allNumbers.get(0)).moveToElement(allNumbers.get(11)).release().perform();

        // Chọn 13-> 15
        actions.keyDown(keys).perform(); // Nhấn phím Ctrl xuống (chưa nhả ra)

        actions.click(allNumbers.get(12))
                .click(allNumbers.get(13))
                .click(allNumbers.get(14))
                .keyUp(keys).perform();
        sleepInSecond(3);

        // Tổng các số đã chọn
        List<WebElement> allNumbersSelected = driver.findElements(By.cssSelector("li.ui-state-default.ui-selected"));
        Assert.assertEquals(allNumbersSelected.size(), 15);
    }

    @Test
    public void TC_05_02_ClickAndHold_Select_Random_Item() {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        Keys cmdCtrl = Platform.getCurrent().is(Platform.MAC) ? Keys.COMMAND : Keys.CONTROL;

        // Tổng các số chưa chọn
        List<WebElement> allNumbers = driver.findElements(By.cssSelector("li.ui-state-default"));
        Assert.assertEquals(allNumbers.size(), 20);

        // Chọn random 1 - 3 - 6 - 11
        actions.keyDown(cmdCtrl).perform(); // Nhấn phím Cmd xuống (chưa nhả ra)

        List<Integer> allNumberToClickExpected = Arrays.asList(0, 2, 5, 10); // Các index của phần tử bạn muốn click
        Actions actions = new Actions(driver); // khởi tạo một đối tượng Actions sẽ sử dụng để xây dựng và thực thi chuỗi hành động.

        for (Integer index : allNumberToClickExpected) { // vòng lặp duyệt qua allNumberToClickExpected
            actions.click(allNumbers.get(index)); // mỗi lần duyệt qua get index rồi click
        }
        actions.keyUp(cmdCtrl).perform();
        sleepInSecond(3);

        // Tổng các số đã chọn
        List<WebElement> allNumbersSelected = driver.findElements(By.cssSelector("li.ui-state-default.ui-selected"));
        Assert.assertEquals(allNumbersSelected.size(), 4);
    }

    @Test
    public void TC_06_Double_Click() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement douleClickElement = driver.findElement(By.xpath("//button[text()='Double click me']"));

        // Đối với firefox cần scroll tới elemetn ròi mới double click
        if(driver.toString().contains("firefox")){
            // scrollIntoView(true): kéo mép trên của elemnt
            // scrollIntoView(false): kép mép dưới của element
            javascriptExecutor.executeScript("arguments[0].scrollIntoView(false)",douleClickElement);
            sleepInSecond(2);
        }

        actions.doubleClick(douleClickElement).perform();
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(), "Hello Automation Guys!");
    }

    @Test
    public void TC_07_Right_Click() {
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

        // Chưa click chuột phải -> không hiện ra options để chọn -> các elements được disable
        Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-paste")).isDisplayed());

        // Click chuột phải
        actions.contextClick(driver.findElement(By.cssSelector("span.context-menu-one"))).perform();
        sleepInSecond(2);

        // Mới click chuột phải -> hiện ra options để chọn -> các elements được visiable
        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-paste")).isDisplayed());

        // Hover lên các element
        actions.moveToElement(driver.findElement(By.cssSelector("li.context-menu-icon-paste"))).perform();
        sleepInSecond(2);

        // Được cập nhật lại class của element này - kiểm tra sự kiện hover thành công
        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-paste.context-menu-hover.context-menu-visible")).isDisplayed());

        // Click lên Paste
        actions.click(driver.findElement(By.cssSelector("li.context-menu-icon-paste"))).perform();
        sleepInSecond(3);

        // Accept alert
        driver.switchTo().alert().accept();
        sleepInSecond(3);

        // Kiểm tra Paste không còn hiển thị nữa
        Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-paste")).isDisplayed());
    }

    @Test
    public void TC_08_Drag_And_Drop_HTML4() {
        driver.get("https://automationfc.github.io/kendo-drag-drop/");

        WebElement smallCircle = driver.findElement(By.cssSelector("div#draggable"));
        WebElement bigCircle = driver.findElement(By.cssSelector("div#droptarget"));

        // Cach 1: actions.dragAndDrop(smallCircle, bigCircle).pause(3000).perform();
        // Cach 2:
        actions.clickAndHold(smallCircle).moveToElement(bigCircle).release().perform();
        sleepInSecond(3);

        Assert.assertEquals(bigCircle.getText(), "You did great!");

        Assert.assertEquals(Color.fromString(bigCircle.getCssValue("background-color")).asHex().toLowerCase(),"#03a9f4");
    }

    @Test
    public void TC_09_Drag_And_Drop_HTML5_Css() throws IOException {
        driver.get("https://automationfc.github.io/drag-drop-html5/");

       String columnA = "div#column-a";
       String columnB = "div#column-b";

        String projectPath = System.getProperty("user.dir");

        String dragAnDropFilePath = projectPath + "/dragAndDrop/drap_and_drop_helper.js";

        String jsContentFile = getContentFile(dragAnDropFilePath);

        jsContentFile = jsContentFile + "$('" + columnA + "').simulateDragDrop({ dropTarget: '" + columnB + "'});";

        // A -> B
        javascriptExecutor.executeScript(jsContentFile);
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(), "B");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(), "A");

        // B -> A
        javascriptExecutor.executeScript(jsContentFile);
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(), "A");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(), "B");
    }

    @Test
    public void TC_09_02_Drag_And_Drop_HTML5_XPath() throws AWTException {
        driver.get("https://automationfc.github.io/drag-drop-html5/");

        dragAndDropHTML5ByXpath("//div[@id='column-a']", "//div[@id='column-b']");
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(), "B");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(), "A");

        dragAndDropHTML5ByXpath("//div[@id='column-b']", "//div[@id='column-a']");
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(), "A");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(), "B");
    }

    public String getContentFile(String filePath) throws IOException {
        Charset cs = Charset.forName("UTF-8");
        FileInputStream stream = new FileInputStream(filePath);
        try {
            Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[8192];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            return builder.toString();
        } finally {
            stream.close();
        }
    }

    public void dragAndDropHTML5ByXpath(String sourceLocator, String targetLocator) throws AWTException {

        WebElement source = driver.findElement(By.xpath(sourceLocator));
        WebElement target = driver.findElement(By.xpath(targetLocator));

        // Setup robot
        Robot robot = new Robot();
        robot.setAutoDelay(500);

        // Get size of elements
        Dimension sourceSize = source.getSize();
        Dimension targetSize = target.getSize();

        // Get center distance
        int xCentreSource = sourceSize.width / 2;
        int yCentreSource = sourceSize.height / 2;
        int xCentreTarget = targetSize.width / 2;
        int yCentreTarget = targetSize.height / 2;

        Point sourceLocation = source.getLocation();
        Point targetLocation = target.getLocation();

        // Make Mouse coordinate center of element
        sourceLocation.x += 20 + xCentreSource;
        sourceLocation.y += 110 + yCentreSource;
        targetLocation.x += 20 + xCentreTarget;
        targetLocation.y += 110 + yCentreTarget;

        // Move mouse to drag from location
        robot.mouseMove(sourceLocation.x, sourceLocation.y);

        // Click and drag
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseMove(((sourceLocation.x - targetLocation.x) / 2) + targetLocation.x, ((sourceLocation.y - targetLocation.y) / 2) + targetLocation.y);

        // Move to final position
        robot.mouseMove(targetLocation.x, targetLocation.y);

        // Drop
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
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
