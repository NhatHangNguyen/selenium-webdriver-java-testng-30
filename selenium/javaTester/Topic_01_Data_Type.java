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

public class Topic_01_Data_Type {
    // Kiểu dữ liệu trong Java - 2 nhóm

    // I -Kiểu dữ liệu nguyên thuỷ (Primitive Type)
    // Số nguyên: byte - short - int - long: không có phần thập phân
    byte bNumber = 40;
    short sNumber = 3000;
    int iNumber = 15635658;
    long lNumber = 243534000;

    // Số thực: float - double: có phần thập phân
    float fNumber = 9.999f;
    double dNumber = 35.800789d;

    // Kí tự: char: đại diện cho 1 kí tự
    char c = 'H';
    char d = 'a';

    // Logic: boolean (luận lí)
    boolean status = true;


    // II - Kiểu dữ liệu tham chiếu (Reference Type)
    // Class
    FirefoxDriver firefoxDriver = new FirefoxDriver();
    Select select = new Select(firefoxDriver.findElement(By.className("")));

    Topic_01_Data_Type topic01 = new Topic_01_Data_Type();

    By by;

    // Interface
    JavascriptExecutor javascriptExecutor;
    WebDriver driver;

    // Object
    Object name = "Automation Fc";

    // Array (kiểu nguyên thuỷ/ tham  chiếu)
    int[] studentAge = {15, 20, 8};
    String[] studentName = {"Automation", "Testing"};

    // Collection: List/ Set/ Queue
    List<String> studentAddress = new ArrayList<String>();
    List<String> studentCity = new LinkedList<>();
    List<String> studentPhone = new Vector<>() ;


    // String - Chuỗi kí tự
    String name1 = "Hang";

    // Khai báo 1 biến để lưu trữ 1 loại dữ liệu nào đó
    // Access Modifier: Phạm vi truy cập (public/ private/ protected/ default)
    // Kiểu dữ liệu
    // Tên biến
    // Giá trị của biến - gán vào với phép bằng

    public int studentName1 = 200;
}
