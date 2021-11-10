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
public class WaitForPieceRemove extends StateAdapter {

    public WaitForPieceRemove(GameData gameData) {
        super(gameData);
        this.StatEnum = Scond.WFPR;
    }

    @Override
    public IState Play(int x, int y) {
        if(this.gameData.CanRemovePiece(x, y)){
            this.gameData.RemovePiece(x, y);
            return new WaitForPiecePlacement(this.getGameData());
        }
            
        return this;
    }
    
    
}
