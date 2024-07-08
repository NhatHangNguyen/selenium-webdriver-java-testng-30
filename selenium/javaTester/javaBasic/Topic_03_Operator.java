package javaTester.javaBasic;

import org.testng.Assert;

public class Topic_03_Operator {
    public static void main(String[] args) {
        int number = 10;

        System.out.println(number++);
        // In number ra trước: 10
        // ++ = tăng number lên 1 = 11

        System.out.println(number--);
        // ++ trước: tăng number lên 1 = 12
        // In number ra: 12

        number += 5; // number = number + 5
        System.out.println(number);

        // 15/5 = 3 -> lấy phần nguyên
        System.out.println(number / 5);

        // 15%1 = 2 dư 1 -> lấy phần dư
        System.out.println(number % 7);

        for (int i = 0; i <= 3; i++){
            System.out.println(i);
        }

        for (int i = 0; i <= 3; ++i){
            System.out.println(i);
        }

        Assert.assertTrue(5<6);

        String address = "Ho Chi Minh";
        if (address != "Ha Noi" && address != "Da Nang"){
            System.out.println("Address is the same");
        }

        // Tam nguyên = ? :
        boolean status = (address == "Ha Noi") ? true : false;
        System.out.println(status);
    }
}
