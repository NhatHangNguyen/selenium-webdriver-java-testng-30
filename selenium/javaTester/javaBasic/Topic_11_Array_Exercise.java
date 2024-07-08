package javaTester.javaBasic;

import org.testng.annotations.Test;

public class Topic_11_Array_Exercise {

    int number[] = {2, -3, 4, -5, 8, 10, 9, 11, 100, 105};

    @Test
    public void TC_01_Find_Max_Number(){
        int x = 0;
        for (int i = 0; i < number.length; i++) {
            if (x  < number[i]){
                x = number[i];
            }
        }
        System.out.println("Max number = " + x);
    }

    @Test
    public void TC_02_Sum_First_And_Last(){
        System.out.println(number[0] + number[number.length -1]);
    }

    @Test
    public void TC_03_Even_Number(){
        for (int i = 0; i < number.length; i++) {
            if (number[i] % 2 == 0) {
                System.out.println("Even number are: " + number[i]);
            }
        }
    }

    @Test
    public void TC_04_Sum_Odd_Number(){
        int sum = 0;
        for (int i = 0; i < number.length; i++) {
            if (number[i] > 0 && number[i] % 2 != 0) {
                sum += number[i];
            }
        }
        System.out.println("Sum of odd number: " + sum);
    }

    @Test
    public void TC_05_Numbers(){
        for (int i = 0; i < number.length; i++) {
            if (number[i] >= 0 && number[i] <= 10){
                System.out.println("Number in (0<=number<=10) = " + number[i]);
            }
        }
    }

    @Test
    public void TC_06_Sum_And_Average(){
        int sum = 0;
        float average = 0;
        for (int i = 0; i < number.length; i++) {
            sum += number[i];
            average = sum/ number.length;
        }
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }

    @Test
    public void TC_07_Display_Info(){
        // đã làm bên Topic_11_Array_Extra
    }
}