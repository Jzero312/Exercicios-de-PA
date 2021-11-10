/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;
import Logic.*;
import States.*;
import java.util.Scanner;

/**
 *
 * @author ze1
 */
public class TextBaseConsole {
    private Game game;
    private Boolean Endgame;
    
    public TextBaseConsole(Game game){
        this.game = game;
        this.Endgame = false;
    }
    
    public void Run(){
        while(!Endgame){ 
            Scond Sui = (Scond)game.getScond();
            switch(Sui){
                 case WFN:
                     UI_WTN();
                    break;
                case WFPP:
                     UI_WFPP();
                     break;
                case WFPR:
                     UI_WFPR();
                    break;
                case WTF:
                     UI_WTF();
                     break;
            }
        }
    }
    
    private void UI_WTN(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\n(1) Add Player\n(2) Start Game\n(3) Leave the game\n");
        
        int opt = sc.nextInt();
        switch(opt){
            case 1:
                String name = getNameFromUser();
                char shape = getShapeFromUser();
                try{
                    this.game.AskInfo(name, shape); //penso que isto podia pertencer ha class Game -> GameData
                }catch(Exception e){
                    System.out.print("Input error!!! -> " + e);
                }
                
                break;
            case 2:
                this.game.StartGame();
                break;
            case 3:
                this.Endgame = true;
                break;
            default:
                System.out.println("Invalid option!");
        }

    }
    
    private String getNameFromUser(){
        System.out.print("Insert Name: ");
        String name;
        Scanner sc = new Scanner(System.in); 
        name = sc.nextLine().trim();
        
        return name;
    }
    
    private char getShapeFromUser(){
        System.out.print("Insert Shape: ");
        char shape;
        Scanner sc = new Scanner(System.in);
            shape = sc.next().trim().toUpperCase().charAt(0);
        
        return shape;
    }
    
    
    
    private void UI_WFPP(){
        int x,y;
        Scanner sc = new Scanner(System.in);
    try{
        System.out.println(this.game.toString());
        System.out.print("Chose Position to [PLAY]\nx: ");
        x = sc.nextInt();
        System.out.print("y:");
        y = sc.nextInt();
    }catch(Exception e){
        System.out.print("Input error!!! -> " + e + "\n");
        x = -1;
        y = -1;
    }    
        
        
        this.game.Play(x, y);  
    }
    
    
    private void UI_WFPR(){
        int x,y;
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println(this.game.toString());
            System.out.print("Chose Position to [DELETE]\nx: ");
            x = sc.nextInt();
            System.out.print("y:");
            y = sc.nextInt();  
        }catch(Exception e){
        System.out.print("Input error!!! -> " + e + "\n");
        x = -1;
        y = -1;
                            }   
          
        
        this.game.Play(x, y);
    }
    
    private void UI_WTF(){
        Scanner sc = new Scanner(System.in);
        System.out.print("   Winner --> " + this.game.getWinnersName() + " <--\n\n             Congrats!!!!\n\n");
        System.out.println("\n\n   Press enter to end game...");
        sc.nextLine();
        this.game.Finish();
    }
}
