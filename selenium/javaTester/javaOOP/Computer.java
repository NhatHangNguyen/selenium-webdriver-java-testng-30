package javaTester.javaOOP;

public abstract class Computer {

    // Normal method
    public void showComputerPerfomance(){
        System.out.println("Show Computer Perfomance");
    }

    // Abstract Method
    // Khung để cho các Class con kế thừa nó phải override lại (implement) lại
    public abstract void showComputerRam();
}
