/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

/**
 *
 * @author ze1
 */
public interface IState {
    
        IState Up();
        IState Down();
        IState Lock();
        IState Unlock();
    
}
