package pe.egcc.app.lectura2;

import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class PruebaCursos {
  
  public static void main(String[] args) throws JAXBException {
    
    JAXBContext context = JAXBContext.newInstance(Curso.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    
    String fileName = "/pe/egcc/app/lectura2/Curso.xml";
    InputStream isXML = Class.class.getResourceAsStream(fileName);
    Curso curso = (Curso) unmarshaller.unmarshal(isXML);   
    
    System.out.println("Nombre: " + curso.getNombre());
    System.out.println("Profesor: " + curso.getProfesor());
    ArrayList<Estudiante> estudiantes = curso.getEstudiantes();
    for (Estudiante o : estudiantes) {
      System.out.println( o.getCarrera() + " | " + o.getNombre() + " | " + o.getNota());
    }
    
  }
}
