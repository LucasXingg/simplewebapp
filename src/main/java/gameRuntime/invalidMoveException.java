package gameRuntime;

public class invalidMoveException extends Exception {
    
    public invalidMoveException(){
        super();
    }

    public invalidMoveException(String message){
        super(message);
    }
}
