package KOS.Lessons.oop.worker;

import java.sql.*;

public class JdbcJavaPreparedStatement {
    private static final String url = "jdbc:mysql://localhost:3306/dbbooks";
    private static final String user = "root";
    private static final String password = "root";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static CallableStatement callableStatement;
    private static ResultSet resultSet;


    public static void main(String[] args) {
        try {
            // upload driver into memory and register it to hte Driver manager
            Class.forName(driver);

            //create connection
            connection = DriverManager.getConnection(url, user, password);

            //sql query to execute
            String sqlInsert = "insert into books values(0,?,?)";
            String sqlSelect = "select * from books";



            //preparing statement
            preparedStatement = connection.prepareStatement(sqlInsert);

            //binding values into the parameters
            preparedStatement.setString(1, "Head-First-Java-2nd-edition");
            preparedStatement.setString(2, "Owner");
            preparedStatement.executeUpdate();

            preparedStatement.setString(1, "Algoritms");
            preparedStatement.setString(2, "Kormen");
            preparedStatement.executeUpdate();

            //preparedStatement.setString(1, "TIJ 3 Edition");
            //preparedStatement.setString(2, "Eckell");

            //Executing queries
            int rows = preparedStatement.executeUpdate();
            System.out.println("Rows impacted " + rows);
            resultSet = preparedStatement.executeQuery(sqlSelect);

            //retrieving data
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1) + "   " + resultSet.getString(2) + "   "
                        + resultSet.getString(3) );
            }
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {connection.close();} catch (SQLException e) {e.printStackTrace();}
            try {preparedStatement.close();} catch (SQLException e ) {e.printStackTrace();}
            try {resultSet.close();} catch (SQLException e ) {e.printStackTrace();}
        }
    }
}
