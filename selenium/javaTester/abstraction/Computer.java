package javaTester.abstraction;


import org.bouncycastle.cms.PasswordRecipient;

public abstract class Computer {

    // Non abstract (Normal)
    public void showCPU(){
        System.out.println("Intel CPU");
    }

    // Abstract
    public abstract void setRam();

    private void showGPU(){

    }

    void showHDD(){

    }
}
