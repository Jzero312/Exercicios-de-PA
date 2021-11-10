
package pa_ficha5;
import ex1.*;
import ex2.*;

public class PA_ficha5 {


    public static void main(String[] args) {
//        Elevator e = new Elevator();
//        Interface Ui = new Interface(e);
//        Ui.Run();

          Game g = new Game();
          UI ui = new UI(g);
          ui.Run();
        
        
    }
    
}
