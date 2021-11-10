
package ex2;

import java.util.ArrayList;
import java.util.List;


public class GameData {
    private int Points;
    private List<Piece> Pieces;
    private Piece Hand;
    private Piece SecondHand;
    private Boolean GameEnd;
    
    public GameData(){
        GameEnd = false;
        Hand = null;
        SecondHand = null;
        Pieces = new ArrayList<>();
        for(int i = 0; i<5; i++){
            Pieces.add(new RedPiece());
            Pieces.add(new BluePiece());
        }
        
        Points = 0;
    }
    
    public void addPoints(){
        Points += Hand.getNumber();
    }
    
    public int getPoints(){
        return Points;
    }
    
    public void Drawfirst(){
        if(Pieces.isEmpty()){
            GameEnd = true;
            return;
        }
        
        Hand = getRandomPiece();
    }
    
    public void DrawSecond(){
        if(Pieces.isEmpty()){
            GameEnd = true;
            return;
        }
        
        SecondHand = getRandomPiece();
    }
    
    public Boolean isRed(Piece piece){
        return piece.getColor().compareTo("Red") == 0;
    }
    
    public Boolean isBlueAndBigger(){
        return SecondHand.getColor().compareTo("Blue") == 0 && SecondHand.getNumber() >= Hand.getNumber();
    }
    
    public void SecondStageComplete(){
        for(int i = 0; i<Hand.getNumber();i++){
            addRandomPiece();
        }
        SecondHand = null;
    }
    
    private void addRandomPiece(){
        if(getRandom(1,100) <= 50)
            Pieces.add(new RedPiece());
        else
            Pieces.add(new BluePiece());
        
    }
    
    public Piece getHand(){
        return Hand;
    }
    
    private Piece getRandomPiece(){
        Piece aux = Pieces.get(getRandom(0,Pieces.size()-1));
        Pieces.remove(aux);
        return aux;
    }
    private int getRandom(int min, int max){
        return (int)(Math.random()*max+min);
    }
    
    public Boolean getGameEnd(){
        return this.GameEnd;
    }
    
    public int getNPieces(){
        return this.Pieces.size();
    }

    @Override
    public String toString() {
        String aux = "Pontos: " + this.Points + " | Nº de Pieces: " + this.Pieces.size() + "\nHand-->" + this.Hand.toString();
        if(this.SecondHand != null)
            aux += "\nSecondHand: " + this.SecondHand.toString();
        return aux; 
    }
    
    
}
