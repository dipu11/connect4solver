/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4solver;

/**
 *
 * @author DIPU
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 
 * @author Abi
 * @version December 13, 2012
 *
 *This class visualizes the connect 4 game for the user with the 
 *connect four model class.
 */
public class View extends JFrame implements ActionListener
{
    
    JMenuItem newGameMI;
  /**
   * The menu item that allows the user to reset the board.
   */
   JMenuItem resetMI;
   
   /**
    * The menu item that allows the user to exit the board. 
    */
   JMenuItem exitMI;
   
   /**
    * The Textfield that displays the player that has the turn.
    */
   JTextField currentPlayer;
   
   /**
    * The buttons that allow the user to choose which column
    * to place a token in.
    */
   JButton[] placing;
   
   /**
    * The group of text fields that will display the pieces placed.
    */
   static JButton[][] grid;
   
   /** 
    * The Model object that allows all the functions of 
    * Model to be implemented in the GUI.
    */
   //Model game;
   
   TickTackToe game;
   /**
    * The constructor. Initializes the Model and the GUI.
    */
   
   static int selectedCol=-1;
   static JLabel thePlayer;
   
  public View(TickTackToe game)
  {
    //game = new Model(); 
    this.game=game;
    //JFrame frame = new JFrame("Connect 4");
    setLayout(new BorderLayout());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Connect Four");
    setPreferredSize(new Dimension(500, 500));

    
     
       
       //the Panel that informs the user about the current player.
       JPanel playerPanel = new JPanel();
       playerPanel.setLayout(new GridLayout(1,1));
       thePlayer = new JLabel("Current Player: ");
       //currentPlayer = new JTextField("1");//initializes to 1
       //currentPlayer.setEnabled(false);//no manipulating the player is allowed
       playerPanel.add(thePlayer);
       //playerPanel.add(currentPlayer);
      
       //The panel of buttons to push
       JPanel buttonPanel = new JPanel();
       buttonPanel.setLayout(new GridLayout(1, 7));
       placing = new JButton[7];
       for(int i = 0; i < game.col; i++)
       {//adding 7 buttons
         placing[i] = new JButton("" + (i + 1));
         placing[i].addActionListener(this);
         buttonPanel.add(placing[i]);
       }
       
       //the panel that holds the textfields displaying the tokens
       JPanel piecesPanel = new JPanel();
       piecesPanel.setLayout(new GridLayout(game.row,game.col));
       grid = new JButton[game.row][game.col];
       for(int i = 0; i <game.row; i++)
       {
         for(int j = 0; j < game.col; j++)
         {
           grid[i][j] = new JButton();
           //grid[i][j].setEnabled(false);
           grid[i][j].addActionListener(this);
           grid[i][j].setBackground(Color.LIGHT_GRAY);

           piecesPanel.add(grid[i][j]);
         }
       }       
       
       add(buttonPanel, BorderLayout.NORTH);
       add(piecesPanel, BorderLayout.CENTER);
       add(playerPanel, BorderLayout.SOUTH);
       //add(buttonPanel, BorderLayout.SOUTH);
       
       pack();
       setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e)
  {
      if(!game.playerName.contains("Computer")){
        for(int i=0; i<game.col; i++){
          
            if(e.getSource() == placing[i]){
                selectedCol=i;
                break;
                  
            }
        }
      
      }
      
      
      
      /*
      if(!game.playerName.contains("Computer")){
        if(e.getSource() == placing[0]){
          selectedCol=0;
        }else if(e.getSource() == placing[1]){
          selectedCol=1;
        }else if(e.getSource() == placing[2]){
          selectedCol=2;
        }else if(e.getSource() == placing[3]){
          selectedCol=3;
        }else if(e.getSource() == placing[4]){
          selectedCol=4;
        }else if(e.getSource() == placing[5]){
          selectedCol=5;
        }else if(e.getSource() == placing[6]){
          selectedCol=6;
        }
        
      }*/
      //currentPlayer.setText(game.playerName);
  }
  
  static int reset = 0;
  static int newGame = 0;
  
  static void playerNameSet(String name){
      thePlayer.setText("Current Player : "+name);
  }
  
 }
