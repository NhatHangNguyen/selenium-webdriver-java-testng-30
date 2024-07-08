package javaTester.javaBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Topic_11_Array {

    public static void main(String[] args) {

        int number[] = {12, 7, 5, 61, 15};

        int[] student = {12, 7, 5, 61, 15};

        // lấy ra phân tử đầu tiên
        System.out.println(student[0]);
        System.out.println(student[1]);
        System.out.println(student[6]);

        // Cố định
        // Được define cố định bao nhiêu phần tử khi mình viết code (compile)
        String studentName[] = {"Nam", "Long", "An"};
        studentName[0] = "Hoa";

        int b[] = new int[5];
        b[0] = 10;

        for (int i = 0; i < studentName.length; i++) {
            if (studentName[i].equals("Long")){
                System.out.println("Click on Long");
            }
        }

        // Không kết hợn vs điều kiện
        int i = 0;
        for (String std : studentName) {
            if (std.equals("Long")){
                System.out.println("Click vao Long");
            }
            i++;
        }

        ArrayList<String> stdName = new ArrayList<String>();

        // Động
        // Khi chạy code mới add (Runtime)
        for (String std : studentName){
            stdName.add(std);
        }

        List<String> names = Arrays.asList("Tom", "Jerry" , "Donal");
        for (String name : names){
            System.out.println("Name " + name);
        }

        String std_Name = Arrays.toString(studentName);
        System.out.println(std_Name);
    }
}
