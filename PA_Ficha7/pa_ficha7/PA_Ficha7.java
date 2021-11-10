/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa_ficha7;

import GameLogic.Game;
import UserInterface.UITextBase;

/**
 *
 * @author ze1
 */
public class PA_Ficha7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game game = new Game();
        UITextBase UI = new UITextBase(game);
        UI.run();
    }
    
}
