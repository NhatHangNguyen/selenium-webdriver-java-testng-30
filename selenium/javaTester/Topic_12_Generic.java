package javaTester;

import java.util.ArrayList;
import java.util.List;

public class Topic_12_Generic {

    public static void main(String[] args) {
        // List chỉ chứa kiểu dữ liệu String
        // E T V K L: the type of element in this list
        List<String> students = new ArrayList<String>();
        students.add("John");
        students.add("Mary");
        students.add("Peter");
        students.add("Nam");

        // non- Generic
        List addresses = new ArrayList<>();
        addresses.add("123 Main St."); // String
        addresses.add(15); // Integer
        addresses.add(true); // Boolean
        addresses.add(15.56); // Float


    }
}
