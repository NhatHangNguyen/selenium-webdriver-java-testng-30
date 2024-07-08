package javaTester.javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Topic_01_Data_Type {
    // Primitive type/ value type: Nguyên thuỷ - không có những hàm functions đi theo
    byte Number = 6;

    short sNumber = 1500;

    int iNumber = 65000;

    long lNumber = 65000;

    float fNumber = 15.98f;

    double dNumber = 15.98d;

    char cChar = '1';

    boolean bStatus = false;

    // Reference type: Tham chiếu - sẽ có nhưng functions đi theo

    // String
    String address = "Ho Chi Minh";

    // Array
    String[] studentAddress = {address,"Ha Noi", "Da Nang"};
    Integer[] studentNumber = {15, 20, 50};

    // Class
    Topic_01_Data_Type topic;

    // Interface
    WebDriver driver;

    // Object
    Object aObject;

    // Collection: List/ Set/ Queue/ Map
    List<WebElement> homePageLink = driver.findElements(By.tagName("a"));
    Set<String> allWindows = driver.getWindowHandles();
    List<String> productName = new ArrayList<String>();

    public void clickToElement(){
        address.trim();

        studentAddress.clone();

        driver.getCurrentUrl();

        aObject.toString();

        homePageLink.size();

        allWindows.clear();

        Topic_01_Data_Type topic = new Topic_01_Data_Type();

        topic.address = "Ha Noi";
    }




    public static void main(String[] args){
    }
}
