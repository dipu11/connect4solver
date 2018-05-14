package connect4solver;


import java.util.ArrayList;


/**
 * Example MiniMax agent extending Agent class.
 * Here, for simplicity of understanding min and max functions are written separately. One single function can do the task. 
 * @author Azad, course teacher, provided the skeleton of the project
 *@author DIPU
 */
public class MinimaxTTTAgent extends Agent
{
	
    static int depth=0;
    
	public MinimaxTTTAgent(String name, int role) {
		super(name);
                this.role=role;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void makeMove(Game game) {
		// TODO Auto-generated method stub
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TickTackToe tttGame = (TickTackToe) game;
		//CellValueTuple best = max(tttGame);
                CellValueTuple best = maxValue(tttGame,-1000,1000);
                System.out.println("best value: "+best.col);
		if(best.col!=-1)
		{
			tttGame.board[best.row][best.col] = role;
                        if(best.row!=0)
                            
                            View.grid[best.row-1][best.col].setEnabled(true);
		}
		
	}
	private CellValueTuple maxValue(TickTackToe game,int alpha,int beta)
        {
            
                CellValueTuple maxCVT = new CellValueTuple();
		maxCVT.utility = -1000;
		
		int winner = game.checkForWin();
		
		//terminal check
		if(winner == role)
		{
			maxCVT.utility = 1; //this agent wins
			return maxCVT;
		}
		else if(winner!=-1) 
		{
			maxCVT.utility = -1; //opponent wins
			return maxCVT;  
		}
		else if (game.isBoardFull())
		{
			maxCVT.utility = 0; //draw
			return maxCVT;  
		}
		
                int v = -1000;
                ArrayList<Grid> blankCell = getEmptyBoard(game);
                for(int i=0; i<blankCell.size(); i++)
                {
                    Grid grid = blankCell.get(i);
                    game.board[grid.row][grid.col]=role;
                    v = maximum(v,minValue(game,alpha,beta).utility);
                    //System.out.println("v: "+v );
                    //System.out.println("i : "+i+ "size : "+ blankCell.size());
                    if(v>=beta)
                    {
                        maxCVT.utility = v;
                        maxCVT.row = grid.row;
                        maxCVT.col = grid.col;
                        game.board[grid.row][grid.col]=-1;
                        return maxCVT;
                    }
                    alpha = maximum(alpha,v);
                    game.board[grid.row][grid.col]=-1;
                }
		return maxCVT;
        
        }
        
        private CellValueTuple minValue(TickTackToe game,int alpha,int beta)
        {
            //depth++;
                CellValueTuple minCVT = new CellValueTuple();
		minCVT.utility = 1000;
		
		int winner = game.checkForWin();
		
		//terminal check
		if(winner == role)
		{
			minCVT.utility = 1; //this agent wins
			return minCVT;
		}
		else if(winner!=-1) 
		{
			minCVT.utility = -1; //opponent wins
			return minCVT;  
		}
		else if (game.isBoardFull())
		{
			minCVT.utility = 0; //draw
			return minCVT;  
		}
		
                int v = 1000;
                ArrayList<Grid> blankCell = getEmptyBoard(game);
                for(int i=0; i<blankCell.size(); i++)
                {
                    Grid grid = blankCell.get(i);
                    game.board[grid.row][grid.col]=minRole();
                    v = minimum(v,maxValue(game,alpha,beta).utility);
                    //System.out.println("vmax: "+v +"util: "+maxCVT.utility);
                    //System.out.println("i : "+i+ "size : "+ blankCell.size());
                    if(v<=alpha)
                    {
                        minCVT.utility = v;
                        minCVT.row = grid.row;
                        minCVT.col = grid.col;
                        game.board[grid.row][grid.col]=-1;
                        return minCVT;
                    }
                    beta = minimum(beta,v);
                    game.board[grid.row][grid.col]=-1;
                }
		return minCVT;
        
        }
        
        public int maximum(int a, int b)
        {
            if(a>=b) return a;
            else return b;
        }
        public int minimum(int a, int b)
        {
            if(a<=b) return a;
            else return b;
        }
	private CellValueTuple max(TickTackToe game)
	{	
		CellValueTuple maxCVT = new CellValueTuple();
		maxCVT.utility = -100;
		
		int winner = game.checkForWin();
		
		//terminal check
		if(winner == role)
		{
			maxCVT.utility = 1; //this agent wins
			return maxCVT;
		}
		else if(winner!=-1) 
		{
			maxCVT.utility = -1; //opponent wins
			return maxCVT;  
		}
		else if (game.isBoardFull())
		{
			maxCVT.utility = 0; //draw
			return maxCVT;  
		}
		
	/*	for (int i = 0; i < 5; i++) 
		{
			for (int j = 0; j<6;j++)
			{
				if(game.board[i][j]!=-1) continue;
				
				game.board[i][j] = role; //temporarily making a move
				int v = min(game).utility;
				if(v>maxCVT.utility)
				{
					maxCVT.utility=v;
					maxCVT.row = i;
					maxCVT.col = j;
                                        //System.out.println("check");
				}
				game.board[i][j] = -1; // reverting back to original state
				
			}
		}*/
                ArrayList<Grid> blankCell = getEmptyBoard(game);
                for(int i=0; i<blankCell.size(); i++)
                {
                    Grid grid = blankCell.get(i);
                    game.board[grid.row][grid.col]=role;
                    int v = min(game).utility;
                    //System.out.println("vmax: "+v +"util: "+maxCVT.utility);
                    //System.out.println("i : "+i+ "size : "+ blankCell.size());
                    if(v>maxCVT.utility)
                    {
                        maxCVT.utility = v;
                        maxCVT.row = grid.row;
                        maxCVT.col = grid.col;
                    }
                    game.board[grid.row][grid.col]=-1;
                }
		return maxCVT;
			
	}
	
	private CellValueTuple min(TickTackToe game)
	{	
		CellValueTuple minCVT = new CellValueTuple();
		minCVT.utility = 100;
		
		int winner = game.checkForWin();
		
		//terminal check
		if(winner == role)
		{
			minCVT.utility = 1; //max wins
			return minCVT;
		}
		else if(winner!=-1) 
		{
			minCVT.utility = -1; //min wins
			return minCVT;  
		}
		else if (game.isBoardFull())
		{
			minCVT.utility = 0; //draw
			return minCVT;  
		}
		
	/*	for (int i = 0; i < 5; i++) 
		{
			for (int j = 0; j<6;j++)
			{
				if(game.board[i][j]!=-1) continue;
				
				game.board[i][j] = minRole();
				int v = max(game).utility;
				if(v<minCVT.utility)
				{
					minCVT.utility=v;
					minCVT.row = i;
					minCVT.col = j;
				}
				game.board[i][j] = -1;
				
			}
		}*/
                
                ArrayList<Grid> blankCell = getEmptyBoard(game);
                for(int i=0; i<blankCell.size(); i++)
                {
                    Grid grid = blankCell.get(i);
                    game.board[grid.row][grid.col]=minRole();
                    int v = max(game).utility;
                    //System.out.println("vmin: "+v +"util: "+minCVT.utility);
                    //System.out.println("i : "+i+ "size : "+ blankCell.size());
                    if(v<minCVT.utility)
                    {
                        minCVT.utility = v;
                        minCVT.row = grid.row;
                        minCVT.col = grid.col;
                    }
                    game.board[grid.row][grid.col]=-1;
                }
		
		return minCVT;
			
	}
	
	private int minRole()
	{
		if(role==0)return 1;
		else return 0;
	}

	class CellValueTuple
	{
		int row,col, utility;
		public CellValueTuple() {
			// TODO Auto-generated constructor stub
			row =-1;
			col =-1;
		}
	}
        
        ArrayList<Grid> getEmptyBoard(TickTackToe tttGame)
        {
            ArrayList<Grid> list = new ArrayList<Grid>();
            for(int i=0;i<tttGame.col;i++)
            {
                for(int j=tttGame.row-1;j>=0;j--)
                {   if(tttGame.board[j][i]!=-1) 
                        continue;
                    else
                        {
                            Grid cell = new Grid();
                            cell.row=j;
                            cell.col=i;
                            list.add(cell);
                            break;
                        }
                }
            }
            return list;
            
        /*    ArrayList<Grid> empty = new ArrayList<Grid>();
            
            for(int c=0;c<game.col;c++){
                for(int r=game.row-1;r>=0;r--){
                    
                    if(game.board[r][c]!=-1) 
                        continue;
                    
                    else{
                        Grid cell= new Grid();
                        cell.row=r;
                        cell.col=c;
                        empty.add(cell);
                        break;
                    }
                }
            }
            return empty;
            */
        }
        
        class Grid
        {
            int row;
            int col;
        /*    public void Grid(int a, int b)
            {
                row = a;
                col = b;
            }
            */
        }


}
