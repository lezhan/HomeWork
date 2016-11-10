package KOS.Lessons.oop.worker;

import java.sql.*;

public class JdbcJava {
    private static final String url = "jdbc:mysql://localhost:3306/dbbooks";
    private static final String user = "root";
    private static final String password = "root";
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Books");

            while (resultSet.next()){
                System.out.println(resultSet.getString(2));
            }
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {connection.close();} catch (SQLException e) {e.printStackTrace();}
            try {statement.close();} catch (SQLException e ) {e.printStackTrace();}
            try {resultSet.close();} catch (SQLException e ) {e.printStackTrace();}
        }
    }
}
