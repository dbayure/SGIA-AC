package uy.com.ceoyphoibe.SGIA.wsClient;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.4.6
 * 2015-02-06T20:43:32.324-02:00
 * Generated source version: 2.4.6
 * 
 */
@WebServiceClient(name = "Comunicacion", 
                  wsdlLocation = "http://192.168.0.102:7789/?wsdl",
                  targetNamespace = "Comunicacion.Comunicacion") 
public class Comunicacion_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("Comunicacion.Comunicacion", "Comunicacion");
    public final static QName Comunicacion = new QName("Comunicacion.Comunicacion", "Comunicacion");
    static {
        URL url = null;
        try {
            url = new URL("http://192.168.0.102:7789/?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(Comunicacion_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://192.168.0.102:7789/?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public Comunicacion_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public Comunicacion_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Comunicacion_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public Comunicacion_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public Comunicacion_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public Comunicacion_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns Comunicacion
     */
    @WebEndpoint(name = "Comunicacion")
    public Comunicacion getComunicacion() {
        return super.getPort(Comunicacion, Comunicacion.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Comunicacion
     */
    @WebEndpoint(name = "Comunicacion")
    public Comunicacion getComunicacion(WebServiceFeature... features) {
        return super.getPort(Comunicacion, Comunicacion.class, features);
    }

}
