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
public class GroundFloor extends StateAdapter {
    
    public GroundFloor(ElevatorData elevator){
        super(elevator);
    }

    @Override
    public IState Down() {
        return this;
    }

    @Override
    public IState Up() { //o estado muda para o primeiro andar
        return new FirstFloor(getElevator());
    }

    @Override
    public IState Lock() { //o estado passa a blockeado
        return new Locked(getElevator(), this);
    }
    
        @Override
    public String toString() {
        return "Elevador R/C!"; //To change body of generated methods, choose Tools | Templates.
    }
    

    
}
