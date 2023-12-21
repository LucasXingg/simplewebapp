package gameRuntime;

public class gameRT {

    private board[] boards;
    
    public gameRT(){}

    private board findBoard(Integer index){
        for(board bd: this.boards){
            if(bd.getIndex().equals(index)){
                return bd;
            }
        }
        board bd = new board(index);
        System.out.println("LOG: {gameRT.getBoard} bord not found, new board created.");
        return bd;
    }

    // public Integrt[][] findMove(Integer[][] chese, Integer index){
        
    // }

    public board getBoard(Integer index){
        return findBoard(index);
    }
}
