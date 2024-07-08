package javaTester.javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class Topic_06_Condition_Statement {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @Test
    public void TC_01_If() {
        boolean status = 5 < 3;
        System.out.println(status);

        // Hàm if sẽ nhận vào 1 điêu kiện đúng
        // Kiếm tra duy nhất 1 điều kiện
        // Nếu điều kiện này đúng thì sẽ action (Xxx) trong phần thân
        if (status) {
            // Đúng thì vào phần thân của if
            // Sai thì bỏ qua
            System.out.println("Go to if");
        }

        // Gán (assign)
        int studentNumber = 10;

        // So sánh
        status = (studentNumber == 10);
        System.out.println(status);

        WebDriver driver = new FirefoxDriver();

        // Element luôn luôn có trong DOM dù popup hiển thị hay ko
        WebElement salePopup = driver.findElement(By.id("'"));
        if (salePopup. isDisplayed ()) {
        }

        // Element không có trong DOM khi popup ko hiển thị
        List<WebElement> salePopups = driver.findElements(By.id(""));

        // Check element không hiển thị
        if(salePopups.size() > 0 && salePopups.get(0).isDisplayed()){
        }

        // Uncheck to checkbox
        WebElement languagesCheckbox = driver.findElement(By.id(""));
        if (languagesCheckbox.isSelected()){
            languagesCheckbox.click();
        }

        // Check to checkbox
        if (!languagesCheckbox.isSelected()){
            languagesCheckbox.click();
        }
    }

    @Test
    public void TC_02_If_Else() {
        // Có tới 2 điều kiện: nếu như đúng thì vào if - sai thì vào else

        // Nếu driver start vs browser như Chrome/ Firefox/ Edge/ Safari thì dùng hàm click
        // thông thường (builtin) của Selenium WebElement

        // Nếu driver là IE thì dùng hàm click của javascriptExecutor
//        System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
//        driver = new InternetExplorerDriver();

        System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver");
        driver = new ChromeDriver();

        if (driver.toString().contains("internet explorer")) {
            System.out.println("Click by Javascript Executor");
        } else {
            System.out.println("Click by Selenium WebElement");
        }
    }

    @Parameters("browser")
    @Test
    public void TC_03_If_Else_If_Else(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver");
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\edgedriver");
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else {
            throw new RuntimeException("Please input correct the browser name");
        }
    }

    @Test
    public void TC_04_If_Else_If_Else() {
        String pageName = "Login";
        if (pageName.equals("Login")){
//            LoginPage loginPage = new LoginPage();
//            return loginPage;
        } else if (pageName.equals("Register")){
//            RegisterPage registerPage = new RegisterPage();
//            return registerPage;
        } else if (pageName.equals("Customer")){
//            CustomerPage customerPage = new CustomerPage();
//            return customerPage;
        } else {
//            HomePage homePage = new HomePage();
//            return homePage;
        }
        // if - else
        int age = 20;
        String access = (age < 18) ? "You cannot access" : "Welcome to our sysem!";
        System.out.println(access);
    }
}

