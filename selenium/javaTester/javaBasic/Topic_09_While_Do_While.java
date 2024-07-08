package javaTester.javaBasic;

import org.testng.annotations.Test;
import java.util.Scanner;

public class Topic_09_While_Do_While {
    static Scanner scanner = new Scanner(System.in);

//    public  static void main(String[] args) {
//        int i = 0;
//        for (i = 0; i < 5; i++){
//            System.out.println("For: " + i);
//        }
//
//        while  (i < 5){
//            System.out.println("While:" + i);
//            i++;
//        }
//
//        // Chạy ít nhất 1 lần ròi mới kiểm tra điều kiện
//        do {
//            System.out.println("Do-While: " + i);
//            i++;
//        } while (i < 5);
//    }

    public static void main(String[] args) {
        TC_08_While();
    }

    @Test
    public static void TC_01_For() {
        int number = scanner.nextInt();
        for (int i = number; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }

    @Test
    public static void TC_02_While() {
        int number = scanner.nextInt();
        while (number < 100){
            if (number % 2 == 0){
                System.out.println(number);
                number++;
            }
        }
    }

    @Test
    public static void TC_03_Do_While() {
        int number = scanner.nextInt();
        do {
            if (number % 2 == 0){
                System.out.println(number);
                number++;
            }
        } while (number < 100);
    }

    @Test
    public static void TC_04_While() {
        System.out.println("Enter number A:");
        int numberA = scanner.nextInt();
        System.out.println("Enter number B:");
        int numberB = scanner.nextInt();

        while (numberA < numberB){
            if (numberA % 3 == 0 && numberA % 5 == 0){
                System.out.println(numberA);
            }
            numberA++;
        }
    }

    @Test
    public static void TC_05_While() {
        System.out.println("Enter number:");
        int number = scanner.nextInt();
        int i = 0;

        while (number > 0){
            if (number % 2 != 0){
                System.out.println(number);
                i += number;
            }
            number--;
        }
        System.out.println(i);
    }

    @Test
    public static void TC_06_While() {
        System.out.println("Enter number A:");
        int numberA = scanner.nextInt();
        System.out.println("Enter number B:");
        int numberB = scanner.nextInt();

        while (numberA < numberB){
            if (numberA % 3 == 0){
                System.out.println(numberA);
            }
            numberA++;
        }
    }

    @Test
    public static void TC_07_While() {
        System.out.println("Enter number A:");
        int numberA = scanner.nextInt();
        int i = 1;

        while (numberA > 0){
            System.out.println(numberA);
            i *= numberA;
            numberA--;
        }
        System.out.println(i);
    }

    @Test
    public static void TC_08_While() {
        System.out.println("Enter number A:");
        int numberA = scanner.nextInt();
        System.out.println("Enter number B:");
        int numberB = scanner.nextInt();
        int i = 0;

        while (numberA <= numberB){
            if(numberA % 2 == 0){
                System.out.println(numberA);
                i += numberA;
            }
            numberA++;
        }
        System.out.println(i);
    }
}
