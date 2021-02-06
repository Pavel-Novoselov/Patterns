package singlton;
public class Main {
    public static void main(String[] args) {
        final DBConnection connection1 = DBConnection.getInstance("1 instance");
        final DBConnection connection2 = DBConnection.getInstance("2 instance");

        System.out.println("1: " + connection1.getConn());
        System.out.println("2: " + connection2.getConn());
    }
}
