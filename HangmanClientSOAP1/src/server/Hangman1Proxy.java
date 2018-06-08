package server;

public class Hangman1Proxy implements server.Hangman1 {
  private String _endpoint = null;
  private server.Hangman1 hangman1 = null;
  
  public Hangman1Proxy() {
    _initHangman1Proxy();
  }
  
  public Hangman1Proxy(String endpoint) {
    _endpoint = endpoint;
    _initHangman1Proxy();
  }
  
  private void _initHangman1Proxy() {
    try {
      hangman1 = (new server.HangmanLocator()).getHangman1Port();
      if (hangman1 != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)hangman1)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)hangman1)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (hangman1 != null)
      ((javax.xml.rpc.Stub)hangman1)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public server.Hangman1 getHangman1() {
    if (hangman1 == null)
      _initHangman1Proxy();
    return hangman1;
  }
  
  public int registerUser(java.lang.String name, java.lang.String surname, java.lang.String username, java.lang.String password, java.lang.String email) throws java.rmi.RemoteException{
    if (hangman1 == null)
      _initHangman1Proxy();
    return hangman1.registerUser(name, surname, username, password, email);
  }
  
  public java.lang.String addGuess(java.lang.String letter, int player, int game) throws java.rmi.RemoteException{
    if (hangman1 == null)
      _initHangman1Proxy();
    return hangman1.addGuess(letter, player, game);
  }
  
  public java.lang.String getRandomWord() throws java.rmi.RemoteException{
    if (hangman1 == null)
      _initHangman1Proxy();
    return hangman1.getRandomWord();
  }
  
  public java.lang.String getWord(int gid) throws java.rmi.RemoteException{
    if (hangman1 == null)
      _initHangman1Proxy();
    return hangman1.getWord(gid);
  }
  
  public int guessesUsed(int gID) throws java.rmi.RemoteException{
    if (hangman1 == null)
      _initHangman1Proxy();
    return hangman1.guessesUsed(gID);
  }
  
  public int newGame(int p1) throws java.rmi.RemoteException{
    if (hangman1 == null)
      _initHangman1Proxy();
    return hangman1.newGame(p1);
  }
  
  public int checkLogin(java.lang.String uname, java.lang.String pword) throws java.rmi.RemoteException{
    if (hangman1 == null)
      _initHangman1Proxy();
    return hangman1.checkLogin(uname, pword);
  }
  
  
}