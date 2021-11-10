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
public class Elevator {
    private IState state;
    private ElevatorData elevatorData; //faz d conta
    
    public Elevator(){
        elevatorData = new ElevatorData(); //faz d conta
        state = new GroundFloor(elevatorData);
    }
    
    public IState getIState() {
        return state;
    }
    
    private void setState(IState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return state.toString();
    }
    
    //------ Mudar Estado ------
    
    public void Up() {
        setState(state.Up());
    }
    
    public void Down() {
        setState(state.Down());
    }
    
    public void Lock() { //acabei por nao usar
        setState(state.Lock());
    }
    
    public void Unlock() {
        setState(state.Unlock());
    }
    
}
