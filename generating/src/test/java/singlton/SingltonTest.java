package singlton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingltonTest {
    DBConnection dbConnection;

    @Test
    public void testS(){
        dbConnection = DBConnection.getInstance("1 instance");
        Assertions.assertEquals(dbConnection.getConn(), "1 instance");
        dbConnection = DBConnection.getInstance("2 instance");
        Assertions.assertEquals(dbConnection.getConn(), "1 instance");
    }
}
