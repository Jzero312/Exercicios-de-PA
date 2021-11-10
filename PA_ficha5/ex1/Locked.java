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
public class Locked extends StateAdapter {
    IState prevState;
     public Locked(ElevatorData elevator, IState prevState){
        super(elevator);
        this.prevState = prevState;
    }


    @Override
    public IState Unlock() { 
        return prevState;
    }

    @Override
    public String toString() {
        return "Elevador Bloqueado!"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
