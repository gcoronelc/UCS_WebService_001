
package pe.egcc.demows.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pe.egcc.demows.ws package. 
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

    private final static QName _TraerLibros_QNAME = new QName("http://ws.demows.egcc.pe/", "traerLibros");
    private final static QName _TraerLibrosResponse_QNAME = new QName("http://ws.demows.egcc.pe/", "traerLibrosResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pe.egcc.demows.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TraerLibros }
     * 
     */
    public TraerLibros createTraerLibros() {
        return new TraerLibros();
    }

    /**
     * Create an instance of {@link TraerLibrosResponse }
     * 
     */
    public TraerLibrosResponse createTraerLibrosResponse() {
        return new TraerLibrosResponse();
    }

    /**
     * Create an instance of {@link Libro }
     * 
     */
    public Libro createLibro() {
        return new Libro();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TraerLibros }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.demows.egcc.pe/", name = "traerLibros")
    public JAXBElement<TraerLibros> createTraerLibros(TraerLibros value) {
        return new JAXBElement<TraerLibros>(_TraerLibros_QNAME, TraerLibros.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TraerLibrosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.demows.egcc.pe/", name = "traerLibrosResponse")
    public JAXBElement<TraerLibrosResponse> createTraerLibrosResponse(TraerLibrosResponse value) {
        return new JAXBElement<TraerLibrosResponse>(_TraerLibrosResponse_QNAME, TraerLibrosResponse.class, null, value);
    }

}
