package javaTester.javaException;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ExceptionType {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        File file = new File("/Users/hangcnnguyen/Desktop/testing.txt");
        FileOutputStream fileOS = new FileOutputStream(file);

        Thread.sleep(5000);

        WebDriver driver = null;
        driver.get("https://docs.google.com/");
    }
}
