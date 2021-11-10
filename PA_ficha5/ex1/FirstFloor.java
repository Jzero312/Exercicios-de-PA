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
public class FirstFloor extends StateAdapter {
    
     public FirstFloor(ElevatorData elevator){
        super(elevator);
    }

     @Override
    public IState Down() {
        if(getRandom(1,100) < 25){
            return new Locked(getElevator(), this);
        }
        return new GroundFloor(getElevator());
    }

     @Override
    public IState Up() { //o estado muda para o primeiro andar
        if(getRandom(1,100) < 50){
            return new Locked(getElevator(), this);
        }
        return new SecondFloor(getElevator());
    }

     @Override
    public IState Lock() { //o estado passa a blockeado
        return new Locked(getElevator(), this);
    }
    
     @Override
    public String toString() {
        return "Elevador 1º Andar!"; //To change body of generated methods, choose Tools | Templates.
    }
    

    
}
