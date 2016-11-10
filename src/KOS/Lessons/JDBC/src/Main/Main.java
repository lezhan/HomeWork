package Main;

import Connection.DBConnection;

public class Main {
    public static void main(String[] args) {
        DBConnection connection = new DBConnection("localhost", "", "", "test");
        connection.initProperties();
        connection.init();
    }
}
