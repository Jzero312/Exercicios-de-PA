/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.util.Scanner;

/**
 *
 * @author ze1
 */
public class Interface {
    Elevator elevator;
    Boolean sair = false;
    
    public Interface(Elevator elevator) {
        this.elevator = elevator;
    }
    
    public void Run() {
        Scanner s = new Scanner(System.in);
        while(!sair){
            System.out.println("Actual State: " + elevator.toString());
            System.out.println("Chose Option:\n(U) Go Up\n(D) Go Down\n(K) Insert Key\n(L) Leave\n");
            
 
            char op = s.next().trim().toUpperCase().charAt(0);
        
            
            switch(op){
                case 'U':
                    elevator.Up();
                    break;
                case 'D':
                    elevator.Down();
                    break;
                case 'K':
                    elevator.Unlock();
                    break;
                case 'L':
                    sair = true;
                    break;
            
            }
        }
    }
}
