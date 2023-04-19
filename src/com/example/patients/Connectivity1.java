package com.example.patients;
import java.sql.Connection;
import java.sql.DriverManager;

public  class Connectivity1{
    public static void main(String args[]){

        Connectivity1 obj=new Connectivity1();
        System.out.println(obj.get_connection());

    }
    public Connection get_connection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/victoria", "root", "");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }
}

