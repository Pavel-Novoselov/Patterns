package singlton;

public final class DBConnection {
    private String conn;
    private static DBConnection instance;

    private DBConnection(final String conn) {
        this.conn = conn;
    }

    public static DBConnection getInstance(final String conn){
        if (instance == null){
            instance = new DBConnection(conn);
        }
       return instance;
    }

    public String getConn() {
        return conn;
    }

    public void setConn(final String conn) {
        this.conn = conn;
    }
}
