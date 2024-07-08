package javaTester.javaBasic;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_03_Excecise {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Your name: ");
        String name = scanner.nextLine();

        System.out.print("Your age: ");
        int age = scanner.nextInt();

        int futureAge = age + 15;

        System.out.println("After 15 years, age of " + name + " will be " + futureAge);

        scanner.close();
    }

    @Test
    public void swapNumber(){
        int a = 5;
        int b = 6;

        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a);
        System.out.println(b);
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//            // Nhập số thứ nhất
//            System.out.print("a: ");
//            int firstNumber = scanner.nextInt();
//
//            // Nhập số thứ hai
//            System.out.print("b: ");
//            int secondNumber = scanner.nextInt();
//
//            // So sánh hai số và in kết quả
//            if (firstNumber > secondNumber) {
//                System.out.println("True");
//            } else {
//                System.out.println("False");
//            }
//
//            scanner.close();
//    }
}
