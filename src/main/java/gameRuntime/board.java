package gameRuntime;

import java.util.Arrays;

public class board {

    private Integer[][] boardLayout;
    private Integer index;
    private Integer currentPlayer;

    public static Integer[][] originLayout = new Integer[][] {
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, 1, 1, 1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, 1, 1, 1, 1, -1, -1, -1, -1, -1, -1},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1},
            {-1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1},
            {-1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1},
            {-1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1},
            {-1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1},
            {-1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
            {-1, -1, -1, -1, -1, 2, 2, 2, 2, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, 2, 2, 2, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, 2, 2, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        };

        //     {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        //     {-1, -1, -1, -1, -1, -1, -1,  1, -1, -1, -1, -1, -1, -1, -1},
        //     {-1, -1, -1, -1, -1, -1,  1,  1, -1, -1, -1, -1, -1, -1, -1},
        //     {-1, -1, -1, -1, -1, -1,  1,  1,  1, -1, -1, -1, -1, -1, -1},
        //     {-1, -1, -1, -1, -1,  1,  1,  1,  1, -1, -1, -1, -1, -1, -1},
        //     {-1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1},
        //     {-1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1, -1},
        //     {-1, -1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1, -1},
        //     {-1, -1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1, -1, -1},
        //     {-1, -1, -1,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1, -1, -1},
        //     {-1, -1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1, -1, -1},
        //     {-1, -1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1, -1},
        //     {-1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1, -1},
        //     {-1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1},
        //     {-1, -1, -1, -1, -1,  2,  2,  2,  2, -1, -1, -1, -1, -1, -1},
        //     {-1, -1, -1, -1, -1, -1,  2,  2,  2, -1, -1, -1, -1, -1, -1},
        //     {-1, -1, -1, -1, -1, -1,  2,  2, -1, -1, -1, -1, -1, -1, -1},
        //     {-1, -1, -1, -1, -1, -1, -1,  2, -1, -1, -1, -1, -1, -1, -1},
        //     {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},

    public board(Integer index){
        this.index = index;
        this.currentPlayer = 2;
        initBoard();
    }

    private void initBoard(){
        this.boardLayout = originLayout;
    }

    private void switchPlayer(){
        switch(this.currentPlayer){
            case 1:
                this.currentPlayer = 2;
                break;
            case 2:
                this.currentPlayer = 1;
                break;
        }
    }

    private static Integer[][] transBoard(Integer[][] boardLayout){
        /*
         * Line up the coordinates
         */
        Integer[][] transLayout = new Integer[19][];
        transLayout[0] = boardLayout[0];
        for(int i=0; i < 9; i++){
            Integer[] negOne = new Integer[i];
            // create array to fill the front of each line
            for(int j=0; j < i; j++){
                negOne[j] = -1;
            }
            transLayout[2*i] = tools.joinArray(negOne, boardLayout[2*i]);
            transLayout[2*i+1] = tools.joinArray(negOne, boardLayout[2*i+1]);
        }
        Integer[] line18 = new Integer[18];
        for(int i=0; i < 18; i++){
            line18[i] = -1;
        }
        transLayout[18] = line18;

        return transLayout;
    }

    private static Integer[] transCoordinate(Integer[] coor){
        /*
         * Find coordinte in Transboard corresponding to coordinate in real board
         */
        Integer[] transCoor = {coor[0], coor[1] + coor[0] / 2 };
        return transCoor;
    }

    private static Integer[] inTransCoordinate(Integer[] coor){
        /*
         * Inverse of transCoordinate
         */
        Integer[] inTransCoor = {coor[0], coor[1] - coor[0] / 2};
        return inTransCoor;
    }

    private static Integer[][] findWalk(Integer[] coor, Integer[][] transBoard_){
        Integer[][] shiftCoors = {{-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}, {1, 1}};
        Integer[][] validCoor = {};
        for(Integer[] shiftCoor: shiftCoors){
            if(transBoard_[coor[0]+shiftCoor[0]][coor[1]+shiftCoor[1]].equals(0)){
                validCoor = tools.join2DArray(validCoor, new Integer[][]{{coor[0]+shiftCoor[0], coor[1]+shiftCoor[1]}});
            }
        }
        return validCoor;
    }

    private static Integer[][] findJump(Integer[] coor, Integer[][] transBoard_, Integer[][] voidCoors){
        Integer[][] shiftCoors = {{-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}, {1, 1}};
        Integer[][] validCoors = {};
        for(Integer[] shiftCoor: shiftCoors){
            if(transBoard_[coor[0]+shiftCoor[0]][coor[1]+shiftCoor[1]].equals(1) || transBoard_[coor[0]+shiftCoor[0]][coor[1]+shiftCoor[1]].equals(2)){
                /* debug line */
                // try{
                //     System.out.println(transBoard_[coor[0]+shiftCoor[0]*2][coor[1]+shiftCoor[1]*2]);
                // }catch(Exception e){
                //     System.out.println("EXCEPTION:");
                //     System.out.println(Arrays.deepToString(coor));
                //     System.out.println(Arrays.deepToString(shiftCoor));
                //     System.out.println(Arrays.deepToString(transBoard_));
                // }
                
                /* end debug */
                if(transBoard_[coor[0]+shiftCoor[0]*2][coor[1]+shiftCoor[1]*2].equals(0)){
                    boolean notFound = true;
                    for(Integer[] voidCoor: voidCoors){
                        //check if this point has already been found
                        if(voidCoor[0].equals(coor[0]+shiftCoor[0]*2) && voidCoor[1].equals(coor[1]+shiftCoor[1]*2)){
                            notFound = false;
                        }
                    }
                    if(notFound){
                        validCoors = tools.join2DArray(validCoors, new Integer[][]{{coor[0]+shiftCoor[0]*2, coor[1]+shiftCoor[1]*2}});
                    }
                }
            }
        }
        if(validCoors.length == 0){
            return validCoors;
        } else{
            Integer[][] partialValidCoors = {};
            for(Integer[] coor_:validCoors){
                Integer[][] thisValidCoors = tools.join2DArray(new Integer[][]{{coor_[0],coor_[1]}}, findJump(coor_, transBoard_, tools.join2DArray(voidCoors, validCoors)));
                partialValidCoors = tools.join2DArray(partialValidCoors, thisValidCoors);
            }
            return partialValidCoors;
        }
    }

    public Integer getIndex(){
        return this.index;
    }

    public Integer[][] getBoard(){
        return this.boardLayout;
    }

    public Integer getCurrentPlayer(){
        return this.currentPlayer;
    }
    
    public static Integer[][] makeMove(Integer[][] boardLayout, Integer currentPlayer, Integer[] origin, Integer[] dest) throws invalidMoveException{
        //copy 2d array
        Integer[][] boardLayoutCopy = new Integer[boardLayout.length][boardLayout[0].length];
        for(int i = 0;i < boardLayout.length;i++)
            boardLayoutCopy[i] = Arrays.copyOf(boardLayout[i],boardLayout[i].length);
        // end copy

        if(!currentPlayer.equals(boardLayoutCopy[origin[0]][origin[1]])){
            throw new invalidMoveException("Chese not in position");
        }
        boardLayoutCopy[origin[0]][origin[1]] = 0;
        boardLayoutCopy[dest[0]][dest[1]] = currentPlayer;
        return boardLayoutCopy;
    }

    public void  makeMove(Integer[] origin, Integer[] dest) throws invalidMoveException{
        this.boardLayout = makeMove(this.boardLayout, this.currentPlayer, origin, dest);
        switchPlayer();
    }

    public static Integer[][] findMove(Integer[][] boardLayout, Integer[] chese) throws invalidMoveException{
        /*
         * boardLayout: no nees to pretrans the board
         * chese: coordinates of chess
         */
        if(boardLayout[chese[0]][chese[1]].equals(0) || boardLayout[chese[0]][chese[1]].equals(-1)){
            throw new invalidMoveException("No chese in location");
        }
        Integer[][] transBoard_ = transBoard(boardLayout);
        Integer[] transChese = transCoordinate(chese);
        Integer[][] validTransMoves = tools.join2DArray(findWalk(transChese, transBoard_), findJump(transChese, transBoard_, new Integer[][]{transChese}));
        Integer[][] validMoves = {};
        for(Integer[] validTransMove: validTransMoves){
            Integer[] validMove = inTransCoordinate(validTransMove);
            validMoves = tools.join2DArray(validMoves, new Integer[][]{{validMove[0], validMove[1]}});
        }
        return validMoves;
    }

    public Integer[][] findMove(Integer[] chese) throws invalidMoveException{
        Integer[][] returnBoard;
        returnBoard = findMove(this.boardLayout, chese);
        return returnBoard;
    }

    public static void drawBoard(Integer[][] boardLayout, boolean fullBoard){
        int count = 0;
        for(Integer[] row:boardLayout){
            if(!(count % 2 == 1) && !fullBoard){
                System.out.print(" ");
            }
            for(Integer element:row){
                switch(element){
                    case -1:
                        if(fullBoard){
                            System.out.print("-1 ");
                        }else{
                            System.out.print("  ");
                        }
                        break;
                    default:
                        System.out.print(" ");
                        System.out.print(element);
                        if(fullBoard){
                            System.out.print(" ");
                        }
                }
            }
            System.out.println("");
            count++;
        }
        System.out.println("");
    }

    public void drawBoard(boolean fullBoard){
        drawBoard(this.boardLayout, fullBoard);
    }

    public void drawBoard(){
        this.drawBoard(false);
    }

    public int isWin(){
        Integer[][] p1Home = new Integer[][]{{14,5},{14,6},{14,7},{14,8},{15,6},{15,7},{15,8},{16,6},{16,7},{17,7}};
        Integer[][] p2Home = new Integer[][]{{1,7},{2,6},{2,7},{3,6},{3,7},{3,8},{4,5},{4,6},{4,7},{4,8}};
        for(Integer[] coor:p1Home){
            if(!(this.boardLayout[coor[0]][coor[1]] == 2)){
                break;
            }
            if(coor[0].equals(16) && coor[1].equals(6)){
                return 1;
            }
        }
        for(Integer[] coor:p2Home){
            if(!(this.boardLayout[coor[0]][coor[1]] == 2)){
                break;
            }
            if(coor[0].equals(0) && coor[1].equals(6)){
                return 2;
            }
        }
        return 0;
    }
}
