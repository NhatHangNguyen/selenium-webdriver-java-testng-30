package javaTester.javaException;

public class TryCatchException {

    public static void main(String[] args) {
        int number = 10;
        number = number / 0;

        try {
            // Đúng: Chạy hết đoạn code trong try và khong qua catch
            // Sai: Gặp exception - nhảy qua catch
            number = number / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(number);

        String[] browserName = { "Chrome", "Firefox", "Safari"};

        try {
            browserName[0] = "Edge Chromium";
            browserName[3] = "IE";
        } catch (Exception e){
            e.printStackTrace();
        }

        for (String browser : browserName){
            System.out.println(browser);
        }

        try {
            int array[] = new int[10];
            array[10] = 30 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Khong the chia cho 0");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Index vuot ngoai do dai cua MANG");
        }
    }
}
