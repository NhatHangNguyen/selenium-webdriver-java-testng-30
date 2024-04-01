package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_09_Driver_Info {
    WebDriver driver;

    @Test
    public void testDriverInformation(){
        driver = new FirefoxDriver();
        // Ở trên OS nào
        // Browser nào
        // ID của driver là gì
        // FirefoxDriver: firefox on mac (f5c087e5-a43f-4993-95e2-3ebd5cb9b4b1)

        System.out.println(driver.toString());

        driver.quit();

    }
}
