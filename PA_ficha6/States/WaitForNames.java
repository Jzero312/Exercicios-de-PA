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
public class WaitForNames extends StateAdapter { //devia ser chamado Menu
    
    public WaitForNames(GameData gameData){
        super(gameData);
        this.StatEnum = Scond.WFN;
    }

    @Override
    public IState askInfo(String name, char shape) { //esta funcao esta um bocado pointless
        //if(this.gameData.getNPlayers() > 2) //limitar o numero de players a 2
         //   return this;
        this.gameData.addPlayer(name, shape);
        return this;
    }

    @Override
    public IState StartGame() { //passa para o M1
        if(this.gameData.getNPlayers()<2)
            return this;
        this.gameData.setBoardLimits();
                
        return new WaitForPiecePlacement(this.getGameData());
    }

    
    
    
    
    
    
    
}
