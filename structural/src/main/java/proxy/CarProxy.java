package proxy;

public class CarProxy implements InterfaceCar {
    private final Car car = new Car();
    private final Driver driver;

    public CarProxy(final Driver driver) {
        this.driver = driver;
    }

    public String drive() {
        if (driver.getAge() >= 16){
            return car.drive();
        } else {
            return "Вам еще нет 16 лет!";
        }
    }
}
