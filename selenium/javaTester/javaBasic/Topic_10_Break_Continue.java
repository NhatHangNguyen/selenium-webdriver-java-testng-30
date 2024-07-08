package javaTester.javaBasic;

import javax.swing.*;
import java.util.Scanner;

public class Topic_10_Break_Continue {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i == 5){
                continue;
            }
            System.out.println(i);
        }

        // Nested for
        for (int i = 1; i <= 5 ; i++) {
            System.out.println("Lần chạy của i (for trên) = " + i);

            // Mỗi 1 lần chạy của for trên sé apply cho tất  lần chạy của for dưới này
            for (int j = 0; j <= 5; j++) {
                if (j == 4) {
                    continue;
                }
                System.out.println("Lần chạy của j (for thứ 2) = " + j);

                for (int x = 0; x <= 5; x++) {
                    if (x == 4) {
                        continue;
                    }
                    System.out.println("x = " + x);
                }
            }
        }

        while (true) { // Infinite loop to demonstrate the use of continue
            System.out.print("Enter your browser name: ");
            String browserName = scanner.nextLine();
            if (browserName.equals("IE")) {
                System.out.println("Internet Explorer is not supported. Please enter a different browser.");
                continue; // Skip the rest of the loop and prompt the user again
            }
            System.out.println("You entered: " + browserName);
            break; // Exit the loop
        }

            System.out.println("Enter the month: ");
            int month = scanner.nextInt();
            switch (month){
                case 1:
                    System.out.println("JAN");
                    break;
                case 2:
                    System.out.println("FEB");
                    break;
                case 3:
                    System.out.println("MAR");
                    break;
                case 4:
                    System.out.println("APR");
                    break;
                case 5:
                    System.out.println("MAY");
                    break;
                case 6:
                    System.out.println("JUN");
                    break;
                case 7:
                    System.out.println("JUL");
                    break;
                case 8:
                    System.out.println("AUG");
                    break;
                case 9:
                    System.out.println("SEPT");
                    break;
                case 10:
                    System.out.println("OCT");
                    break;
                case 11:
                    System.out.println("NOV");
                    break;
                case 12:
                    System.out.println("DEC");
                    break;
            }
    }
}