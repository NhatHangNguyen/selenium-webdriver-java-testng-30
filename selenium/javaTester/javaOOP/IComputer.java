package javaTester.javaOOP;

public interface IComputer {

    // Nếu không gán từ khoá là abstract cho hàm thì tự hiểu đây vẫn là 1 hàm abstract
    public void showComputerPerfomance();

    // Abstract Method
    public abstract void showComputerRam();
}
