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
public class SDrawSecond extends StateAdapter {
    public SDrawSecond(GameData gameData){
        super(gameData);
    }

    @Override
    public IState Draw() {
        this.gameData.DrawSecond();
        
        if(this.gameData.isBlueAndBigger()) {
            this.gameData.SecondStageComplete();
            return new SDrawPiece(getGameData());
        }
        return this;
            
    }
    
    
    
}
