/*
 * To change this lic e nse header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4solver;

/**
 *
 *this is a course-wise assignment of AI course: level-4, term-1
 * @author DIPU
 */
public class Connect4Solver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Agent human = new HumanTTTAgent("Dipu",1);
		//Agent human = new MinimaxTTTAgent("007");
		Agent machine = new MinimaxTTTAgent("Computer",0);

		System.out.println(human.name+" vs. "+machine.name);
		
                
                
		Game game = new TickTackToe(human,machine);
                //View view= new View((TickTackToe)game);
		game.play();
                
                
                
    }
    
}
