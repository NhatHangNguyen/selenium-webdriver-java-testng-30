package javaTester.javaOOP.polymorphism;

import javaTester.javaOOP.inheritance.Annimal;

public class Bird extends Annimal {

    @Override
    public void eat(){
        System.out.println("The Bird eating....");
    }
}
