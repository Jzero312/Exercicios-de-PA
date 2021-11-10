/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogic.States;

/**
 *
 * @author ze1
 */
public interface IState {
    IState StartGame();
    
    IState Bet(int bet);
    IState Draw();
    
    IState RemovePoints();
    IState RemoveRandom();
    
    IState EndGame();
    
    StateEnum getStateEnum();
}
