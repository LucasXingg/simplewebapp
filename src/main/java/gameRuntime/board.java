package gameRuntime;

public class board {

    private Integer[][] boardLayout;
    private Integer index;
    private Integer currentPlayer;

    public board(Integer index){
        this.index = index;
        this.currentPlayer = 2;
        initBoard();
    }

    private void initBoard(){
        this.boardLayout = new Integer[][] {
            {-1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1,},
            {-1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, -1,},
            {-1, -1, -1, -1, -1, 1, 1, 1, -1, -1, -1, -1, -1,},
            {-1, -1, -1, -1, 1, 1, 1, 1, -1, -1, -1, -1, -1,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1,},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1,},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1,},
            {-1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1,},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1,},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {-1, -1, -1, -1, 2, 2, 2, 2, -1, -1, -1, -1, -1,},
            {-1, -1, -1, -1, -1, 2, 2, 2, -1, -1, -1, -1, -1,},
            {-1, -1, -1, -1, -1, 2, 2, -1, -1, -1, -1, -1, -1,},
            {-1, -1, -1, -1, -1, -1, 2, -1, -1, -1, -1, -1, -1,},
        };
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

    private static Integer[] joinArray(Integer[] array1, Integer[] array2){
        int length = array1.length + array2.length;

        Integer[] result = new Integer[length];
        int pos = 0;
        for (Integer element : array1) {
            result[pos] = element;
            pos++;
        }

        for (Integer element : array2) {
            result[pos] = element;
            pos++;
        }

        return result;
    }

    private static Integer[][] join2DArray(Integer[][] array1, Integer[][] array2){
        int length = array1.length + array2.length;

        Integer[][] result = new Integer[length][];
        int pos = 0;
        for (Integer[] element : array1) {
            result[pos] = element;
            pos++;
        }

        for (Integer[] element : array2) {
            result[pos] = element;
            pos++;
        }

        return result;
    }

    private Integer[][] transBoard(){
        Integer[][] transLayout = new Integer[17][];
        transLayout[0] = this.boardLayout[0];
        for(int i=1; i < 9; i++){
            Integer[] negOne = new Integer[i];
            // create array to fill the front of each line
            for(int j=0; j < i; j++){
                negOne[j] = -1;
            }
            transLayout[2*i-1] = joinArray(negOne, this.boardLayout[2*i-1]);
            transLayout[2*i] = joinArray(negOne, this.boardLayout[2*i]);
        }

        return transLayout;
    }

    private static Integer[] transCoordinate(Integer[] coor){
        Integer[] transCoor = {coor[0], coor[1] + (coor[0] + 1) / 2 };
        return transCoor;
    }

    private static Integer[] inTransCoordinate(Integer[] coor){
        Integer[] inTransCoor = {coor[0], coor[1] - (coor[0] + 1) / 2};
        return inTransCoor;
    }

    private Integer[][] findWalk(Integer[] coor, Integer[][] transBoard_){
        Integer[][] shiftCoors = {{-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}, {1, 1}};
        Integer[][] validCoor = {};
        for(Integer[] shiftCoor: shiftCoors){
            if(transBoard_[coor[0]+shiftCoor[0]][coor[1]+shiftCoor[1]].equals(0)){
                validCoor = join2DArray(validCoor, new Integer[][]{{coor[0]+shiftCoor[0], coor[1]+shiftCoor[1]}});
            }
        }
        return validCoor;
    }

    private Integer[][] findJump(Integer[] coor, Integer[][] transBoard_, Integer[] voidCoor){
        Integer[][] shiftCoors = {{-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}, {1, 1}};
        Integer[][] validCoor = {};
        for(Integer[] shiftCoor: shiftCoors){
            if(transBoard_[coor[0]+shiftCoor[0]][coor[1]+shiftCoor[1]].equals(1) || transBoard_[coor[0]+shiftCoor[0]][coor[1]+shiftCoor[1]].equals(2)){
                if(transBoard_[coor[0]+shiftCoor[0]*2][coor[1]+shiftCoor[1]*2].equals(0)){
                    if(!(voidCoor[0].equals(coor[0]+shiftCoor[0]*2) && voidCoor[1].equals(coor[1]+shiftCoor[1]*2))){
                        validCoor = join2DArray(validCoor, new Integer[][]{{coor[0]+shiftCoor[0]*2, coor[1]+shiftCoor[1]*2}});
                    }
                }
            }
        }
        if(validCoor.length == 0){
            return validCoor;
        } else{
            Integer[][] finalValidCoors = {};
            for(Integer[] coor_:validCoor){
                Integer[][] thisValidCoors = join2DArray(new Integer[][]{{coor_[0],coor_[1]}}, findJump(coor_, transBoard_, coor));
                finalValidCoors = join2DArray(finalValidCoors, thisValidCoors);
            }
            return finalValidCoors;
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
    
    public void makeMove(Integer[] origin, Integer[] dest) throws invalidMoveException{
        if(!currentPlayer.equals(this.boardLayout[origin[0]][origin[1]])){
            throw new invalidMoveException("Chese not in position");
        }
        this.boardLayout[origin[0]][origin[1]] = 0;
        this.boardLayout[dest[0]][dest[1]] = this.currentPlayer;
        switchPlayer();
    }

    public Integer[][] findMove(Integer[] chese) throws invalidMoveException{
        if(this.boardLayout[chese[0]][chese[1]].equals(0) || this.boardLayout[chese[0]][chese[1]].equals(1)){
            throw new invalidMoveException("No chese in location");
        }
        Integer[][] transBoard_ = transBoard();
        Integer[] transChese = transCoordinate(chese);
        Integer[][] validTransMoves = join2DArray(findWalk(transChese, transBoard_), findJump(transChese, transBoard_, transChese));
        Integer[][] validMoves = {};
        for(Integer[] validTransMove: validTransMoves){
            Integer[] validMove = inTransCoordinate(validTransMove);
            validMoves = join2DArray(validMoves, new Integer[][]{{validMove[0], validMove[1]}});
        }
        return validMoves;
    }
}
