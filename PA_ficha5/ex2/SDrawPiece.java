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
public class SDrawPiece extends StateAdapter {
    
    public SDrawPiece(GameData gameData){
        super(gameData);
    }

    @Override
    public IState Draw() {
        
        this.gameData.Drawfirst();
        if(this.gameData.isRed(this.gameData.getHand())){
            return new SDrawSecond(getGameData()); 
        } else {
            this.gameData.addPoints();
            return this;
        }
            
    }
    
    
}
