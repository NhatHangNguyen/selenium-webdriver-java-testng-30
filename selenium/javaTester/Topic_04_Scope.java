package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_04_Scope {
    // Các biến được khai báo ở bên ngoài hàm -> phạm vi là Class
    // Biến Global (toàn cục)
    // Có thể dùng cho tất cả các hàm ở  1 class đó
    WebDriver driver;
    String homePageUrl; // Khai báo: Declare
    String fullName = "Nguyen Chau Nhat Hang"; // Khai báo + khởi tạo (Initial)

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_() {
       // Biến khái báo trong 1 hàm / block code -> phạm vi cục bộ (local)
       // Dùng trong cái hàm nó được khai báo / block  được sinh ra
        String homePageUrl = "https://www.facebook.com/";

        // Trong 1 hàm nếu như có 2 biến cùng tên (Global/ Local) thì nó sẽ ưu tiên lấy biến local
        // 1 biến local nếu như gọi tới dùng mà chưa được khởi tạo thì sẽ bị lỗi
        // Biến Local chưa khởi tạo mà gọi ra dùng nó sẽ báo lỗi ngay (compile code)
        driver.get(homePageUrl);

        // Nếu trong 1 hàm có 2 biến cùng tên (Global/ Local) mà mún lấy biến Global ra để dùng
        // Dùng từ khoá this
        // Biến Local chưa khởi tạo mà gọi ra dùng nó sẽ không báo lỗi ở level compile code
        // Level runtime sẽ lỗi
        driver.get(this.homePageUrl);
    }
    @Test
    public void TC_02_() {
    }
    @Test
    public void TC_03_() {

    }
    @Test
    public void TC_04_() {

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
