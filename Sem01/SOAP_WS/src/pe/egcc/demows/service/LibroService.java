package pe.egcc.demows.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pe.egcc.demows.model.Libro;

public class LibroService {

  public List<Libro> traerLibros() {

    List<Libro> libros = new ArrayList<>();
    
    libros.add(new Libro(2017, 
            new ArrayList<>(Arrays.asList("Gustavo Coronel", "Ricardo Marcelo")), 
            "Editora Uno", "Java Web Services", 
            "Guia completa para programar servicios web con Java."));
    
    libros.add(new Libro(2017, 
            new ArrayList<>(Arrays.asList("Sergio Matsukawa")), 
            "Editora Dos", "SQL Server Advanced", 
            "Guia del DBA de SQL Server."));
    
    libros.add(new Libro(2018, 
            new ArrayList<>(Arrays.asList("Ernesto Calvo")), 
            "Editora Uno", "MS Project Advanced", 
            "Guia completa para la gestión de proyectos."));
    
    return libros;

  }

}
