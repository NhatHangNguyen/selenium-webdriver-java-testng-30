package javaTester.javaOOP.javaOOP.overriding;

import javaTester.javaOOP.IWork;

public class Employee extends Person implements IWork {
    @ Override
    public void eat() {
        System.out.println("Suat com 25.000 VND");
    }

    @Override
    public void sleep(){
        System.out.println("Ngu 7 tieng/ ngay");
    }

    @Override
    public void workingTime(){
        System.out.println("Lam viec 7 tieng/ ngay");
    }
}
