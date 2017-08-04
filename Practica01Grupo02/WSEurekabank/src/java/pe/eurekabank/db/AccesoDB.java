/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eurekabank.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author CSarmiento
 */
public final class AccesoDB {

    public AccesoDB() {
    }
    
    public static Connection getConnection() throws SQLException {
        
        Connection connection = null;
        
        try {
        
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/eurekabank";
            String user = "root";
            String pass = "root";
      
            Class.forName(driver).newInstance();
            
            connection = DriverManager.getConnection(url, user, pass);
            
        } catch(Exception e) {
            throw new SQLException(e.getMessage());
        }
        
        return connection;
        
    }
    
}
