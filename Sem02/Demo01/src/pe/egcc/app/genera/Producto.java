package pe.egcc.app.genera;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "producto")
public class Producto {

  private int id;
  private String nombre;
  private double precio;

  public Producto() {
  }

  public Producto(int id, String nombre, double precio) {
    this.id = id;
    this.nombre = nombre;
    this.precio = precio;
  }

  public int getId() {
    return id;
  }

  @XmlAttribute
  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  @XmlElement
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getPrecio() {
    return precio;
  }

  @XmlElement
  public void setPrecio(double precio) {
    this.precio = precio;
  }

}
