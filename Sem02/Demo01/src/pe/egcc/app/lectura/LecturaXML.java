package pe.egcc.app.lectura;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class LecturaXML {

  public static void main(String[] args) throws JAXBException {
    
    JAXBContext context = JAXBContext.newInstance(Libreria.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    
    /*
    String fileName = "/pe/egcc/app/lectura/libreria.xml";
    InputStream isXML = Class.class.getResourceAsStream(fileName);
    Libreria libreria = (Libreria) unmarshaller.unmarshal(isXML);
    */
    
    File file = new File("E:\\EGCC\\libreria.xml");
    Libreria libreria = (Libreria) unmarshaller.unmarshal(file);
    
    System.out.println("Nombre: " + libreria.getNombre());
    ArrayList<Libro> libros = libreria.getLibros();
    for (Libro l : libros) {
      System.out.println(l.getIsbn() + " | " + l.getTitulo() + " | " + l.getAutor());
    }
    
  }

}
