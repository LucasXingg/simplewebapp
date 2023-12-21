package gameRuntime;

import java.util.Arrays;

public class testGR {

    public static void main(String[] args) {
        board bd = new board(0);
        bd.drawBoard();
        try{
            bd.makeMove(new Integer[]{13, 4}, new Integer[]{12,5});
        } catch(Exception e){
            LOG.log(e, "main", "testGR");
        }
        bd.drawBoard();
        try {
            Integer[][] coors = bd.findMove(new Integer[]{13,5});
            System.out.println(Arrays.deepToString(coors));
        } catch (Exception e) {
            LOG.log(e, "main", "testGR");
        }
        
        // LOG.log("This is a test LOG", "main", "testGR");
    }

}