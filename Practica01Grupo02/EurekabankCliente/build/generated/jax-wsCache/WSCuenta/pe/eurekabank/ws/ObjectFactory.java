
package pe.eurekabank.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pe.eurekabank.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LeerMovimientosResponse_QNAME = new QName("http://ws.eurekabank.pe/", "leerMovimientosResponse");
    private final static QName _Movimiento_QNAME = new QName("http://ws.eurekabank.pe/", "movimiento");
    private final static QName _LeerMovimientos_QNAME = new QName("http://ws.eurekabank.pe/", "leerMovimientos");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pe.eurekabank.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LeerMovimientosResponse }
     * 
     */
    public LeerMovimientosResponse createLeerMovimientosResponse() {
        return new LeerMovimientosResponse();
    }

    /**
     * Create an instance of {@link Movimiento }
     * 
     */
    public Movimiento createMovimiento() {
        return new Movimiento();
    }

    /**
     * Create an instance of {@link LeerMovimientos }
     * 
     */
    public LeerMovimientos createLeerMovimientos() {
        return new LeerMovimientos();
    }

    /**
     * Create an instance of {@link Date }
     * 
     */
    public Date createDate() {
        return new Date();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerMovimientosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.eurekabank.pe/", name = "leerMovimientosResponse")
    public JAXBElement<LeerMovimientosResponse> createLeerMovimientosResponse(LeerMovimientosResponse value) {
        return new JAXBElement<LeerMovimientosResponse>(_LeerMovimientosResponse_QNAME, LeerMovimientosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Movimiento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.eurekabank.pe/", name = "movimiento")
    public JAXBElement<Movimiento> createMovimiento(Movimiento value) {
        return new JAXBElement<Movimiento>(_Movimiento_QNAME, Movimiento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerMovimientos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.eurekabank.pe/", name = "leerMovimientos")
    public JAXBElement<LeerMovimientos> createLeerMovimientos(LeerMovimientos value) {
        return new JAXBElement<LeerMovimientos>(_LeerMovimientos_QNAME, LeerMovimientos.class, null, value);
    }

}
