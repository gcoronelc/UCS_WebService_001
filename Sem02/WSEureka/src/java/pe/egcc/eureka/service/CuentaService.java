package pe.egcc.eureka.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.egcc.eureka.db.AccesoDB;

public class CuentaService {

  public double leerSaldo(String cuenta){
    Connection cn = null;
    double saldo = 0.0;
    try {
      String sql = "select dec_cuensaldo from cuenta "
              + "where chr_cuencodigo=?";
      cn = AccesoDB.getConnection();
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      ResultSet rs = pstm.executeQuery();
      if(rs.next()){
        saldo = rs.getDouble("dec_cuensaldo");
      }
      rs.close();
      pstm.close();
    } catch (Exception e) {
      e.printStackTrace();
      saldo = 0.0;
    } finally{
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return saldo;
  }
  
}
