package javaTester;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;

import java.io.File;

public class Topic_03_System_Info {
    public static void main(String[] args) {

        String osName = System.getProperty("os.name");
        Keys keys;

        if (osName.startsWith("Windows")){
            keys = Keys.CONTROL;
        } else {
            keys = Keys.COMMAND;
        }

        Keys cmdCtrl = Platform.getCurrent().is(Platform.WINDOWS) ? Keys.CONTROL : Keys.COMMAND;

        // Lấy ra đường dẫn tương đối tại thư mục hiện tại
        String projectPath = System.getProperty("user.dir");

        //String character = Platform.getCurrent().is(Platform.WINDOWS) ? "\\" : "/"; //Cách 1
        String character = File.separator; //Cách 2

        String dnName = "DaNang.jpg";
        String hnName = "HaNoi.jpg";
        String hcmName = "HoChiMinh.jpg";

        String dnFilePath = projectPath + character + "uploadFiles" + character + dnName;
        String hnFilePath = projectPath + character + "uploadFiles" + character + hnName;
        String hcmFilePath = projectPath + character + "uploadFiles" + character + hcmName;

        System.out.println(dnFilePath);
        System.out.println(hnFilePath);
        System.out.println(hcmFilePath);
    }
}
