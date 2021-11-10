/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import GameLogic.Game;
import java.util.Scanner;

/**
 *
 * @author ze1
 */
public class UITextBase {
    Game game;
    Boolean EndGame;
    
    public UITextBase(Game game) {
        this.game = game;
        this.EndGame = false;
    }
    
    public void run(){
        
        while(this.EndGame != true){
            System.out.println("_______________.:-+^^+-:._______________");
            System.out.println(this.game.getSystemMsg());
        switch(this.game.getStateEnum()){
            case WGS:
                UI_WaitGameStart();
                break;
            case WFF:
                UI_WaitFirstFase();
                break;
            case WBD:
                UI_WaitBlackDraw();
                break;
            case WE:
                UI_WaitEnd();
                break;
        }
        }
    }
    
    private void UI_WaitGameStart(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo!\n\n(1) Começar Joga\n(2) Terminar\n");
        int opt;
        try{
            String opt1 = sc.nextLine().trim();
            opt = Integer.parseInt(opt1);
        } catch(Exception e){
            System.out.println("Opcao errada! [ERRO - " + e +"]");
            opt = -1;
        }
        
        
        switch(opt){
            case 1:
                this.game.startGame();
                break;
            case 2:
                this.EndGame = true;
                break;
            default:
                System.out.println("Opçao Invalida");
        }
        
    }
    
    private void UI_WaitFirstFase(){
        Scanner sc = new Scanner(System.in);
        System.out.println(this.game.getGameInfo());
        System.out.print("(1) Apostar!\n(2) Retirar Bola!\n(3) Terminar Jogo.\n");
        int opt;
        String opt1;
        try{
            opt1 = sc.nextLine().trim();
            opt = Integer.parseInt(opt1);
        } catch(Exception e){
            System.out.println("Opcao errada! [ERRO - " + e +"]");
            opt = -1;
        }
        
        switch(opt){
            case 1:
                System.out.print("Valor a apostar:");
                try{
                    opt1 = sc.nextLine().trim();
                    opt = Integer.parseInt(opt1);
                    } catch(Exception e){
                        System.out.println("Opcao errada! [ERRO - " + e +"]");
                        opt = 0;
                    }
                this.game.Bet(opt);
                break;
            case 2:
                this.game.Draw();
                break;
            case 3:
                this.game.EndGame();
                break;
            default:
                System.out.println("Opçao Invalida");
        }
    }
    
    private void UI_WaitBlackDraw(){
        Scanner sc = new Scanner(System.in);
        System.out.println(this.game.getGameInfo());
        System.out.print("(1) Perder 1 ponto\n(2) Retirar 2 bolas Aleatorias\n");
        int opt;
        try{
            String opt1 = sc.nextLine().trim();
            opt = Integer.parseInt(opt1);
        } catch(Exception e){
            System.out.println("Opcao errada! [ERRO - " + e +"]");
            opt = -1;
        }
        
        switch(opt){
            case 1:
                this.game.RemovePoints();
                break;
            case 2:
                this.game.RemoveRandom();
                break;
            default:
                System.out.println("Opçao Invalida");
        }
    }
    
    private void UI_WaitEnd(){
        Scanner sc = new Scanner(System.in);
        System.out.println(this.game.getGameInfo());
        System.out.print("Terminou o jogo!\nPressione enter...");
        String opt1 = sc.next();
        
        this.game.EndGame();
    }
}
