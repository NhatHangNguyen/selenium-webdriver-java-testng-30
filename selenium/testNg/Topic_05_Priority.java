package testNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_05_Priority {

    @BeforeClass
    public void init(){
        System.out.println("Pre-condition for below testcase");
    }

    @Test
    public void Priority_01_SearchWithDate(){
    }

    @Test
    public void Priority_02_SearchWithBilling(){
    }

    @Test
    public void Priority_03_SearchWithProduct(){
    }

    @AfterClass(alwaysRun = true)
    public void after(){
        System.out.println("Post-condition for above testcase");
    }
}
