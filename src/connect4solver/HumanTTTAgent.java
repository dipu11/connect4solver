/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4solver;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class HumanTTTAgent extends Agent
{

    
	static Scanner in = new Scanner(System.in);
	public HumanTTTAgent(String name,int role) {
		super(name);
                this.role=role;
		// TODO Auto-generated constructor stub
	}

	public  void makeMove(Game game) {
		// TODO Auto-generated method stub
		
		int row,col;
		TickTackToe tttGame = (TickTackToe) game;
		View.playerNameSet(name);
                while(true){
                    
                    if(View.selectedCol!=-1){
                        col=View.selectedCol;
                        View.selectedCol=-1;
                        if(tttGame.isValidCell(col))
                            break;
                        else{
                            JOptionPane.showMessageDialog(this,"Please Choose Another Column", "Alert", JOptionPane.PLAIN_MESSAGE);
                
                        }
                    }
                }
                
		/*boolean first = true;
		do
		{
			if(first) 	System.out.println("Insert column [0,2]");
			else System.out.println("Invalid input! Insert column [0,2] again.");
			//row = in.nextInt();
			col = in.nextInt();
			first=false;
		}while(!tttGame.isValidCell(col));*/
		
                
                for(row=tttGame.row-1;row>=0;row--){
                   
                    if(tttGame.board[row][col]==-1){
                        tttGame.board[row][col] = role;
                        
                            
                        break;
                    }
                    
                }
		
	}


	

}

