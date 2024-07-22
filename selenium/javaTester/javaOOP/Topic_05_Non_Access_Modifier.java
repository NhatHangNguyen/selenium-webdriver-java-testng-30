package javaTester.javaOOP;

public class Topic_05_Non_Access_Modifier {

    // Static: Variable/ Method
    // Dùng cho tất cả các instance/ object
    // Phạm  vi cho toàn bộ system sử dụng nó
    // Có thể override được
    static  String browserName = "Chrome";

    // Non Static: Variable/ Method
    String serverName = "Testing";

    // Hằng số
    final String colorCar = "Red";

    final static String REGISTER_BUTTON = "";

    public static void main(String[] args) {
        System.out.println(browserName);

        browserName = "Firefox";
        System.out.println(browserName);

        Topic_05_Non_Access_Modifier topic = new Topic_05_Non_Access_Modifier();
        System.out.println(topic.serverName);

        // Không được phép gán lại giá trị
        System.out.println(topic.colorCar);

        topic.clickToElement("Button");

        sendKeyToElement("Link");
    }

    // Non static
    public void clickToElement(String elementName){
        System.out.println(elementName);
    }

    // Static
    public static void sendKeyToElement(String elementName){
        System.out.println(elementName);
    }

    // Final
    public final void setCarName(){
    }
}
