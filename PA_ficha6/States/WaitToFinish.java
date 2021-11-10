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
public class WaitToFinish extends StateAdapter {

    public WaitToFinish(GameData gameData) {
        super(gameData);
        this.StatEnum = Scond.WTF;
    }

    @Override
    public IState Finish() {
        
        return new WaitForNames(new GameData(3));
    }
    
    
    
    
}
