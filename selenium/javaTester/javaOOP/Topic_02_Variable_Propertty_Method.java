package javaTester.javaOOP;

public class Topic_02_Variable_Propertty_Method {
    static int studentNumber;
    static float studentPrice;
    static String studentCountry;
    static boolean studentStatus;

    // Acces Modifier
    // Data Type
    // Variable name
    // Variable value
    private String studentName = "Automation FC"; // Biến toàn cục (Global variable)

    // Static variable: dùng và gán lại được
    public static String studentAddress = "Ho Chi Minh";

    // Dùng trong phạm vi Class này (cho tất cả instance/ object dùng)
    private static String studentPhone = "0984754328534";

    // Final variable: không cho phép gán lại/ override lại
    final String country = "Viet Nam";

    // Static final variable: hằng số (constant)
    // Nó không được ghi đè
    // Có thể truy cập rộng rãi cho tất cả các instance/ thread
    static final float PI_NUMBER = 3.14234546F;

    // Access modifier: default
    int studentID = 100056;

    public static void main(String[] args) {
        // Local variable - biến cục bộ: hàm
        String studentName = "Automation FC";

        if(studentName.startsWith("Automation")){
            // Local variable - biến cục bộ: block code
            int number = 100;
        }

        studentAddress = "Da Nang";
        studentPhone = "0986535456";

        // Local variable: băt buộc khởi tạo mới được sử dụng
//        int studentNumber;
//        float studentPrice;
//        String studentCountry;
//        boolean studentStatus;

        System.out.println(studentNumber);
        System.out.println(studentCountry);
        System.out.println(studentStatus);
        System.out.println(studentPrice);
    }

    public Topic_02_Variable_Propertty_Method() {
        // Local variable - biến cục bộ: constructor
        String studentName = "Automation FC";
    }

    // Hàm (Method)
    public void display() {
        // Local variable - biến cục bộ: hàm/ block code/ constructor
        String studentName = "Automation FC";
    }
}
