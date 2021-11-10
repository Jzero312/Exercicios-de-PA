/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

/**
 *
 * @author ze1
 */
public abstract class Piece {
    protected final int Number;
    protected final String Color;
    
    public Piece(String color){
        Number = getRandom(1,4);
        Color = color;
    }
    
    private int getRandom(int min, int max){
        return (int)(Math.random()*max+min);
    }
    
    public String getColor(){
        return Color;
    }
    
    public int getNumber(){
        return Number;
    }

    @Override
    public String toString() {
        return "Number: " + this.Number + "Color: " + this.Color; 
    }
    
    
}
