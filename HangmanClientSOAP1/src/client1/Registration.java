package client1;

import java.awt.Color;
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
import javax.swing.JTextField;

import server.Hangman1;
import client1.*;


public class Registration  {
	
	private JPanel panel;
	private JFrame frame;
	private JButton buttonSubmit,buttonClear;
	private JTextField fieldName,fieldSurname,fieldUsername,fieldPassword,fieldEmail ;
	private JLabel labelName,labelSurname,labelUsername,labelPassword,labelRegistration,labelEmail;
	private String name,surname,username,password,email;
	private Hangman1 hangman1;

	
	public Registration(Hangman1 hangman1) {
		
		this.hangman1 = hangman1;
		
	 GridBagLayout grid = new GridBagLayout();
     GridBagConstraints c = new GridBagConstraints();

     panel = new JPanel(grid);
     panel.setBackground(Color.GRAY);
     panel.setVisible(true);

     labelRegistration = new JLabel("Registration");
     labelName = new JLabel("Name");
     labelSurname = new JLabel("Surname");
     labelUsername = new JLabel("Username");
     labelPassword = new JLabel("Password");
     labelEmail = new JLabel("Email");
     

     fieldName = new JTextField(15);
     fieldSurname = new JTextField(15);
     fieldUsername = new JTextField(15);
     fieldPassword = new JTextField(15);
     fieldEmail = new JTextField(15);
     

     buttonSubmit = new JButton("Submit");
     buttonSubmit.addActionListener(new submitListener());
     
     buttonClear = new JButton( "Clear");
     buttonClear.addActionListener(new clearListener());

     c.insets = new Insets(3,8,3,8);

     c.fill = GridBagConstraints.HORIZONTAL;
     c.gridx = 1 ;
     c.gridy = 0 ;
     c.ipady =10;
     panel.add(labelRegistration,c);

     c.ipady =0;
     c.ipadx = 20 ;
     c.gridx = 0;
     c.gridy = 1;
     panel.add(labelName,c);

     c.gridx = 1;
     c.gridy = 1;
     c.gridwidth = 3;
     panel.add(fieldName,c);

   
     c.gridx = 0;
     c.gridy = 2;
     panel.add(labelSurname,c);

     
     c.gridx = 1;
     c.gridy = 2;
     panel.add(fieldSurname,c);

     c.ipady =0;

     c.gridx = 0;
     c.gridy = 3;
     panel.add(labelUsername,c);

  
     c.gridx = 1;
     c.gridy = 3;
     panel.add(fieldUsername,c);

   
     c.gridx = 0;
     c.gridy = 4;
     panel.add(labelPassword,c);

   
     c.gridx = 1;
     c.gridy = 4;
     panel.add(fieldPassword,c);

     c.fill = GridBagConstraints.HORIZONTAL;
     c.gridx = 0;
     c.gridy = 5;
     panel.add(labelEmail,c);

     c.fill = GridBagConstraints.HORIZONTAL;
     c.gridx = 1;
     c.gridy = 5;
     panel.add(fieldEmail,c);

     c.fill = GridBagConstraints.CENTER;
     //c.anchor = GridBagConstraints.CENTER;
     c.ipadx = 15;
     c.gridy = 6 ;
     c.gridx = 1 ;
     c.gridwidth =1;
     panel.add(buttonSubmit,c);
     
     c.fill = GridBagConstraints.CENTER;
     c.ipadx = 15;
     c.gridy = 6 ;
     c.gridx = 2  ;
     c.gridwidth = 1 ;
     panel.add(buttonClear,c);



     frame = new JFrame("Registration Window");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setLocationRelativeTo(null);
     frame.setVisible(true);
     frame.setSize(350,250);
     frame.add(panel);

	
	
	}

	
	
	 private class submitListener implements ActionListener {
	        public void actionPerformed(ActionEvent event ) {

	            name = fieldName.getText();
	            surname = fieldSurname.getText();
	            username = fieldUsername.getText();
	            password = fieldPassword.getText();
	            email = fieldEmail.getText();
	            	            	
	            
	            
	           try {
				int check = hangman1.registerUser(name, surname, username, password, email);
				
				switch (check) {

				case 0:
					System.out.println("Credentials incorrect.");
					break;
					
				case -1:
				case -2:
					System.out.println("Database connection problem.");
					break;
					
				default:
                    System.out.println("User added to database with the id number of "+ check);
                    frame.dispose();
                    new Login(hangman1);
					break;
				}
				
				
				
				
				
			} catch (RemoteException e) {
				
				e.printStackTrace();
			}
			

	    }
	 }
	        
	    private class clearListener implements ActionListener{
	        public void actionPerformed(ActionEvent e ){

	            fieldName.setText("");
	            fieldSurname.setText("");
	            fieldUsername.setText("");
	            fieldPassword.setText("");
	           

	        }

	    }
	
	
	}
