package pe.egcc.app.genera;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

public class GeneraProducto {

  public static void main(String[] args) throws PropertyException, JAXBException {
    
    Producto producto = new Producto(1000, "Refrigeradora", 4790.00);
    
    File file = new File("E:\\111\\producto.xml");
    
    JAXBContext jaxbContext = JAXBContext.newInstance(Producto.class);
    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); 

    // Escribir en el archivo 
    jaxbMarshaller.marshal(producto, file); 

    // Salida por consola 
    jaxbMarshaller.marshal(producto, System.out); 
  
  }

}
