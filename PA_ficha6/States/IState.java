/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

/**
 *
 * @author ze1
 */
public interface IState {
    
    IState askInfo(String name, char shape);
    IState StartGame();
    IState Play(int x, int y);
    IState Finish();

    /**
     *
     * @return
     */
    Scond getScond();
    
    
}
