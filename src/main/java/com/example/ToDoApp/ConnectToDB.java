package com.example.ToDoApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToDB {

    private static final String name="root";
    private static final String pass="rohan";
    private static final String url="jdbc:mysql://localhost:3306/jsp";




    private static Connection conn;

    private static void establishConnectionWithMySQL(){

        try {



            Class.forName("com.mysql.cj.jdbc.Driver");

            conn= DriverManager.getConnection(url,name,pass);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Statement connectDB() throws SQLException {
        establishConnectionWithMySQL();
        Statement statement=conn.createStatement();
        return statement;
    }

    public static void disconnectDB() throws SQLException{
        conn.close();
    }
}
