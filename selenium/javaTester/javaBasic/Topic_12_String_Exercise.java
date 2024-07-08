package javaTester.javaBasic;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collections;

public class Topic_12_String_Exercise {
    String courseName = "Automation Testing Advanced";
    String actionName = "Automation Testing 345 Tutorials Online 789";

    String reverseName = "Automation FC";

    String numberPhone = "08925346248364";

    @Test
    public void TC_01() {
        char courseNaemArr[] = courseName.toCharArray();
        int countUpper = 0;
        int countLower = 0;
        int countNumber = 0 ;
        for (char charater : courseNaemArr){
            if (charater <= 'Z' && charater >= 'A'){
                countUpper++;
            }

            if (charater <= 'z' && charater >= 'a'){
                countLower++;
            }

            if (charater <= '9' && charater >= '0'){
                countNumber++;
            }
        }
        System.out.println("Sum of uppercase = " + countUpper);
        System.out.println("Sum of lowercase = " + countLower);
        System.out.println("Sum of number = " + countNumber);
    }

    @Test
    public void TC_02_01() {
        char actionNameArr[] = actionName.toCharArray();
        int countA = 0;
        for (char c : actionNameArr) {
            if (c == 'a') {
                countA++;
            }
        }
        System.out.println("So luong ki tu a: " + countA);
    }

    @Test
    public void TC_02_02() {
        System.out.println("Chuoi co chua tu Testing: " + actionName.contains("Testing") );
    }

    @Test
    public void TC_02_03() {
        System.out.println("Chuoi co bat dau bang tu Automation = " + actionName.startsWith("Automation"));
    }

    @Test
    public void TC_02_04() {
        System.out.println("Chuoi co ket thuc bang tu Online = " + actionName.endsWith("Online"));
    }

    @Test
    public void TC_02_05(){
        System.out.println("Vị trí của từ Tutorials trong chuỗi = " + actionName.indexOf("Tutorials"));
    }

    @Test
    public void TC_02_06(){
        actionName = actionName.replace("Online", "Offline");
        System.out.println(actionName);
    }

    @Test
    public void TC_02_07(){
        char actionNameArr[] = actionName.toCharArray();
        int countNumber = 0;
        for (char c : actionNameArr) {
            if (c <= '9' && c >= '0'){
                countNumber++;
            }
        }
        System.out.println("So luong ki tu so: " + countNumber);
    }

    @Test
    public void TC_03() {
        char reverseNameArr[] = reverseName.toCharArray();

        for (int i = reverseNameArr.length - 1; i >= 0 ; i--) {
            System.out.println(reverseNameArr[i]);
        }
    }

    @Test
    public void TC_04(){
        if (numberPhone.startsWith("7") || numberPhone.startsWith("8") || numberPhone.startsWith("9")){
            System.out.println("So dien thoai dung dinh dang");
        } else {
            System.out.println("So dien thoai sai dinh dang");
        }
    }
}
