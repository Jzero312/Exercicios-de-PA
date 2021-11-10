/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ze1
 */
public class GameData {
    private List<Player> Players;
    private int PlayerTurntoPlay;
    private Player[][] Board;
    private int BoardLimits;
    
    public GameData(int Bsize){
        this.BoardLimits = Bsize;
        this.Players = new ArrayList<>();
        this.PlayerTurntoPlay = 0;
        Board = new Player[Bsize][Bsize];
    }
    
    public void setBoardLimits(){
        this.BoardLimits = this.getNPlayers() + 1;
        this.Board = new Player[BoardLimits][BoardLimits];
    }
    
    public Boolean addPlayer(String name, char shape){
        if(name == null || shape == ' ')
            return false;
        this.Players.add(new Player(name,shape));
        return true;
    }
    
    public char getShapeFromActualPlayer(){
        return this.Players.get(this.PlayerTurntoPlay).getShape();
    }
    
    public String getNameFromActualPlayer(){
        return this.Players.get(this.PlayerTurntoPlay).getName();
    }
    
    public Boolean hasPiecesToPlay(){
        char c = this.Players.get(this.PlayerTurntoPlay).getShape();
        int count = 0;
        for(int i = 0; i<this.BoardLimits;i++){
            for(int j = 0; j<this.BoardLimits; j++){
                if(this.Board[i][j] != null){
                if(Character.compare(c, this.Board[i][j].getShape()) == 0) count++;
                }
                if(count == this.BoardLimits)return false;
            }
        }
        return true;
    }
    
    public char getCharOnBoard(int x, int y){
        if(this.Board[x][y] == null)
            return ' ';
        return this.Board[x][y].getShape();
    }
    
    public void setNextPlayerTurn(){
        this.PlayerTurntoPlay++;
        if(this.PlayerTurntoPlay > this.Players.size() - 1)
            this.PlayerTurntoPlay = 0;
    }
    
    public int getPlayerTurntoPlay(){
        return this.PlayerTurntoPlay;
    }
    
    public int getNPlayers(){
        return this.Players.size();
    }
    
    public Boolean canPlayIn(int x, int y) {
        if(x < 0 || x >= this.BoardLimits || y < 0 || y >= this.BoardLimits)
            return false;
        return Board[x][y]==null;
    }
    
    public void Play(int x, int y) {
        Board[x][y] = Players.get(this.PlayerTurntoPlay);
    }
    
    public Boolean GameFinish(char shape){ //se o tabuleiro for d 4x4 tem que ter 4 peças para ganhar
        int size = this.BoardLimits;
        int count = 0;
        int countC = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(this.Board[i][j] != null)
                    if(Character.compare(this.Board[i][j].getShape(),shape) == 0) count++;
                if(this.Board[j][i] != null)
                    if(Character.compare(this.Board[j][i].getShape(),shape) == 0) countC++;
            }
            if(count == size || countC == size) return true;
            count = 0;
            countC = 0;
        }
        count = 0;


        //check diagonal right

        for (int i = 0, j= 0; i <size ; i++, j++) {
            if(this.Board[i][j] != null)
            if (Character.compare(this.Board[i][j].getShape(),shape) == 0) count++;
          
        }
                
        if(count == size) return true;
        count = 0;
        //check diagonal left
        for (int i = size-1, j= 0; j < size ; i--, j++) {
            if(this.Board[i][j] != null)
            if (Character.compare(this.Board[i][j].getShape(),shape) == 0) count++;
          
        }
        return count == size;


    
    }
    
    public Boolean CanRemovePiece(int x, int y) {
        if(x < 0|| y < 0 || x>= this.BoardLimits || x>=this.BoardLimits)
            return false;
        if(Board[x][y] == null) return false;
        return (Character.compare(Board[x][y].getShape(), this.getShapeFromActualPlayer()) == 0);
    }
    
    public void RemovePiece(int x, int y) {
        Board[x][y] = null;
    }
    
    
    
    
    
    
    
}
