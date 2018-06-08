/**
 * HangmanLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package server;

public class HangmanLocator extends org.apache.axis.client.Service implements server.Hangman {

    public HangmanLocator() {
    }


    public HangmanLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HangmanLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Hangman1Port
    private java.lang.String Hangman1Port_address = "http://desktop-rljvdhq:8080/HangmanServerSOAP/hangman";

    public java.lang.String getHangman1PortAddress() {
        return Hangman1Port_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Hangman1PortWSDDServiceName = "Hangman1Port";

    public java.lang.String getHangman1PortWSDDServiceName() {
        return Hangman1PortWSDDServiceName;
    }

    public void setHangman1PortWSDDServiceName(java.lang.String name) {
        Hangman1PortWSDDServiceName = name;
    }

    public server.Hangman1 getHangman1Port() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Hangman1Port_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHangman1Port(endpoint);
    }

    public server.Hangman1 getHangman1Port(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            server.Hangman1PortBindingStub _stub = new server.Hangman1PortBindingStub(portAddress, this);
            _stub.setPortName(getHangman1PortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHangman1PortEndpointAddress(java.lang.String address) {
        Hangman1Port_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (server.Hangman1.class.isAssignableFrom(serviceEndpointInterface)) {
                server.Hangman1PortBindingStub _stub = new server.Hangman1PortBindingStub(new java.net.URL(Hangman1Port_address), this);
                _stub.setPortName(getHangman1PortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Hangman1Port".equals(inputPortName)) {
            return getHangman1Port();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://server/", "hangman");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://server/", "Hangman1Port"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Hangman1Port".equals(portName)) {
            setHangman1PortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
