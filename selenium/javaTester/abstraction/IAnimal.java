package javaTester.abstraction;

public interface IAnimal {
    public int Number = 100;

    String getName();

    void setName(String name);

    public abstract String getAddress();

    public abstract void setAddress(String address);
}
