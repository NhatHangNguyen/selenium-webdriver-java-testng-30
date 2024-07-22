package javaTester.javaOOP.javaOOP.overriding;

import javaTester.javaOOP.IWork;

public class Student extends Person implements IWork {
    @Override
    public void eat() {
        System.out.println("Suat com 15.000 VND");
    }

    @Override
    public void sleep(){
        System.out.println("Ngu 12 tieng/ ngay");
    }

    @Override
    public void workingTime(){
        System.out.println("Hoc 3 tieng/ ngay");
    }
}
