package proxy;

public class Car implements InterfaceCar {
    String msg;
    @Override
    public String  drive() {
        msg = "Поехали!";
        return msg;
    }
}
