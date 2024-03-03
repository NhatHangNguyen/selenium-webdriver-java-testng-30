package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Topic_08_Parameter {
    static String fullNameGlobal = "Automation Testing";
    public static void main(String[] args) {
        setFullName("Manual Testing");

        System.out.println(getFullName());

    }
    public static void setFullName(String fullName){
        fullNameGlobal = fullName;
    }

    public static String getFullName(){
        return fullNameGlobal;
    }
}
