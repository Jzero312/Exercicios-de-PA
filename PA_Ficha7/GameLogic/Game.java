/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogic;

import GameLogic.States.*;

/**
 *
 * @author ze1
 */
public class Game {
    private GameData gameData;
    private IState iState;
    
    public Game(){
        gameData = new GameData();
        iState = new WaitGameStart(this.gameData);
    }
    
    public void setState(IState iState){
        this.iState = iState;
    }
    
    public String getSystemMsg(){
        return this.gameData.getSystemMsg();
    }
    
    public StateEnum getStateEnum(){
        return this.iState.getStateEnum();
    }
    
    public int getFinalPoints(){
        return this.gameData.getFinalPoints();
    }
    
    public String getGameInfo(){
        return this.gameData.getGameInfo();
    }
    
    //-------------------*----------------
    public void startGame(){
        setState(this.iState.StartGame());
    }
    
    public void Draw(){
        setState(this.iState.Draw());
    }
    
    public void Bet(int bet){
        setState(this.iState.Bet(bet));
    }
    
    public void RemovePoints(){
        setState(this.iState.RemovePoints());
    }
    
    public void RemoveRandom(){
        setState(this.iState.RemoveRandom());
    }
    
    public void EndGame(){
        setState(this.iState.EndGame());
    }
    
}
