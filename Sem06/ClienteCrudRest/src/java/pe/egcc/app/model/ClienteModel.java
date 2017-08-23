package pe.egcc.app.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gustavo Coronel
 */
@XmlRootElement(name = "clientes")
public class ClienteModel {

  private String codigo;
  private String paterno;
  private String materno;
  private String nombre;
  private String dni;
  private String ciudad;
  private String direccion;
  private String telefono;
  private String email;

  public ClienteModel() {
  }

  /**
   * @return the codigo
   */
  public String getCodigo() {
    return codigo;
  }

  /**
   * @param codigo the codigo to set
   */
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  /**
   * @return the paterno
   */
  public String getPaterno() {
    return paterno;
  }

  /**
   * @param paterno the paterno to set
   */
  public void setPaterno(String paterno) {
    this.paterno = paterno;
  }

  /**
   * @return the materno
   */
  public String getMaterno() {
    return materno;
  }

  /**
   * @param materno the materno to set
   */
  public void setMaterno(String materno) {
    this.materno = materno;
  }

  /**
   * @return the nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * @param nombre the nombre to set
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * @return the dni
   */
  public String getDni() {
    return dni;
  }

  /**
   * @param dni the dni to set
   */
  public void setDni(String dni) {
    this.dni = dni;
  }

  /**
   * @return the ciudad
   */
  public String getCiudad() {
    return ciudad;
  }

  /**
   * @param ciudad the ciudad to set
   */
  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  /**
   * @return the direccion
   */
  public String getDireccion() {
    return direccion;
  }

  /**
   * @param direccion the direccion to set
   */
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  /**
   * @return the telefono
   */
  public String getTelefono() {
    return telefono;
  }

  /**
   * @param telefono the telefono to set
   */
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  @Override
  public String toString() {
    return codigo + " | " + paterno + " | " + materno;
  }
  
  

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  public void establecerVacios() {
    if (codigo == null) {
      codigo = "";
    }
    if (paterno == null) {
      paterno = "";
    }
    if (materno == null) {
      materno = "";
    }
    if (nombre == null) {
      nombre = "";
    }
    if (dni == null) {
      dni = "";
    }
    if (ciudad == null) {
      ciudad = "";
    }
    if (direccion == null) {
      direccion = "";
    }
    if (telefono == null) {
      telefono = "";
    }
    if (email == null) {
      email = "";
    }
  }

}
