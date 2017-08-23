
package pe.egcc.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gustavo Coronel
 */
public final class AccesoDB {
  
  private AccesoDB() {
  }

  public static Connection getConnection() throws SQLException {
    Connection cn = null;
    try {
      // Datos MySQL
      String driver = "com.mysql.jdbc.Driver";
      String url = "jdbc:mysql://localhost:3306/EUREKABANK";
      String user = "eureka";
      String pass = "admin";
      // Cargar el driver a memoria
      Class.forName(driver).newInstance();
      // Obtener el objeto Connection
      cn = DriverManager.getConnection(url, user, pass);
    } catch (SQLException e) {
      throw e;
    } catch(ClassNotFoundException e){
      throw new SQLException("ERROR, no se encuentra el driver.");
    } catch(Exception e){
      throw new SQLException("ERROR, no se tiene acceso al servidor.");
    }
    return cn;
  }
}
