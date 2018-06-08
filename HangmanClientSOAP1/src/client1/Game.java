package client1;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.function.Predicate;

import javax.management.loading.PrivateClassLoader;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.xml.rpc.ServiceException;

import org.apache.axis.message.MessageWithAttachments;

import server.Hangman1;;



public class Game implements ActionListener {
	
	private Hangman1 hangman1;
	
	private JFrame frame;
	private JPanel panel1,panel2,panel3,panel4;
	private JButton button;
	private JTextField textField1,textField2;
	private JLabel label1,label2;
	private ImageIcon imageIcon;
	private String word,underscore;
	private char[] arrWord;
	private int playerID, gameID;
	private String[] imageList = { "images/8.png" ,"images/7.png", "images/6.png", "images/5.png",
								 "images/4.png", "images/3.png", "images/2.png", "images/1.png",
								 "images/0.png" };
	
	public Game(Hangman1 hangman1,int playerID, int gameID) {
		
		this.gameID = gameID;
		this.playerID = playerID;
		this.hangman1= hangman1;
			
		frame = new JFrame("HANGMAN");
		panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel2 = new JPanel();
		panel3 = new JPanel(new GridLayout(1, 1));
		panel4 = new JPanel();
		textField1 = new JTextField(3);
		textField2 = new JTextField();
		
		imageIcon = new ImageIcon(imageList[0]);
		label1 = new JLabel();
		label1.setIcon(imageIcon);
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		
	
			
		
		try {
			word = hangman1.getWord(gameID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(word);
		arrWord = new char[word.length()];
		Arrays.fill(arrWord, '_');
		
		underscore="";
				
		for (char x : arrWord) {
		System.out.print(x+" ");	
			underscore+=x+" ";
		}
		System.out.println("");
		
		label2 = new JLabel(underscore);
		label2.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		button = new JButton("Guess");
		button.addActionListener(this);
		textField1.addActionListener(this);
		
		panel1.add(label1);
		panel1.add(new JLabel(" "));
		panel1.add(label2);
		panel1.add(new JLabel(" "));
		
		panel2.add(textField1);
		panel2.add(button);
		
		panel3.add(BorderLayout.SOUTH,textField2);
	
		frame.setLocationRelativeTo(null);
		frame.add(BorderLayout.NORTH,panel1);
		frame.add(BorderLayout.CENTER,panel2);
		frame.add(BorderLayout.SOUTH, panel3);
		frame.add(BorderLayout.EAST,panel4);
		
		frame.setSize(300, 280);
		frame.setVisible(true);
				
	}
	
		
	
	public void actionPerformed(ActionEvent event) {
		
		
		
		
		if (textField1.getText().length()>1  )
			
			System.out.println("Enter only one character at a time.");
		
		else if (textField1.getText().length()==0)
		
			System.out.println("Enter one character for a guess.");
		
		else {
			
			String guess = textField1.getText().substring(0, 1);
			
			try {
				String s = hangman1.addGuess(guess, playerID, gameID);
				
				
				 if (hangman1.guessesUsed(gameID) == 8) {
						System.out.println("Game over.");
						textField2.setText("Game over.");
						label1.setIcon(new ImageIcon(imageList[hangman1.guessesUsed(gameID)]));
						
						frame.dispose();
						
						EndGUI endGUI = new EndGUI(hangman1);
						endGUI.lost();
                      
				 }
				 
				 else if (s.equals("")) {
					System.out.println("There is no match, try again.");
					textField2.setText("There is no match, try again.");	
					label1.setIcon(new ImageIcon(imageList[hangman1.guessesUsed(gameID)]));
			
					
				}else if (s.equals("EXCEPTION_ERROR")) {
					
					System.out.println("Error.");
				
				}else {
					
					String[] match = s.split(",");
					
					for(String a: match) {
						
						arrWord[Integer.valueOf(a)] = guess.charAt(0)  ;
						
						
					}
					underscore="";
					for (char x : arrWord) {
							
							underscore +=x+" ";
						}
					System.out.println(underscore);
					
					label2.setText(underscore);
					
					
					String checkWin = new String(arrWord);
					
					if (word.equals(checkWin)) {
						
						System.out.println("You win.");
						textField2.setText("You win.");
						
						frame.dispose();
						EndGUI endGUI = new EndGUI(hangman1);
						endGUI.win();
                        
                      
					}else
					
					textField2.setText("You have a match.");
					
				}
				
				
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		textField1.setText("");
		
	}
	
	public class EndGUI implements ActionListener{
		
		private JButton buttonExit, buttonAnother;
		private JLabel labelEnd;
		private JFrame frameEnd; 
		private JPanel panelEnd; 
		private GridBagConstraints c;
		private Hangman1 hangman1;
		
		public EndGUI(Hangman1 hangman1) {
			
			this.hangman1 = hangman1;
			
			 GridBagLayout grid = new GridBagLayout();
	         c = new GridBagConstraints();
		
			panelEnd = new JPanel(grid);
			frameEnd = new JFrame("Hangman Game");
				
			buttonAnother = new JButton("Play Again");
			buttonAnother.addActionListener(this);
			buttonExit = new JButton("Exit");
			buttonExit.addActionListener(this);
			
			c.insets = new Insets(3,8,3,8);
			
			c.gridx = 1;
			c.gridy = 3;
			panelEnd.add(buttonAnother,c);
			
			c.gridx = 3;
			c.gridy = 3;
			panelEnd.add(buttonExit,c);
					
					
			frameEnd.add(panelEnd);
			frameEnd.setLocationRelativeTo(null);
			frameEnd.setSize(200, 200);
			
		}
		
		public void win() {
			
			
			labelEnd= new JLabel("Game Over. You win.");
			
			c.gridx = 1;
			c.gridy = 1;
			c.gridwidth = 3;
			
			panelEnd.add(labelEnd,c);
			
			frameEnd.setVisible(true);
			
			
		}
		
		public void lost() {
			
			labelEnd = new JLabel("Game Over. You lost.");
			
			c.gridx = 1;
			c.gridy = 1;
			c.gridwidth = 3;
			
			panelEnd.add(labelEnd,c);
					
			frameEnd.setVisible(true);
		}

		
		public void actionPerformed(ActionEvent arg0) {
			
			if(arg0.getSource()== buttonAnother) {
				
				
				
				int newGame = -1,check = 0;
				try {
					newGame = hangman1.newGame(playerID);
					
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	
	        	
	    		if (newGame == -1) {
	    			
	    		System.out.println("Error creating a new game, try again.");	
	    	
	    			
	    		}
	    		else {
					new Game(hangman1,playerID,newGame);
					frameEnd.dispose();
					
					System.out.println("A game created in database with the number of " + newGame);
				
					
				}
				
			}else {
				
				System.exit(1);
			}
			
			
		}
		
		
	}

	


}
