package javaTester.javaBasic;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_12_String {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "./browserDrivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        String schoolName = "Automation Testing Advanced";
        String courseName = "AUTOMATION TESTING ADVANCED";
        String schollAddress = "Ho Chi Minh City";

        System.out.println("Do dai = " + schoolName.length());
        System.out.println("Lay ra 1 ki tu nao do = " + schoolName.charAt(1));
        System.out.println("Noi 2 chuoi = " + schoolName.concat(schollAddress));
        System.out.println("Noi 2 chuoi = " + schoolName + schollAddress);

        // Tuyệt đối
        System.out.println("Kiem tra 2 chuoi bang nhau tuyet doi = " + schoolName.equals(courseName));
        System.out.println("Kiem tra 2 chuoi bang nhau tuyet doi = " + schoolName.equals("Automation Testing Advanced"));

        // Multi browser
        System.out.println("Kiem tra 2 chuoi bang nhau tuong doi = " + schoolName.equalsIgnoreCase(courseName));

        // startWith / endsWith / contains
        System.out.println("Có bắt đầu bằng 1 kí tự /1 chuỗi kí tự hay không = " + schoolName.startsWith("A"));
        System.out.println("Có bắt đầu bằng 1 kí tự /1 chuỗi kí tự hay không = " + schoolName.startsWith("Automation"));
        System.out.println("Có bắt đầu bằng 1 kí tự /1 chuỗi kí tự hay không = " + schoolName.startsWith("T"));

        System.out.println("Có chứa 1 kí tự /1 chuỗi kí tự hay không = " + schoolName.contains("Automation"));
        System.out.println("Có chứa 1 kí tự /1 chuỗi kí tự hay không = " + schoolName.contains("T"));
        System.out.println("Có chứa 1 kí tự /1 chuỗi kí tự hay không = " + schoolName.contains("Testing"));

        System.out.println("Có kết thúc bằng 1 kí tự /1 chuỗi kí tự hay không = " + schoolName.endsWith("g"));
        System.out.println("Có kết thúc bằng 1 kí tự /1 chuỗi kí tự hay không = " + schoolName.endsWith("Automation"));
        System.out.println("Có kết thúc bằng 1 kí tự /1 chuỗi kí tự hay không = " + schoolName.contains("Testing"));

        // Vị trí của 1 kí tự / chuối kí tự
        System.out.println("Vị trí của 1 kí tự/ chuỗi kí tự trong chuỗi = " + schoolName.indexOf("Automation"));
        System.out.println("Vị trí của 1 kí tự/ chuỗi kí tự trong chuỗi = " + schoolName.indexOf("A"));
        System.out.println("Vị trí của 1 kí tự/ chuỗi kí tự trong chuỗi = " + schoolName.indexOf("Testing"));

        // Tách 1 chuối từ 1 chuỗi cho trước
        System.out.println("Tách 1 kí tự/ chuỗi kí tự trong chuỗi = " + schoolName.substring(11));
        System.out.println("Tách 1 kí tự/ chuỗi kí tự trong chuỗi = " + schoolName.substring(11, 15));

        // Tách chuỗi thành 1 mảng dựa vào kí tự/ chuỗi kí tự
        // Alert
        String result = "Viewing 48 of 132 results";
        String results[] = result.split(" ");
        System.out.println(results[1]);

        // Replace
        String productPrice = "$100.00";
        productPrice = productPrice.replace("$", "");
        System.out.println(productPrice);

        // Convet String -> float
        // Sắp xếp nó: Sort Data (Asc/ Desc)
        float productPriceF = Float.parseFloat(productPrice);
        System.out.println(productPriceF);

        // Convet Float -> String
        productPrice = String.valueOf(productPriceF);
        System.out.println(productPrice);

        String osName = System.getProperty("os.name");
        System.out.println(osName);
        // Handle multiple OS: MAC/ Windowns (Actions - key - Ctrl/ Command)
        if(osName.toLowerCase().contains("windows")){
            Keys key = Keys.CONTROL;
        } else {
            Keys key = Keys.COMMAND;
        }

        // Multiple browser: toUpperCase
        // firefox = FIREFOX (Enum)

        String driverInstanceName = driver.toString();
        System.out.println(driverInstanceName);

        // Close browser/ driver
        if (driverInstanceName.contains("internetexplorer")){
            // Sleep cứng thêm 5s sau mỗi sự kiện chuyển page
        }

        // Trim: cắt bỏ khoảng trắng/ xuống dòng/ tab ở đầu hoặc ở cuối
        String helloWorld = " \n  \t  Hello World!         ";
        System.out.println(helloWorld.trim());

        helloWorld = " ";
        System.out.println("Empty = " + helloWorld.isEmpty());
        System.out.println("Blank = " + helloWorld.isBlank());

        // Dynamic locator
        // Đại diện cho 1 chuỗi: %s
        // %b %t %d
        String dynamicButtonXpath = "//button[@id='%s']";
        System.out.println("Click to Login button = " + dynamicButtonXpath.formatted(dynamicButtonXpath, "login"));
        System.out.println("Click to Search button = " + dynamicButtonXpath.formatted(dynamicButtonXpath, "search"));
        System.out.println("Click to Register button = " + dynamicButtonXpath.formatted(dynamicButtonXpath, "register"));
    }
}
