/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogic.Balls;

/**
 *
 * @author ze1
 */
public class Ball {
    protected final String Cor;
    
    public Ball(String cor) {
        this.Cor = cor;
    }
    
    public String getCor() {
        return this.Cor;
    }
}
