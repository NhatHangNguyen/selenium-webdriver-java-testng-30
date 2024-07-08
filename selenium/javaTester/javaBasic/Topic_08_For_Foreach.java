package javaTester.javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Topic_08_For_Foreach {
    WebDriver driver;

    @Test
    public void TC_01_For_Iterate() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
        System.out.println("===========================");

        // Vế 1: biến tạm dùng để tăng giá trị lên sau mỗi lần duyệt
        // Dùng để so sánh với tổng giá trị
        // Vế 2: So sánh với tổng
        // Vế 3: Tăng i lên 1 đơn vị sau ki chạy vào thân vòng for

        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        // Array
        String[] cityName = {"Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho", "Hai Phong", "Khanh Hoa"};

        // For kết hợp với if: Thảo mãn điều kiện mới action
        // Biến đếm - dùng để điều kiện để filter
        for (int i = 0; i < cityName.length; i++) {
            if (cityName[i].equals("Da Nang")) {
                System.out.println("Do Action!");
                break;
            }
        }

        // Tất cả các giá trị đều được chạy qua dù đã thoả mãn điều kiện rồi
        for (int i = 0; i < cityName.length; i++) {
            if (cityName[i].equals("Da Nang")) {
                System.out.println("Do Action!");
            }
        }

        // Dùng chạy qua hết các giá trị
        for (String city : cityName) {
        }

        for(int i = 10; i > 0; i--){
            System.out.println(i);
        }
    }

    @Test
    public void TC_02_ForEach() {
        String[] cityName = {"Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho", "Hai Phong", "Khanh Hoa"};

        // Java Collection
        // Class: ArrayList/ LinkedList/ Vector/..
        // Interface: List/ Set/ Queue
        List<String> cityAddress = new ArrayList<String>();
        System.out.println(cityAddress.size());

        // Compile (Coding)
        cityAddress.add("'Bac Giang");
        cityAddress.add("Ha Giang");
        cityAddress.add("Sa Pa");

        System.out.println(cityAddress.size());

        // Runtime (Running)
        for (String city : cityName) {
            cityAddress.add(city);
        }
        System.out.println(cityAddress.size());

        for (String cityAdd : cityAddress) {
            System.out.println(cityAdd);
        }

        // Java Generic
        List<WebElement> links = driver.findElements(By.xpath("//a"));

        // Xử lí dữ liệu/ get text/ value/ css/ attribute
        for (WebElement link : links) {
            // Chuyển page
            // Refresh DOM/ HTML
            // Ko còn tồn tại
            // Fail -> StaleElement
        }
    }
}


