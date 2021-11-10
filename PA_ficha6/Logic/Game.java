/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;
import States.*;
/**
 *
 * @author ze1
 */
public class Game {
    private GameData gameData;
    private IState iState;
    
    public Game(){
        gameData = new GameData(3);
        iState = new WaitForNames(gameData);
    }
    
    
    
    public void setState(IState iState){
        this.iState = iState;
    }
    
    public void AskInfo(String nome, char shape){
        setState(iState.askInfo(nome, shape));
    }
    
    public void StartGame(){
        setState(iState.StartGame());
    }
    
    public void Play(int x, int y){
        setState(iState.Play(x-1, y-1));
    }
    
    public void Finish(){
        setState(iState.Finish());
    }
    
    public Enum getScond(){
        return iState.getScond();
    }

    @Override
    public String toString() {
        String aux;
        aux = "Player " + this.gameData.getNameFromActualPlayer() + " (" + this.gameData.getShapeFromActualPlayer() +")\n";
        aux += "  ";
        for(int i = 0; i <= this.gameData.getNPlayers(); i++){
            aux += i + 1;
            aux += " ";
        }
        aux += "  \n";
        for(int i = 0; i<this.gameData.getNPlayers()+1; i++){
            aux += i+1;                        //ver se isto ñ da merda
            for(int j = 0; j<this.gameData.getNPlayers()+1; j++){
                aux += " " + this.gameData.getCharOnBoard(i, j);
            }
            aux += "\n";
        }
        return aux;
    }
    
    public String getWinnersName(){
        return this.gameData.getNameFromActualPlayer();
    }
    
    
}
