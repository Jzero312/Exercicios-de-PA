/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogic.States;

import GameLogic.GameData;

/**
 *
 * @author ze1
 */
public abstract class StateAdapter implements IState {
    GameData gameData;
    
    public StateAdapter (GameData gameData) {
        this.gameData = gameData;
    }
    
    public GameData getGameData() {
        return this.gameData;
    }

    @Override
    public IState Bet(int bet){
        return this;
    }

    @Override
    public IState EndGame(){
        return this;
    }

    @Override
    public IState Draw(){
        return this;
    }

    @Override
    public IState RemovePoints(){
        return this;
    }

    @Override
    public IState RemoveRandom(){
        return this;
    }

    @Override
    public IState StartGame(){
        return this;
    }

    @Override
    public abstract StateEnum getStateEnum();
    
    
    
    
}
