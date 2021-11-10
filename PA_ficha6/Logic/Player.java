package Logic;

public class Player {
    private final String Name;
    private final char Shape;
    
    public Player(String name, char shape){
        this.Name = name;
        this.Shape = shape;
    }
    
    public String getName(){
        return this.Name;
    }
    
    public char getShape(){
        return this.Shape;
    }
}
