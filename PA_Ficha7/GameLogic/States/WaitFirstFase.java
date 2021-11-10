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
public class WaitFirstFase extends StateAdapter{

    public WaitFirstFase(GameData gameData) {
        super(gameData);
    }

    @Override
    public IState Bet(int bet) {
        if(this.gameData.canBet(bet))
            this.gameData.Bet(bet);
        return this;
    }

    @Override
    public IState EndGame() {
        return new WaitEnd(getGameData());
    }

    @Override
    public IState Draw() {
        this.gameData.Draw();
        if(this.gameData.GameEnd())
            return new WaitEnd(getGameData());
        
        if(!this.gameData.DrawisBlack()){
            this.gameData.WhiteDraw();
            return this;
        } else{
            this.gameData.clearPlay();
            return new WaitBlackDraw(getGameData());
        }
            
            
    }
    
    @Override
    public StateEnum getStateEnum() {
        return StateEnum.WFF;
    }
    
    
    
}
