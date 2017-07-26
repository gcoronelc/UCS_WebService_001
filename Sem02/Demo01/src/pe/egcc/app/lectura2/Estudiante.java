package pe.egcc.app.lectura2;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "estudiante")
@XmlType(propOrder = {"carrera", "nombre", "nota"})
public class Estudiante {
  
  private String carrera;
  private String nombre;
  private Integer nota;

  public Estudiante() {
  }

  public Estudiante(String carrera, String nombre, Integer nota) {
    this.carrera = carrera;
    this.nombre = nombre;
    this.nota = nota;
  }

  @XmlAttribute(name = "carrera")
  public String getCarrera() {
    return carrera;
  }

  public void setCarrera(String carrera) {
    this.carrera = carrera;
  }

  @XmlElement(name = "nombre")
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @XmlElement(name = "nota")
  public Integer getNota() {
    return nota;
  }

  public void setNota(Integer nota) {
    this.nota = nota;
  }
  
  
  
  
  
}
