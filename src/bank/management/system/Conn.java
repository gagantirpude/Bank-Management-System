package bank.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {

    //Connection used for connecting to the database
    Connection connection;
    // used for executing the query and Now our project fully connect with database
    Statement statement;


    public Conn() {
        //Connection used for connecting to the database
        String url = "jdbc:mysql://localhost:3306/bankmanagementsystem";
        String username = "root";
        String password = "";

        try {
            connection =  DriverManager.getConnection(url, username, password);
            statement = connection.createStatement(); // used for executing the query and Now our project fully connect with database
        }
        catch(Exception e) {
            e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        new Conn();
    }
}
