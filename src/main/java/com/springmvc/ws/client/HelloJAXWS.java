
package com.springmvc.ws.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelloJAXWS", targetNamespace = "http://server.ws.springmvc.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HelloJAXWS {


    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://server.ws.springmvc.com/", className = "com.springmvc.ws.client.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://server.ws.springmvc.com/", className = "com.springmvc.ws.client.SayHelloResponse")
    @Action(input = "http://server.ws.springmvc.com/HelloJAXWS/sayHelloRequest", output = "http://server.ws.springmvc.com/HelloJAXWS/sayHelloResponse")
    public String sayHello();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHello2", targetNamespace = "http://server.ws.springmvc.com/", className = "com.springmvc.ws.client.SayHello2")
    @ResponseWrapper(localName = "sayHello2Response", targetNamespace = "http://server.ws.springmvc.com/", className = "com.springmvc.ws.client.SayHello2Response")
    @Action(input = "http://server.ws.springmvc.com/HelloJAXWS/sayHello2Request", output = "http://server.ws.springmvc.com/HelloJAXWS/sayHello2Response")
    public String sayHello2(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
