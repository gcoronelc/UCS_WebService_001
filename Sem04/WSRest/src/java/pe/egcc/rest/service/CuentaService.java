package pe.egcc.rest.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.egcc.rest.db.AccesoDB;
import pe.egcc.rest.model.Movimiento;

/**
 *
 * @author CSarmiento
 */
public class CuentaService {

  public List<Movimiento> leerMovimientos(String numeroCuenta) {

    Connection connection = null;

    List<Movimiento> lista = new ArrayList<Movimiento>();
    String sql = "SELECT A.chr_cuencodigo, A.int_movinumero, A.dtt_movifecha, "
            + "B.vch_tipodescripcion, B.vch_tipoaccion, A.dec_moviimporte "
            + "FROM movimiento A INNER JOIN tipomovimiento B "
            + "ON B.chr_tipocodigo = A.chr_tipocodigo "
            + "WHERE A.chr_cuencodigo = ?";

    try {

      connection = AccesoDB.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, numeroCuenta);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {

        Movimiento cuenta = new Movimiento();
        cuenta.setCodigo(resultSet.getNString(1));
        cuenta.setNumeroMovimiento(resultSet.getInt(2));
        cuenta.setFecha(resultSet.getDate(3));
        cuenta.setTipo(resultSet.getString(4));
        cuenta.setAccion(resultSet.getString(5));
        cuenta.setImporte(resultSet.getDouble(6));

        lista.add(cuenta);
      }

      resultSet.close();

    } catch (SQLException e) {
      
      throw new RuntimeException(e.getMessage());
      
    } finally{
      
      try {
        connection.close();
      } catch (Exception e) {
      }
      
    }

    return lista;

  }

}
