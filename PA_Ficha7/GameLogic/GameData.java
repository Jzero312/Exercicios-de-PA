/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogic;

import GameLogic.Balls.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ze1
 */
public class GameData {
    private final List <Ball> Bag;    //saco inicial
    private final List <Ball> Points; //pontos do utilizador
    private final List <Ball> Bet;    //a aposta
    private final List <Ball> Draw;   //as bolas sacadas do saco inicial
    
    private String SystemMsg;
    private Boolean GameEnd;
    
    public GameData(){
        Draw = new ArrayList<>();
        Bag = new ArrayList<>();
        Points = new ArrayList<>();
        Bet = new ArrayList<>();
        
        SystemMsg = "Jogo Iniciado";
        GameEnd = false;
        
        FillBag(10);       
    }
    
    private void FillBag(int nBalls) {
        for(int i = 0; i < nBalls; i++){
            Bag.add(new WhiteBall());
            Bag.add(new BlackBall());
        }
    }
    
    public Boolean canBet(int bet) {
        if (bet > 0 && bet <= Points.size()){
            return true;
        }
        if (!Bet.isEmpty()){
            SystemMsg = "Já possui uma aposta!";
            return false;
        }
            this.SystemMsg = "["+bet+"] Aposta invalida!";
            return false;
    }
    
    public void Bet(int bet) {
        for(int i = 0; i<bet; i++) {
            Bet.add(Points.get(i)); 
        }
        Points.removeAll(Bet);
        SystemMsg = "["+bet+"] Aposta Realizada!";
    }
    
    public void Draw(){
        if(Bag.isEmpty()){
            this.GameEnd = true;
            SystemMsg = "O jogo terminou, nao possui mais bolas!";
        }else if(Bag.size() == 1){
            this.GameEnd = true;
            if(Bag.get(0).getCor().compareTo("Black") == 0){
                SystemMsg = "A ultima Bola é preta!";
                Bag.clear();
            }else{
                SystemMsg = "Aultima Bola é branca!";
                Points.add(Bag.get(0));
                Bag.clear();
            }
        }else{
        int aux = getRandom(0,Bag.size());
        Draw.add(Bag.get(aux));
        Bag.remove(aux);
       
        SystemMsg = "Retirou uma bola " + Draw.get(0).getCor() + " do saco!";
        }
    }
    
    public Boolean DrawisBlack(){
        return Draw.get(0).getCor().compareTo("Black") == 0;
    }
    
    private int getRandom(int min, int max) {
        return (int)(Math.random()*max+min);
    }
    
    public void WhiteDraw() {
        SystemMsg += "\nA Bola foi adicionada à pontuaçao!";
        
        if(Bet.isEmpty()){
            Points.add(Draw.get(0));
            Draw.clear();           
        } else{
            int aux = RemoveRandomFromBag(Bet.size(), "Black");
            for(Ball e : Bet){
                Points.add(e);
            }
            Points.add(Draw.get(0));
            clearPlay();
            SystemMsg += "\nAposta ganha!!\nForam removidas " + aux + " bolas pretas";
        }
        
        
    }
    
    public void clearPlay(){
            Bet.clear();
            Draw.clear();
    }
    
    public Boolean GameEnd(){
        return this.GameEnd;
    }
    
    private int RemoveRandomFromBag(int nBet, String color) {
        int max = Bag.size();
        Set <Integer> aleatorios = new HashSet<>();
        List <Ball> aux = new ArrayList<>();
        
        if(nBet > max)
            nBet = max;       

        if(nBet == max){
            for(int i = 0; i<nBet; i++){
                aleatorios.add(i);
            }
        }
        else{
        while(nBet != aleatorios.size()){ //este ciclo fica infinito quando Bag.size() == 2 *RESOLVIDO era porque o getRandom é [x,y[
            aleatorios.add(getRandom(0,max)); 
        }
        }
        for(Integer i: aleatorios){
           if(Bag.get(i).getCor().compareTo(color)==0)
               aux.add(Bag.get(i));
        }
        if(!aux.isEmpty()){
            for(Ball e : aux)
                Bag.remove(e);
        }   
        return aux.size();
    }
    
    public Boolean hasPoints(){
        if(Points.isEmpty()){
            this.SystemMsg = "Nao possui pontos!!";
            return false;
        }
            
        return true;
    }
    
    public void RemoveOnePoint(){
        Points.remove(0);
    }
    
    public void RemoveTwoFromBag(){
        if(Bag.size() == 1){
            int aux = RemoveRandomFromBag(2, "White");
            this.SystemMsg = "Só pussui uma bola no saco!!\n";
            if(aux == 0){
                this.SystemMsg += "E nao foi removida!!";
            }else
                this.SystemMsg += "E foi removida...";
        }else{
        
        int aux = RemoveRandomFromBag(2, "White");
        this.SystemMsg = "Foram removidas " + aux + " bolas brancas!";    
        }
    }

    public String getSystemMsg(){
        return this.SystemMsg;
    }
    
    public int getFinalPoints(){
            return Points.size() + Bet.size();
    }
    
    public String getGameInfo(){
        String aux;
        aux = "________________________________________";
        aux += "\nNº Bolas no Saco: " + this.Bag.size();
        aux += "\nNº Pontos: " + this.Points.size();
        aux += "\nNº Bolas apostadas:" + this.Bet.size();
        aux += "\n________________________________________";
        return aux;
    }
}
