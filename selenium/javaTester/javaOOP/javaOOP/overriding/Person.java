package javaTester.javaOOP.javaOOP.overriding;

public abstract class Person {

    public void eat() {
        System.out.println("Suat com 20.000 VND");
    }

    public abstract void sleep();

    // Không được phép overriding
    public final void walk() {
        System.out.println("Di bo");
    }

    public static void run() {
        System.out.println("Chay bo");
    }

    private void dating() {
        System.out.println("Dating");
    }
}
