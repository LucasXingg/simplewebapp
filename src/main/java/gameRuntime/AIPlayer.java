package gameRuntime;

import java.util.Arrays;

public class AIPlayer {
    
    private double attRate; //The likely AI attack
    private double defRate; //The likely AI defend
    private Integer depth; // depth of searching

    public AIPlayer(double attRate, double defRate, Integer depth){
        this.attRate = attRate;
        this.defRate = defRate;
        this.depth = depth;
    }

    public Integer[][] nextMove(Integer[][] boardLayout){
        Integer[][] bestMove = minMaximum(boardLayout);
        return bestMove;
    }

    private Integer[][] minMaximum(Integer[][] boardLayout){
        double value = Double.NEGATIVE_INFINITY;
        Integer[][] bestMove = new Integer[2][2];
        Integer[][] chesses = findChess(boardLayout, 2);
        for(Integer[] chess: chesses){
            Integer[][] moves = {};
            try{
                moves = board.findMove(boardLayout, chess);
            }catch(Exception e){
                LOG.log(e, "minMaximum", "AIPlayer", "29");
            }
            for(Integer[] move: moves){
                Integer[][] nextBoard = board.originLayout;
                try {
                    nextBoard = board.makeMove(boardLayout, 2, chess, move);
                } catch (Exception e) {
                    LOG.log(e, "minMaximum", "AIPlayer", "36");
                }
                double subValue = this.Bnode(nextBoard, value, this.depth);
                if(subValue > value){
                    value = subValue;
                    bestMove[0] = chess;
                    bestMove[1] = move;
                    String msg = String.join("", "New best choice, value: ", String.valueOf(value), " Move: ", Arrays.deepToString(bestMove));
                    LOG.log(msg, "minMaximum", "AIPlayer");
                }
            }
        }
        return bestMove;
    }

    private double Anode(Integer[][] boardLayout, double parentValue, Integer count){
        /*
         * Max node, going to find max subnode
         * player is 2
         * will return if selfvalue bugger than parentvalue
         * count: depth of tree
         */
        if(count.equals(0)){ // end of iteration
            return eavluation(boardLayout);
        }
        // board.drawBoard(boardLayout, true);
        double value = Double.NEGATIVE_INFINITY;
        Integer[][] chesses = findChess(boardLayout, 2);
        for(Integer[] chess: chesses){
            Integer[][] moves = {};
            try{
                moves = board.findMove(boardLayout, chess);
            }catch(Exception e){
                LOG.log(e, "Anode", "AIPlayer", "66");
            }
            for(Integer[] move: moves){
                Integer[][] nextBoard = board.originLayout;
                try {
                    nextBoard = board.makeMove(boardLayout, 2, chess, move);
                } catch (Exception e) {
                    LOG.log(e, "Anode", "AIPlayer", "73");
                }
                double subValue = this.Bnode(nextBoard, value, count-1);
                if(subValue > value){
                    value = subValue;
                }
                if(value > parentValue){
                    return value;
                }
            }
        }
        return value;
    }

    private double Bnode(Integer[][] boardLayout, double parentValue, Integer count){
        /*
         * Min node, going to find min subnode
         * player is 1
         * will return if selfvalue smaller than parentvalue
         * count: depth of tree
         */
        if(count.equals(0)){ // end of iteration
            return eavluation(boardLayout);
        }
        double value = Double.POSITIVE_INFINITY;
        Integer[][] chesses = findChess(boardLayout, 1);
        for(Integer[] chess: chesses){
            Integer[][] moves = {};
            try{
                moves = board.findMove(boardLayout, chess);
            }catch(Exception e){
                LOG.log(e, "Bnode", "AIPlayer", "104");
            }
            for(Integer[] move: moves){
                Integer[][] nextBoard = board.originLayout;
                try {
                    nextBoard = board.makeMove(boardLayout, 1, chess, move);
                } catch (Exception e) {
                    LOG.log(e, "Bnode", "AIPlayer", "111");
                }
                double subValue = this.Anode(nextBoard, value, count-1);
                if(subValue < value){
                    value = subValue;
                }
                if(value < parentValue){
                    return value;
                }
            }
        }
        return value;
    }

    public double eavluation(Integer[][] boardLayout){
        double selfScore = 0;
        double oppoScore = 0;
        Integer lineCount = 0;
        Integer rowCount;
        for(Integer[] line: boardLayout){
            rowCount = 0;
            for(Integer chess: line){
                if(chess.equals(2)){
                    selfScore += (Math.pow(lineCount, (1+this.attRate))+ Math.abs((7-rowCount))); //pow(a,b) = a^b
                }else if(chess.equals(1)){
                    oppoScore += (Math.pow(18-lineCount, (1+this.defRate))+ Math.abs((7-rowCount)));
                }
                rowCount++;
            }
            lineCount++;
        }

        return (oppoScore/selfScore);
    }

    public static Integer[][] findChess(Integer[][] boardLayout, Integer player){
        Integer[][] chesses = {};
        for(Integer i = 0; i < 18; i++){
            for(Integer j = 0; j < 14; j++){
                if(boardLayout[i][j].equals(player)){
                    chesses = tools.join2DArray(chesses, new Integer[][]{{i, j}});
                }
            }
        }
        return chesses;
    }

}
