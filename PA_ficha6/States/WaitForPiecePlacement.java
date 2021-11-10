/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package States;
import Logic.*;
/**
 *
 * @author ze1
 */
public class WaitForPiecePlacement extends StateAdapter {

    public WaitForPiecePlacement(GameData gameData) {
        super(gameData);
        this.StatEnum = Scond.WFPP;
    }
    
    @Override
    public IState Play(int x, int y) {
        if(this.gameData.canPlayIn(x, y)){            //se pode jogar nessa posicao
            this.gameData.Play(x, y);                 //joga nessa pos  
            if(this.gameData.GameFinish(this.getGameData().getShapeFromActualPlayer())){ //se venceu o jogo -> termina
                return new WaitToFinish(this.getGameData());
            }
            this.gameData.setNextPlayerTurn();   //passa para o proximo jogador
            if(!this.gameData.hasPiecesToPlay()){ //se ñ tem pessas muda para o estado de remover do tabuleiro
                return new WaitForPieceRemove(this.getGameData());
            }
                
        }
        return this;
           
    }
    
}
