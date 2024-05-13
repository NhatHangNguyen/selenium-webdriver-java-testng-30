package javaTester;

import java.util.Date;

public class Topic_11_Constructor {
    // Là 1 hàm cũng tên với class
    // Không có kiểu dữ liệu trả về
    // Trong 1 class có thể có nhiều constructor
    // 1 class nnếu không define cái constructor cụ thể thì nó sẽ có 1 constructor rỗng (default)
    // Nếu mình define thì khi khởi tạo nó bắt buộc phải gọi tới constructor mà mình define

    public Topic_11_Constructor(String name) {
        System.out.println(name);
    }

    public Topic_11_Constructor(int numberStudent) {
        System.out.println(numberStudent);
    }

    public Topic_11_Constructor(String mane, int numberStudent) {
        System.out.println(numberStudent);
    }

    public static void main(String[] args) {
        Topic_11_Constructor topic01 = new Topic_11_Constructor("Automation FC");
        Topic_11_Constructor topic02 = new Topic_11_Constructor(15);
        Topic_11_Constructor topic03 = new Topic_11_Constructor("Automation FC",15);
    }
}
