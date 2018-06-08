package client1;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.rpc.ServiceException;

import server.Hangman1;
import server.HangmanLocator;


public class Client {
	
	private HangmanLocator hangmanLocator; 
	private Hangman1 hangman1;
	
	private JPanel panel;
    private JFrame frame ;
    private JButton newButton;
    private JButton existingButton;
    private JLabel label;
    
    public JFrame getFrame() {
    	return this.frame;
    	    	
    }
    
    
	public Client() {
		
		
	
		//Web service connection
				hangmanLocator = new HangmanLocator();
				
				try {
					hangman1 = hangmanLocator.getHangman1Port();
				} catch (ServiceException e) {
					e.printStackTrace();
				}
		
		
    GridBagLayout grid = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();

    panel = new JPanel(grid);
    panel.setBackground(Color.WHITE);
    panel.setVisible(true);
    label= new JLabel("Hangman");

    newButton = new JButton("Sign Up");
    newButton.addActionListener(new newUserListener());
   
    existingButton = new JButton("Login");
    existingButton.addActionListener(new existingUserListener());
    
    c.insets = new Insets(2,2,2,2);

    c.gridx = 0 ;
    c.ipady = 10 ;
    c.gridy = 0;
    panel.add(label,c);

    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridy = 1;
    c.ipady = 6 ;
    panel.add(newButton,c);

    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridy = 2;
    panel.add(existingButton,c);

    c.gridy = 4;

    frame = new JFrame("Hangman");
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setSize(200,175);
    frame.add(panel);
	}
	
public static void main(String[] arg ) {
		
		new Client();
		
	}


public class newUserListener implements ActionListener{
    public void actionPerformed(ActionEvent e ){

        frame.dispose();
        new Registration(hangman1);
        
       
    }

}

public class existingUserListener implements ActionListener{
    public void actionPerformed(ActionEvent e ){
    	
        frame.dispose();
        new Login(hangman1);
       
           
      

    }

}


}
