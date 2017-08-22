package pe.egcc.rest.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.egcc.rest.db.AccesoDB;
import pe.egcc.rest.model.Cuenta;
import pe.egcc.rest.model.Movimiento;

/**
 *
 * @author CSarmiento
 */
public class CuentaService {

  public List<Movimiento> leerMovimientos(String numeroCuenta) {

    Connection cn = null;

    List<Movimiento> lista = new ArrayList<Movimiento>();
    String sql = "SELECT A.chr_cuencodigo, A.int_movinumero, A.dtt_movifecha, "
            + "B.vch_tipodescripcion, B.vch_tipoaccion, A.dec_moviimporte "
            + "FROM movimiento A INNER JOIN tipomovimiento B "
            + "ON B.chr_tipocodigo = A.chr_tipocodigo "
            + "WHERE A.chr_cuencodigo = ?";

    try {

      cn = AccesoDB.getConnection();
      PreparedStatement preparedStatement = cn.prepareStatement(sql);
      preparedStatement.setString(1, numeroCuenta);
      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {

        Movimiento cuenta = new Movimiento();
        cuenta.setCodigo(rs.getNString(1));
        cuenta.setNumeroMovimiento(rs.getInt(2));
        cuenta.setFecha(rs.getDate(3));
        cuenta.setTipo(rs.getString(4));
        cuenta.setAccion(rs.getString(5));
        cuenta.setImporte(rs.getDouble(6));

        lista.add(cuenta);
      }

      rs.close();

    } catch (SQLException e) {

      throw new RuntimeException(e.getMessage());

    } finally {

      try {
        cn.close();
      } catch (Exception e) {
      }

    }

    return lista;

  }

  public void procRetiro(String cuenta,
          double importe, String clave,
          String codEmp) {
    Connection cn = null;
    try {
      // Conexión
      cn = AccesoDB.getConnection();
      // Iniciar Tx
      cn.setAutoCommit(false);
      // Leer datos de la cuenta
      String sql = "select DEC_CUENSALDO, INT_CUENCONTMOV "
              + "from cuenta where CHR_CUENCODIGO = ? "
              + "for update ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      ResultSet rs = pstm.executeQuery();
      if (!rs.next()) {
        throw new Exception("Cuenta no exist.");
      }
      double saldo = rs.getDouble("DEC_CUENSALDO");
      int cont = rs.getInt("INT_CUENCONTMOV");
      rs.close();
      pstm.close();
      // Verificar saldo
      saldo -= importe;
      if (saldo < 0) {
        throw new Exception("Saldo no es suficiente.");
      }
      // Actualizar tabla CUENTA
      cont++;
      sql = "update cuenta set DEC_CUENSALDO = ?,"
              + "INT_CUENCONTMOV = ? "
              + "where CHR_CUENCODIGO = ?";
      pstm = cn.prepareStatement(sql);
      pstm.setDouble(1, saldo);
      pstm.setInt(2, cont);
      pstm.setString(3, cuenta);
      int filas = pstm.executeUpdate();
      if (filas == 0) {
        throw new Exception("Cuenta no es correcta.");
      }

      pstm.close();
      // Registrar movimiento
      sql = "insert into movimiento(CHR_CUENCODIGO,"
              + "INT_MOVINUMERO,DTT_MOVIFECHA,"
              + "CHR_EMPLCODIGO,CHR_TIPOCODIGO,"
              + "DEC_MOVIIMPORTE) "
              + "values(?, ?, SYSDATE(), ?, '004', ?)";
      pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      pstm.setInt(2, cont);
      pstm.setString(3, codEmp);
      pstm.setDouble(4, importe);
      pstm.executeUpdate();
      pstm.close();
      // Fin de Tx
      cn.commit();
    } catch (Exception e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      String texto = "Error en el proceso. "
              + e.getMessage();
      throw new RuntimeException(texto);
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }
  
  public List<Cuenta> leerCuentas(String sucucodigo) {
    
    List<Cuenta> lista = new ArrayList<Cuenta>();
    
    String sql = "SELECT sucucodigo, sucunombre, cliecodigo, cliepaterno, "
            + "cliematerno, clienombre, cuencodigo, cuensaldo, cuenestado, "
            + "monecodigo, monenombre FROM v_cuenta ";
    
    Connection cn = null;

    try {

      cn = AccesoDB.getConnection();
      PreparedStatement pstm;
      
      if( sucucodigo != null && !sucucodigo.isEmpty() ) {
        sql += " WHERE sucucodigo = ?";
        pstm = cn.prepareStatement(sql);
        pstm.setString(1, sucucodigo);
      } else {
        pstm = cn.prepareStatement(sql);
      }
      
      ResultSet rs = pstm.executeQuery();

      while (rs.next()) {

        Cuenta cuenta = new Cuenta();
        cuenta.setSucucodigo(rs.getString("sucucodigo"));
        cuenta.setSucunombre(rs.getString("sucunombre"));
        cuenta.setCliecodigo(rs.getString("cliecodigo"));
        cuenta.setCliepaterno(rs.getString("cliepaterno"));
        cuenta.setCliematerno(rs.getString("cliematerno"));
        cuenta.setClienombre(rs.getString("clienombre"));
        cuenta.setCuencodigo(rs.getString("cuencodigo"));
        cuenta.setCuensaldo(rs.getDouble("cuensaldo"));
        cuenta.setCuenestado(rs.getString("cuenestado"));
        cuenta.setMonecodigo(rs.getString("monecodigo"));
        cuenta.setMonenombre(rs.getString("monenombre"));
        lista.add(cuenta);
        
      }

      rs.close();

    } catch (SQLException e) {

      throw new RuntimeException(e.getMessage());

    } finally {

      try {
        cn.close();
      } catch (Exception e) {
      }

    }

    return lista;
  }
  
}
