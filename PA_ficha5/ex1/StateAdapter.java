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
public abstract class StateAdapter implements IState {
    private ElevatorData elevator; //faz d conta
    
    public StateAdapter(ElevatorData elevator) {
        this.elevator = elevator;
    }
    
    public ElevatorData getElevator() {
        return elevator;
    }
    
    @Override
    public IState Up() {
        return this;
    }
    @Override
    public IState Down() {
        return this;
    }
    
    @Override
    public IState Lock() {
        return this;
    }
        
    @Override
    public IState Unlock() {
        return this;
    }
    
    public int getRandom(int min, int max) {
        return (int )(Math.random() * max + min);
    }
}
