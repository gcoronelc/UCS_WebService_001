/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eurekabank.servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.eurekabank.entity.Movimiento;
import pe.eurekabank.db.AccesoDB;

/**
 *
 * @author CSarmiento
 */
public class CuentaService {

  public List<Movimiento> leerMovimientos(String numeroCuenta) throws SQLException {
    
      Connection connection = null;
    
      List<Movimiento> cuentas = new ArrayList<Movimiento>();
      String sql = "SELECT A.chr_cuencodigo, A.int_movinumero, A.dtt_movifecha, " +
"B.vch_tipodescripcion, B.vch_tipoaccion, A.dec_moviimporte " +
"FROM movimiento A INNER JOIN tipomovimiento B " +
"ON B.chr_tipocodigo = A.chr_tipocodigo " +
"WHERE A.chr_cuencodigo = ?";
      
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
            
            cuentas.add(cuenta);
        }
        
        resultSet.close();
        connection.close();
        
      } catch (SQLException e) {
          throw new SQLException(e.getMessage());
      }
      
    return cuentas;
    
  }
  
}
