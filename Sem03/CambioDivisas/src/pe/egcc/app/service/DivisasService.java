package pe.egcc.app.service;

public class DivisasService {
  
  private final double SOLES_TO_DOLARES = 3.24;
  private final double SOLES_TO_EUROS = 4.34;
  private final double DOLARES_TO_EUROS = 1.20;
  
  public double solesToDolares(double soles){
    double dolares;
    dolares = soles / SOLES_TO_DOLARES;
    return dolares;    
  }

  
}
