package pe.egcc.rest.db;

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
      String user = "eureka";
      String pass = "admin";

      Class.forName(driver).newInstance();

      connection = DriverManager.getConnection(url, user, pass);

    } catch (Exception e) {
      throw new SQLException(e.getMessage());
    }

    return connection;

  }

}
