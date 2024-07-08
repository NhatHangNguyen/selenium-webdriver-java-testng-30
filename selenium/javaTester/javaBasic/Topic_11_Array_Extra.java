package javaTester.javaBasic;

public class Topic_11_Array_Extra {
    // Thuộc tính/ Biến
    int id;
    String name;
    int age;
    float score;

    // Constructor: hàm khởi tạo
    public Topic_11_Array_Extra(int id, String name, int age, float score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Score: " + score);
    }

    public static void main(String[] angs) {
        Topic_11_Array_Extra[] students = new Topic_11_Array_Extra[3];

        students[0] = new Topic_11_Array_Extra(2952, "Tuan", 25, 8.8f);
        students[1] = new Topic_11_Array_Extra(3456, "John", 24, 8.0f);
        students[2] = new Topic_11_Array_Extra(3295, "Van", 18, 7.9f);

        for (int i = 0; i < students.length; i++) {
            students[i].display();
        }
    }
}