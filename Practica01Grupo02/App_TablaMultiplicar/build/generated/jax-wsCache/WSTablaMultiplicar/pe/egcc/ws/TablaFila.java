
package pe.egcc.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tablaFila complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tablaFila">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="num1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="num2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="opera" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rpta" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tablaFila", propOrder = {
    "num1",
    "num2",
    "opera",
    "rpta"
})
public class TablaFila {

    protected int num1;
    protected int num2;
    protected String opera;
    protected int rpta;

    /**
     * Obtiene el valor de la propiedad num1.
     * 
     */
    public int getNum1() {
        return num1;
    }

    /**
     * Define el valor de la propiedad num1.
     * 
     */
    public void setNum1(int value) {
        this.num1 = value;
    }

    /**
     * Obtiene el valor de la propiedad num2.
     * 
     */
    public int getNum2() {
        return num2;
    }

    /**
     * Define el valor de la propiedad num2.
     * 
     */
    public void setNum2(int value) {
        this.num2 = value;
    }

    /**
     * Obtiene el valor de la propiedad opera.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpera() {
        return opera;
    }

    /**
     * Define el valor de la propiedad opera.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpera(String value) {
        this.opera = value;
    }

    /**
     * Obtiene el valor de la propiedad rpta.
     * 
     */
    public int getRpta() {
        return rpta;
    }

    /**
     * Define el valor de la propiedad rpta.
     * 
     */
    public void setRpta(int value) {
        this.rpta = value;
    }

}
