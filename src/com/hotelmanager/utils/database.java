  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelmanager.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author dthl2
 */
public class database {
    public static Connection openConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost;database=test;";
        String username = "sa";
        String password = "123";
        Connection con = DriverManager.getConnection(connectionUrl, username, password);
        return con;
    }
}
