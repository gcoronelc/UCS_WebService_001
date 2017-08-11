package pe.egcc.rest.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CSarmiento
 */
@XmlRootElement(name = "movimiento")
public class Movimiento {

  private String codigo;
  private int numeroMovimiento;
  private Date fecha;
  private String tipo;
  private String accion;
  private double importe;

  public Movimiento() {
  }

  public Movimiento(String codigo, int numeroMovimiento, Date fecha, String tipo, String accion, double importe) {
    this.codigo = codigo;
    this.numeroMovimiento = numeroMovimiento;
    this.fecha = fecha;
    this.tipo = tipo;
    this.accion = accion;
    this.importe = importe;
  }

  @XmlElement
  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  @XmlElement
  public int getNumeroMovimiento() {
    return numeroMovimiento;
  }

  public void setNumeroMovimiento(int numeroMovimiento) {
    this.numeroMovimiento = numeroMovimiento;
  }

  @XmlElement
  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  @XmlElement
  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  @XmlElement
  public String getAccion() {
    return accion;
  }

  public void setAccion(String accion) {
    this.accion = accion;
  }

  @XmlElement
  public double getImporte() {
    return importe;
  }

  public void setImporte(double importe) {
    this.importe = importe;
  }

}
