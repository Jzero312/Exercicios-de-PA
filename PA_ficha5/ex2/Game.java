
package ex2;


public class Game {
    private IState iState;
    private GameData gameData;
    
    public Game(){
        gameData = new GameData();
        iState = new SDrawPiece(gameData); 
    }
    
    public Boolean EndGame(){
        return gameData.getGameEnd();
    }
    
    public void setState(IState iState){
        this.iState = iState;
    }
    
    //------estados------
    public void Draw() {
        setState(iState.Draw());
    }

    @Override
    public String toString() {
      return this.gameData.toString();
    }
    
    
    
    
}
