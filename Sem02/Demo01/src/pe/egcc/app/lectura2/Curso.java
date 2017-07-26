package pe.egcc.app.lectura2;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "curso")
@XmlType(propOrder = {"nombre", "profesor","estudiantes"})

public class Curso {

  private String nombre;
  private String profesor;
  private ArrayList<Estudiante> estudiantes;

  public Curso() {
  }

  public Curso(String nombre, String profesor, ArrayList<Estudiante> estudiantes) {
    this.nombre = nombre;
    this.profesor = profesor;
    this.estudiantes = estudiantes;
  }

  @XmlElement(name = "nombre")
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @XmlElement(name = "profesor")
  public String getProfesor() {
    return profesor;
  }

  public void setProfesor(String profesor) {
    this.profesor = profesor;
  }

  public ArrayList<Estudiante> getEstudiantes() {
    return estudiantes;
  }

  @XmlElementWrapper(name = "estudiantes")
  @XmlElement(name = "estudiante")  
  public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
    this.estudiantes = estudiantes;
  }

}
