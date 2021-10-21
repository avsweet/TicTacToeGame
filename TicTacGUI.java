package cen4010.pa2.Untitled;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/*
 * Public class Tic Tac GUI extends to JFrame and defines the variables that will be used within different classes/function
 */
public class TicTacGUI extends JFrame{
 
	private Container pane;
	private String currentPlayer;
	private JButton [][] board;
	private boolean hasWinner;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem quit;
	private JMenuItem newGame;
	
	/*
	 * Public class TicTacGUI gives the variables values and creates the grid/board the game will be played on. The size and grid layout are defined in this function 
	 */
	public TicTacGUI(){
		super();
		pane = getContentPane();
		pane.setLayout(new GridLayout(3,3));
		setTitle(" Tic Tac Toe");
		setSize(500,500);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		currentPlayer = "x";
		board = new JButton[3][3];
		hasWinner = false;
		intializeBoard();
		intializeMenuBar();
		
	}
	/*
	 * IntializeMenuBar class is the set up of our menu bar in the top left corner of the game which displays file with a drop down for quit and new game. 
	 */
		private void intializeMenuBar() {
			menuBar = new JMenuBar();
			menu = new JMenu("File");
			newGame = new JMenuItem("New Game");
			newGame.addActionListener(new ActionListener() {
				 
				public void actionPerformed(ActionEvent e) {
					resetBoard();
				}
			});
			quit = new JMenuItem("Quit");
			quit.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
					
				}
			});
			menu.add(newGame);
			menu.add(quit);
			menuBar.add(menu);
			setJMenuBar(menuBar);
		}
		/*
		 * resetBoard function resets the board. Self explanatory
		 */
		private void resetBoard() {
			currentPlayer = "x";
			hasWinner = false;
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					board[i][j].setText("");
				}
			}
		}
		/**
		 * intializeBoard intializes where the users selects with their corresponding variable. 
		 */
		private void intializeBoard() {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					JButton button = new JButton();
					button.setFont(new Font(Font.SANS_SERIF, Font.BOLD,100));
					board[i][j] = button;
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(((JButton)e.getSource()).getText().equals("") &&
							hasWinner == false){
								button.setText(currentPlayer);
								hasWinner();
								togglePlayer();
							}
						
						}
					});
					pane.add(button);
				}
				
			}
		}
		/*
		 * togglePlayer alternates from x to o 
		 */
		private void togglePlayer() {
				if(currentPlayer.equals("x"))
					currentPlayer = "o";
				else 
					currentPlayer = "x";
	      }
		/*
		 * hasWinner stores all of the logic on how the users can win the game and once users wins, it states who won and quits the game on its own. 
		 */
		private void hasWinner(){
			if (board[0][0].getText().equals(currentPlayer) && board [1][0].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)){
				hasWinner = true;
			}
			else if (board [0][1].getText().equals(currentPlayer) && board [1][1].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer)){
			hasWinner = true;
			}
			else if (board [0] [2].getText().equals(currentPlayer) && board [1][2].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)){
		    hasWinner = true;
			}
			   if(board[0][0].getText().equals(currentPlayer) && board [0][1].getText().equals(currentPlayer) && board[0][2].getText().equals(currentPlayer)){
				    hasWinner = true;
			}
			else if (board [1][0].getText().equals(currentPlayer) && board [1][1].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer)){
				hasWinner = true;
			}
			else if (board [2][0].getText().equals(currentPlayer) && board [2][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)){
				hasWinner = true;
			}
			    if (board [0][0].getText().equals(currentPlayer) && board [1][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)){
				hasWinner = true;
			}
			else if (board [2][0].getText().equals(currentPlayer) && board [1][1].getText().equals(currentPlayer) && board[0][2].getText().equals(currentPlayer)){
				hasWinner = true;
			}
			if (hasWinner) {
			    JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won the game. Quitting game");
			    System.exit(0);
			    
			}
		}
}
		

