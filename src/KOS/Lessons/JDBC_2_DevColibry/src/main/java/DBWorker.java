import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBWorker {
    private final String HOST = "jdbc:mysql://localhost:3306/mydbtest";
    private final String USERNAME = "root";
    private final String PASWORD = "root";

    public Connection getConnection() {
        return connection;
    }

    private Connection connection;

    public DBWorker(){
        try {
            connection = DriverManager.getConnection(HOST, USERNAME, PASWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
