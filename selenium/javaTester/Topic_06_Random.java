package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class Topic_06_Random {
    // Java Builtin (Cung c§p san - lây ra sû dung)
    // Java Libraries (Do 1 cá nhân/ tô chúc ho tu viêt)

    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println(rand.nextInt());
        System.out.println(rand.nextInt(99999));

        System.out.println(rand.nextFloat());
        System.out.println(rand.nextDouble());
        System.out.println(rand.nextBoolean());
    }

}
