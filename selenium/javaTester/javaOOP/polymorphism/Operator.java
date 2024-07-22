package javaTester.javaOOP.polymorphism;

public class Operator {

    public void sum(int a, int b) {
        System.out.println(a + b);
    }

    public void sum(double a, double b) {
        System.out.println(a + b);
    }

    public void sum(float a, float b) {
        System.out.println(a + b);
    }

    public void sum(long a, long b) {
        System.out.println(a + b);
    }

    public static void main(String[] args) {
        Operator opr = new Operator();

        opr.sum(5 ,8);
        opr.sum(5000l, 5000l);
        opr.sum(5.15d, 97.7d);
        opr.sum(6.5f,5f);
    }
}
