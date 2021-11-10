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
public class WaitEnd extends StateAdapter{

    public WaitEnd(GameData gameData) {
        super(gameData);
    }

    @Override
    public IState EndGame() {
        return new WaitGameStart(new GameData());
    }
    
    @Override
    public StateEnum getStateEnum() {
        return StateEnum.WE;
    }
    
    
    
    
}
