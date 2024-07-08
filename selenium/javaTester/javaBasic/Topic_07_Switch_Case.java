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
import java.util.Scanner;

public class Topic_07_Switch_Case {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    Scanner scanner = new Scanner(System.in);

    @Parameters("browser")
    @Test
    public void TC_01_Switch_Case(String browserName) {
        driver = getBrowserDriver(browserName);

        System.out.println(browserName);
        System.out.println(driver.toString());

        driver.quit();
    }

    @Test
    public void TC_02_Switch_Case(String browserName) {
        int month = scanner.nextInt();

        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Thang nay co 31 ngay");
                break;
            case 2:
                System.out.println("Thang nay co 28 ngay");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Thang nay co 30 ngay");
                break;
            default:
                System.out.println("Thang vua nhap sai dinh dang!");
                break;
        }
    }

    @Test
    public void TC_03_Switch_Case() {
        int number = scanner.nextInt();

        switch (number){
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            case 4:
                System.out.println("Four");
                break;
            case 5:
                System.out.println("Five");
                break;
            case 6:
                System.out.println("Six");
                break;
            case 7:
                System.out.println("Seven");
                break;
            case 8:
                System.out.println("Eight");
                break;
            case 9:
                System.out.println("Nine");
                break;
            case 10:
                System.out.println("Ten");
                break;
        }
    }

    @Test
    public void TC_04_Switch_Case() {
        int numberA = scanner.nextInt();
        int numberB = scanner.nextInt();
        String operator = scanner.next();

        switch(operator) {
            case "+":
                System.out.println("A + B = " + (numberA + numberB));
                break;
            case "-":
                System.out.println("A - B = " + (numberA - numberB));
                break;
            case "*":
                System.out.println("A * B = " + (numberA * numberB));
                break;
            case "/":
                System.out.println("A / B = " + (numberA / numberB));
                break;
            case "%":
                System.out.println("A % B = " + (numberA % numberB));
                break;
        }
    }

    public WebDriver getBrowserDriver(String browserName){
        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", projectPath + "//browserDrivers//chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", projectPath + "//browserDrivers//chromedriver.exe");
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", projectPath + "//browserDrivers//chromedriver.exe");
                driver = new EdgeDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", projectPath + "//browserDrivers//chromedriver.exe");
                driver = new InternetExplorerDriver();
                break;
            default:
                new RuntimeException("Please input correct the browser name!");
                break;
        }
        return driver;
    }
}


