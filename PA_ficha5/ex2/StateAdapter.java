/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

/**
 *
 * @author ze1
 */
public abstract class StateAdapter implements IState {
    GameData gameData;
    
    public StateAdapter(GameData gameData){
        this.gameData = gameData;
    }
    
    public GameData getGameData(){
        return gameData;
    }

    @Override
    public IState Draw(){
        return this;
    }


    
    
}
