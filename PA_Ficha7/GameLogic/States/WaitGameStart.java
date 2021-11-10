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
public class WaitGameStart extends StateAdapter{
    
    public WaitGameStart(GameData gameData) {
        super(gameData);
    }

    @Override
    public IState StartGame() {
        return new WaitFirstFase(getGameData());
    }
    
    @Override
    public StateEnum getStateEnum() {
        return StateEnum.WGS;
    }
    
}
