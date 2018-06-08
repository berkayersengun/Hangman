/**
 * Hangman1.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package server;

public interface Hangman1 extends java.rmi.Remote {
    public int registerUser(java.lang.String name, java.lang.String surname, java.lang.String username, java.lang.String password, java.lang.String email) throws java.rmi.RemoteException;
    public java.lang.String addGuess(java.lang.String letter, int player, int game) throws java.rmi.RemoteException;
    public java.lang.String getRandomWord() throws java.rmi.RemoteException;
    public java.lang.String getWord(int gid) throws java.rmi.RemoteException;
    public int guessesUsed(int gID) throws java.rmi.RemoteException;
    public int newGame(int p1) throws java.rmi.RemoteException;
    public int checkLogin(java.lang.String uname, java.lang.String pword) throws java.rmi.RemoteException;
}
