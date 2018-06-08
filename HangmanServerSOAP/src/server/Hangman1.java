
/**
 *
 * @author berkayersengun
 */

package server;

import java.sql.SQLException;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "hangman")
public class Hangman1 {
	
	private Database database;
	
	public  Hangman1() {
		
		database = new Database();
	}
	
	
	
	
	
     /**
     * Web service operation
     */
    @WebMethod(operationName = "checkLogin")
    public int checkLogin(@WebParam(name = "uname") String uname, @WebParam(name = "pword") String pword) {
        int id = 0;
      
        id = database.checkLogin(uname, pword);
       ;
        return id;
    }

    /**
     * Web service operation
     */
    public String getRandomWord() {
        
        String myWord = database.getRandomWord();
     
        return myWord;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "newGame")
    public int newGame(@WebParam(name = "p1") int p1) {
        int gameId = 0;
       
        gameId = database.addNewGame(p1);
       
        return gameId;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "registerUser")
    public int registerUser(@WebParam(name = "name") String name, @WebParam(name = "surname") String surname, @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "email") String email) {
        int uid = 0;
      
        uid = database.register(name, surname, username, password, email);
    
        return uid;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getWord")
    public String getWord(@WebParam(name = "gid") int gid) {
        String myword = "";
       
        myword = database.getWordFromGame(gid);
     
        return myword;
    }
  
   

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addGuess")
    public String addGuess(@WebParam(name = "letter") String letter, @WebParam(name = "player") int player, @WebParam(name = "game") int game) {
       
        int correct = 0;
        String myword = database.getWordFromGame(game);
        String[] bits = myword .split("");
        String result = "";
        for(int i=0;i<bits.length;i++) {
            if(bits[i].equals(letter) == true) {
                result += i + ",";
            }
        }
        if(result.length() > 0) {
            correct = 1;
            result = result.substring(0,result.length()-1);
        }
        
        database.guess(letter, game, player, correct);
       
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "guessesUsed")
    public int guessesUsed(@WebParam(name = "gID") int gID) {
      
        int guesses = database.guessesUsed(gID);
      
        return guesses;
    }
    
    
}
