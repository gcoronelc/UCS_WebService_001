
package pe.eurekabank.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WSCuenta", targetNamespace = "http://ws.eurekabank.pe/", wsdlLocation = "http://localhost:8080/WSEurekabank/WSCuenta?wsdl")
public class WSCuenta_Service
    extends Service
{

    private final static URL WSCUENTA_WSDL_LOCATION;
    private final static WebServiceException WSCUENTA_EXCEPTION;
    private final static QName WSCUENTA_QNAME = new QName("http://ws.eurekabank.pe/", "WSCuenta");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/WSEurekabank/WSCuenta?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSCUENTA_WSDL_LOCATION = url;
        WSCUENTA_EXCEPTION = e;
    }

    public WSCuenta_Service() {
        super(__getWsdlLocation(), WSCUENTA_QNAME);
    }

    public WSCuenta_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), WSCUENTA_QNAME, features);
    }

    public WSCuenta_Service(URL wsdlLocation) {
        super(wsdlLocation, WSCUENTA_QNAME);
    }

    public WSCuenta_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WSCUENTA_QNAME, features);
    }

    public WSCuenta_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WSCuenta_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WSCuenta
     */
    @WebEndpoint(name = "WSCuentaPort")
    public WSCuenta getWSCuentaPort() {
        return super.getPort(new QName("http://ws.eurekabank.pe/", "WSCuentaPort"), WSCuenta.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WSCuenta
     */
    @WebEndpoint(name = "WSCuentaPort")
    public WSCuenta getWSCuentaPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.eurekabank.pe/", "WSCuentaPort"), WSCuenta.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSCUENTA_EXCEPTION!= null) {
            throw WSCUENTA_EXCEPTION;
        }
        return WSCUENTA_WSDL_LOCATION;
    }

}
