/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package States;
import Logic.*;

/**
 *
 * @author ze1
 */
public abstract class StateAdapter implements IState {
    
    protected GameData gameData;
    protected Scond StatEnum;
    
    public StateAdapter(GameData gameData){
        this.gameData = gameData;
    }
    
    public GameData getGameData(){
        return gameData;
    }
    
    @Override
    public Scond getScond(){
        return StatEnum;
    }

    @Override
    public IState Finish(){
        return this;
    }

    @Override
    public IState Play(int x, int y){
        return this;
    }

    @Override
    public IState StartGame(){
        return this;
    }

    @Override
    public IState askInfo(String name, char shape){
        return this;
    }
    
    
    
    
    
    
    
}
