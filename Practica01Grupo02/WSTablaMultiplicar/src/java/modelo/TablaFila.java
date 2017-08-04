
package modelo;

public class TablaFila {
  
private int num1; 
private int num2; 
private int rpta; 
private String opera; 

    public TablaFila() {  
    }

    public TablaFila(int num1, int num2, int rpta, String opera) {
        this.num1 = num1;
        this.num2 = num2;
        this.rpta = rpta;
        this.opera = opera;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getRpta() {
        return rpta;
    }

    public void setRpta(int rpta) {
        this.rpta = rpta;
    }

    public String getOpera() {
        return opera;
    }

    public void setOpera(String opera) {
        this.opera = opera;
    }

}
