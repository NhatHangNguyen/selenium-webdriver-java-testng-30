package javaTester.javaBasic;

import org.testng.annotations.Test;
import java.util.Scanner;

public class Topic_06_Condition_Excecise {
    Scanner scanner = new Scanner(System.in);

    @Test
    public void TC_01() {
        int number = scanner.nextInt();

        if (number % 2 == 0) {
            System.out.println(number + " is an even number");
        } else {
            System.out.println(number + " is an odd number");
        }
    }

    @Test
    public void TC_02() {
        int numberA = scanner.nextInt();
        int numberB = scanner.nextInt();

        if (numberA >= numberB) {
            System.out.println(numberA + " lon hon hoac bang " + numberB);
        } else {
            System.out.println(numberA + " nho hon " + numberB);
        }
    }

    @Test
    public void TC_03() {
        String firstStudent = scanner.nextLine();
        String secondStudentB = scanner.nextLine();

        if (firstStudent.equals(secondStudentB)) {
            System.out.println("Hai sinh vien giong ten nhau");
        } else {
            System.out.println("Hai sinh vien khac ten nhau");
        }

        if (firstStudent == secondStudentB) {
            System.out.println("Hai sinh vien giong ten nhau");
        } else {
            System.out.println("Hai sinh vien khac ten nhau");
        }
    }

    @Test
    public void TC_04() {
        int nummberA = scanner.nextInt();
        int nummberB = scanner.nextInt();
        int nummberC = scanner.nextInt();

        if (nummberA > nummberB && nummberA > nummberC) {
            System.out.println(nummberA + " la so lon nhat");
        } else if (nummberB > nummberC){
            System.out.println(nummberB + " la so lon nhat");
        } else {
            System.out.println(nummberC + " la so lon nhat");
        }
    }

    @Test
    public void TC_05() {
        int nummberA = scanner.nextInt();

        if (10 < nummberA && nummberA < 100 ) {
            System.out.println(nummberA + " nam trong khoang (10-100)");
        } else {
            System.out.println(nummberA + " nam ngoai khoang (10-100)");
        }
    }

    @Test
    public void TC_06() {
        float studentPoint = scanner.nextFloat();

        if (studentPoint <= 10 && studentPoint >= 8.5) {
            System.out.println("He so A");
        } else if (studentPoint < 8.5 && studentPoint >= 7.5) {
            System.out.println("He so B");
        } else if (studentPoint < 7.5 && studentPoint >= 5) {
            System.out.println("He so C");
        } else if (studentPoint < 5 && studentPoint >= 0){
            System.out.println("He so D");
        } else {
            System.out.println("Ban vui long nhap lai diem");
        }
    }

    @Test
    public void TC_07() {
        int month = scanner.nextInt();

        if (month == 1 | month == 3 | month == 5 | month == 7 | month == 8| month == 10 | month == 12 ) {
            System.out.println("Thang nay co 31 ngay");
        } else if (month == 2) {
            System.out.println("Thang nay co 28 ngay");
        } else if (month == 4 | month == 6 | month == 9 | month == 11) {
            System.out.println("Thang nay co 30 ngay");
        } else {
            System.out.println("He so D");
        }
    }
}

