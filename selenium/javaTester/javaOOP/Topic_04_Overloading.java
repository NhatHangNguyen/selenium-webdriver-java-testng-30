package javaTester.javaOOP;

import org.testng.Assert;

public class Topic_04_Overloading {

    static int plusMethod(int x, int y){
        return x + y;
    }

    static double plusMethod(double x, double y){
        return x + y;
    }

    public static void main(String[] args) {

        plusMethod(5, 10);
        plusMethod(5.5,10.5);
    }
}
