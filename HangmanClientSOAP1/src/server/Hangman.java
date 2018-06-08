/**
 * Hangman.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package server;

public interface Hangman extends javax.xml.rpc.Service {
    public java.lang.String getHangman1PortAddress();

    public server.Hangman1 getHangman1Port() throws javax.xml.rpc.ServiceException;

    public server.Hangman1 getHangman1Port(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
