package pe.egcc.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.egcc.app.db.AccesoDB;
import pe.egcc.app.domain.ClienteModel;

public class ClienteDao {

   public List<ClienteModel> getAll() {
      List<ClienteModel> lista = new ArrayList<>();
      Connection cn = null;
      try {
         cn = AccesoDB.getConnection();
         String sql = "select chr_cliecodigo, vch_cliepaterno, " 
               + "vch_cliematerno, vch_clienombre, chr_cliedni, "
               + "vch_clieciudad, vch_cliedireccion, " 
               + "vch_clietelefono, vch_clieemail " 
               + "from cliente";
         PreparedStatement pstm = cn.prepareStatement(sql);
         ResultSet rs = pstm.executeQuery();
         while (rs.next()) {
            ClienteModel bean = rowToBean(rs);
            lista.add(bean);
         }
         rs.close();
         pstm.close();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            cn.close();
         } catch (Exception e2) {
         }
      }
      return lista;
   }

   public List<ClienteModel> getClientes(ClienteModel model) {
      List<ClienteModel> lista = new ArrayList<>();
      Connection cn = null;
      try {
         cn = AccesoDB.getConnection();
         String sql = "select chr_cliecodigo, vch_cliepaterno, " 
               + "vch_cliematerno, vch_clienombre, chr_cliedni, "
               + "vch_clieciudad, vch_cliedireccion, " 
               + "vch_clietelefono, vch_clieemail " 
               + "from cliente "
               + "where vch_cliepaterno like ? " 
               + "and  vch_cliematerno like ? " 
               + "and vch_clienombre like ? ";
         PreparedStatement pstm = cn.prepareStatement(sql);
         pstm.setString(1, model.getPaterno() + "%");
         pstm.setString(2, model.getMaterno() + "%");
         pstm.setString(3, model.getNombre() + "%");
         ResultSet rs = pstm.executeQuery();
         while (rs.next()) {
            ClienteModel bean = rowToBean(rs);
            lista.add(bean);
         }
         rs.close();
         pstm.close();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            cn.close();
         } catch (Exception e2) {
         }
      }
      return lista;
   }

   public ClienteModel getCliente(String codigo) {
      ClienteModel clienteModel = null;
      Connection cn = null;
      try {
         cn = AccesoDB.getConnection();
         String sql = "select chr_cliecodigo, vch_cliepaterno, " 
               + "vch_cliematerno, vch_clienombre, chr_cliedni, "
               + "vch_clieciudad, vch_cliedireccion, " 
               + "vch_clietelefono, vch_clieemail " 
               + "from cliente "
               + "where chr_cliecodigo = ? ";
         PreparedStatement pstm = cn.prepareStatement(sql);
         pstm.setString(1, codigo);
         ResultSet rs = pstm.executeQuery();
         if (rs.next()) {
            clienteModel = rowToBean(rs);
         }
         rs.close();
         pstm.close();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            cn.close();
         } catch (Exception e2) {
         }
      }
      return clienteModel;
   }

   public void insertar(ClienteModel bean) {
      Connection cn = null;
      try {
         // Obtener la conexión
         cn = AccesoDB.getConnection();
         // Habilitar la transacción
         cn.setAutoCommit(false);
         // Paso 1: Leer datos del contador
         String sql = "select int_contitem, int_contlongitud " 
               + "from contador " 
               + "where vch_conttabla = 'Cliente' "
               + "for update ";
         PreparedStatement pstm = cn.prepareStatement(sql);
         ResultSet rs = pstm.executeQuery();
         if (!rs.next()) {
            throw new SQLException("ERROR: El contador de clientes no existe.");
         }
         int cont = rs.getInt("int_contitem");
         int size = rs.getInt("int_contlongitud");
         rs.close();
         pstm.close();
         // Actualizar contador
         cont++;
         sql = "update contador set int_contitem = ? " 
               + "where vch_conttabla = 'Cliente'";
         pstm = cn.prepareStatement(sql);
         pstm.setInt(1, cont);
         pstm.executeUpdate();
         // Generar Código
         String patron = "%0" + size + "d";
         String codigo = String.format(patron, cont);
         // Registrar al cliente
         sql = "insert into cliente(chr_cliecodigo, " 
               + "vch_cliepaterno, vch_cliematerno, "
               + "vch_clienombre, chr_cliedni, " 
               + "vch_clieciudad, vch_cliedireccion, "
               + "vch_clietelefono, vch_clieemail) " 
               + "values(?,?,?,?,?,?,?,?,?) ";
         pstm = cn.prepareStatement(sql);
         pstm.setString(1, codigo);
         pstm.setString(2, bean.getPaterno());
         pstm.setString(3, bean.getMaterno());
         pstm.setString(4, bean.getNombre());
         pstm.setString(5, bean.getDni());
         pstm.setString(6, bean.getCiudad());
         pstm.setString(7, bean.getDireccion());
         pstm.setString(8, bean.getTelefono());
         pstm.setString(9, bean.getEmail());
         pstm.executeUpdate();
         pstm.close();
         bean.setCodigo(codigo);
         // Confimar transacción
         cn.commit();
      } catch (SQLException e) {
         try {
            cn.rollback();
         } catch (Exception e1) {
         }
         throw new RuntimeException(e.getMessage());
      } catch (Exception e) {
         try {
            cn.rollback();
         } catch (Exception e1) {
         }
         throw new RuntimeException("Error en el proceso Registrar Deposito, intentelo mas tarde.");
      } finally {
         try {
            cn.close();
         } catch (Exception e) {
         }
      }
   }

   public void actualizar(ClienteModel model) {
      Connection cn = null;
      try {
         cn = AccesoDB.getConnection();
         cn.setAutoCommit(false); // Inicia la Tx
         String sql = "update cliente set  vch_cliepaterno = ?, " 
               + "vch_cliematerno = ?, vch_clienombre = ?, "
               + "chr_cliedni = ?, vch_clieciudad = ?, " 
               + "vch_cliedireccion = ?, vch_clietelefono = ?, "
               + "vch_clieemail = ? " 
               + "where chr_cliecodigo = ?";
         PreparedStatement pstm = cn.prepareStatement(sql);
         pstm.setString(1, model.getPaterno());
         pstm.setString(2, model.getMaterno());
         pstm.setString(3, model.getNombre());
         pstm.setString(4, model.getDni());
         pstm.setString(5, model.getCiudad());
         pstm.setString(6, model.getDireccion());
         pstm.setString(7, model.getTelefono());
         pstm.setString(8, model.getEmail());
         pstm.setString(9, model.getCodigo());
         int n = pstm.executeUpdate();
         if(n == 0){
           throw new SQLException("Código del cliente no existe.");
         }
         cn.commit(); // Confirma Tx
      } catch (SQLException e) {
         try {
            cn.rollback();
         } catch (Exception e1) {
         }
         throw new RuntimeException(e.getMessage());
      } catch (Exception e) {
         try {
            cn.rollback();
         } catch (Exception e1) {
         }
         throw new RuntimeException("Error en el proceso.");
      } finally {
         try {
            cn.close();
         } catch (Exception e) {
         }
      }
   }

   public void eliminar(String codigo) {
      Connection cn = null;
      try {
         cn = AccesoDB.getConnection();
         // Inicia la Tx
         cn.setAutoCommit(false); 
         // Verificar si tiene cuentas
         String sql = "select count(*) cont from cuenta where chr_cliecodigo = ?";
         PreparedStatement pstm = cn.prepareStatement(sql);
         pstm.setString(1, codigo);
         ResultSet rs = pstm.executeQuery();
         rs.next();
         int cont = rs.getInt("cont");
         rs.close();
         pstm.close();
         if(cont > 0){
            throw new SQLException("No se puede eliminar, tiene cuentas.");
         }
         // Eliminar fila
         sql = "delete from cliente where chr_cliecodigo = ?";
         pstm = cn.prepareStatement(sql);
         pstm.setString(1, codigo);
         int n = pstm.executeUpdate();
         pstm.close();
         if(n == 0){
           throw new SQLException("Código del cliente no existe.");
         }
         // Confirmar Tx
         cn.commit(); 
      } catch (SQLException e) {
         try {
            cn.rollback();
         } catch (Exception e1) {
         }
         throw new RuntimeException(e.getMessage());
      } catch (Exception e) {
         try {
            cn.rollback();
         } catch (Exception e1) {
         }
         throw new RuntimeException("Error en el proceso.");
      } finally {
         try {
            cn.close();
         } catch (Exception e) {
         }
      }
   }   

   private ClienteModel rowToBean(ResultSet rs) throws SQLException {
      ClienteModel bean = new ClienteModel();
      bean.setCodigo(rs.getString("chr_cliecodigo"));
      bean.setPaterno(rs.getString("vch_cliepaterno"));
      bean.setMaterno(rs.getString("vch_cliematerno"));
      bean.setNombre(rs.getString("vch_clienombre"));
      bean.setDni(rs.getString("chr_cliedni"));
      bean.setCiudad(rs.getString("vch_clieciudad"));
      bean.setDireccion(rs.getString("vch_cliedireccion"));
      bean.setTelefono(rs.getString("vch_clietelefono"));
      bean.setEmail(rs.getString("vch_clieemail"));
      return bean;
   }



}
