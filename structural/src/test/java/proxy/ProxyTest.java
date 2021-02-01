package proxy;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ProxyTest {
    private InterfaceCar car1;
    private InterfaceCar car2;

    @Test
    public void testP(){
        car1 = new CarProxy(new Driver(16));
        car2 = new CarProxy(new Driver(15));
        Assertions.assertEquals(car1.drive(), "Поехали!");
        Assertions.assertEquals(car2.drive(),"Вам еще нет 16 лет!");
    }

}
