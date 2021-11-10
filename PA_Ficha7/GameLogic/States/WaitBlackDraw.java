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
public class WaitBlackDraw extends StateAdapter {

    public WaitBlackDraw(GameData gameData) {
        super(gameData);
    }

    @Override
    public IState RemovePoints() {
        if(this.gameData.hasPoints()){
            this.gameData.RemoveOnePoint();
            return new WaitFirstFase(this.getGameData());
        }
        
        return this;
    }

    @Override
    public IState RemoveRandom() {
        this.gameData.RemoveTwoFromBag();
        return new WaitFirstFase(this.getGameData());
    }

    @Override
    public StateEnum getStateEnum() {
        return StateEnum.WBD;
    }
    
    
    
    
    
    
}
