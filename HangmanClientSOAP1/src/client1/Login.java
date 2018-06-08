package client1;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import server.Hangman1;


public class Login {

	private JPanel panel;
	private JFrame frame;
	private JLabel label1,label2,label3;
	private JButton button1,button2;
	private JTextField textField;
	private JPasswordField passwordField;
	private Hangman1 hangman1;
	private int playerID;
	
	public Login (Hangman1 hangman1) {
		
		this.hangman1 = hangman1;
		
		GridBagLayout grid = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        
        panel = new JPanel(grid);
        
        button1 = new JButton("SUBMIT");
        button1.addActionListener(new submitListener());
                
        label1 = new JLabel("Username");
        label2 = new JLabel("Password");
        label3 = new JLabel("Login");
        
        textField = new JTextField(15);
        passwordField = new JPasswordField(15);
        
        c.insets = new Insets(3, 3, 3, 3);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 0;
        c.gridx = 1 ; 
        panel.add(label3,c);
        
        
        c.gridx = 0 ;
        c.gridy = 1 ; 
        panel.add(label1,c);
        
        c.gridx = 1 ;
        c.gridy = 1 ; 
        c.gridwidth = 3 ; 
        panel.add(textField,c);
        
        c.gridx = 0 ;
        c.gridy = 2 ; 
        c.gridwidth = 1 ; 
        panel.add(label2,c);
        
        c.gridx = 1 ;
        c.gridy = 2 ; 
        c.gridwidth = 3 ; 
        panel.add(passwordField,c);
        
        c.gridx = 1 ;
        c.gridy = 3 ; 
        c.gridwidth = 1 ; 
       
        panel.add(button1,c);
                
        
        	
        frame= new JFrame("Login Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(300,175);
        frame.add(panel);
        frame.setVisible(true);
         
		
	}
	
    private class submitListener implements ActionListener{
        public void actionPerformed(ActionEvent e ){
           
        	
        	int check =0 ; 
        	String username = textField.getText();
        	char[] pass = passwordField.getPassword();
        	String password = new String(pass) ;     	
        	
        	try {
				 check = hangman1.checkLogin(username, password);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
        	switch (check) {
			case 0:
				System.out.println("Credentials incorrect.");
				break;
				
			case -1:
			case -2:
				System.out.println("Database connection problem.");
				break;
				
			default:
				
	        	
	        	System.out.println("User logged in with ID number of " + check);
	        	
	        	
	        	int newGame = -1;
	    	
	        	try {
					newGame = hangman1.newGame(check);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	
	        	
	    		if (newGame == -1) {
	    			
	    		System.out.println("Error creating a new game, try again.");	
	    		break;
	    			
	    		}
	    		else {
					new Game(hangman1,check,newGame);
					frame.dispose();
					System.out.println("A game created in database with the number of " + newGame);
					break;
					
				}
	    		
			}
        			
        			
        			
        	
        	
          
               
               
          

        }

    }
   
    

	
	

}
