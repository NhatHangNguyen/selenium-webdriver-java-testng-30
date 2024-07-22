package javaTester.abstraction;

public class Dog implements IAnimal, ICity {

    // Không mang ra để sử dụng được luôn
    // Phải viết lại mới dùng được
    // Khác knowledge của kế thừa (extands)
    @Override
    public String getName() {
        return "";
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getAddress() {
        return "";
    }

    @Override
    public void setAddress(String address) {

    }
}
