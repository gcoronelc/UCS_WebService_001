package pe.egcc.demows.model;

import java.util.List;

public class Libro {

  private Integer anio;
  private List<String> autores;
  private String editorial;
  private String titulo;
  private String resumen;

  public Libro() {
  }

  public Libro(Integer anio, List<String> autores, String editorial, String titulo, String resumen) {
    this.anio = anio;
    this.autores = autores;
    this.editorial = editorial;
    this.titulo = titulo;
    this.resumen = resumen;
  }

  public Integer getAnio() {
    return anio;
  }

  public void setAnio(Integer anio) {
    this.anio = anio;
  }

  public List<String> getAutores() {
    return autores;
  }

  public void setAutores(List<String> autores) {
    this.autores = autores;
  }

  public String getEditorial() {
    return editorial;
  }

  public void setEditorial(String editorial) {
    this.editorial = editorial;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getResumen() {
    return resumen;
  }

  public void setResumen(String resumen) {
    this.resumen = resumen;
  }

}
