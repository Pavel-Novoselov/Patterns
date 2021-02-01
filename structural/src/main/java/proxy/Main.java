package proxy;

public class Main {
    public static void main(String[] args) {
        final InterfaceCar car = new CarProxy(new Driver(16));
        car.drive();
    }
}
