
package ex2;

import java.util.Scanner;


public class UI {
    Game game;
    Boolean EndGame;
    
    public UI(Game game){
        this.game = game;
        EndGame = false;
    }
    
    public void Run() {
        Scanner sc = new Scanner(System.in);
        char opt;
        while(GameEnd()){
            
            System.out.print("\n(D) Draw;\n(L) Leave;\n");
            opt = sc.next().trim().toUpperCase().charAt(0);
            
            switch(opt){
                case 'D':
                    game.Draw();
                    break;
                case 'L':
                    EndGame = true;
                    return;
            }
            
            System.out.print(game.toString());
            
        }
       
    }
    
    private Boolean GameEnd(){
        return (game.EndGame() == false && EndGame == false);
    }
}
