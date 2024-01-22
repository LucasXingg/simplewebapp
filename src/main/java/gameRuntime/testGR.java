package gameRuntime;

import java.util.Arrays;
import java.util.Scanner;

public class testGR {

    public static void main(String[] args) {

        game(0.5, 0.5, 4);

        // board bd = new board(0);
        // bd.drawBoard();

        // AIPlayer AI = new AIPlayer(0.5, 0.5, 2);
        // System.out.println(Arrays.deepToString(AI.nextMove(bd.getBoard())));

        // try {
        //     bd.makeMove(new Integer[]{15, 6}, new Integer[]{13,5});
        //     bd.drawBoard();
        // } catch (invalidMoveException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        // try {
        //     bd.makeMove(new Integer[]{4, 5}, new Integer[]{5,5});
        //     bd.drawBoard();
        // } catch (invalidMoveException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        // try {
        //     bd.makeMove(new Integer[]{13, 5}, new Integer[]{12,5});
        //     bd.drawBoard();
        // } catch (invalidMoveException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        // try {
        //     System.out.println(Arrays.deepToString(bd.findMove(new Integer[]{12,5})));
        // } catch (invalidMoveException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        // try {
        //     System.out.println(Arrays.deepToString(bd.findMove(new Integer[]{15,7})));
        // } catch (invalidMoveException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
    }

    public static void game(double attRate, double defRate, Integer depth){
        board bd = new board(0);
        AIPlayer AI = new AIPlayer(attRate, defRate, depth);
        Scanner scanner = new Scanner(System.in); // 创建Scanner对象并传入标准输入流

        bd.drawBoard();
        
        boolean notFinish = true;
        Integer[][] move;

        while(notFinish){
            System.out.println("-----------------------");
            move = AI.nextMove(bd.getBoard());
            bd.drawBoard();
            try {
                bd.makeMove(move[0], move[1]);
            } catch (invalidMoveException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            bd.drawBoard();

            Integer ori0 = Integer.parseInt(getInput("Chess Line:", scanner));
            Integer ori1 = Integer.parseInt(getInput("Chess Row:", scanner));
            Integer des0 = Integer.parseInt(getInput("Target Line:", scanner));
            Integer des1 = Integer.parseInt(getInput("Target Row:", scanner));

            move[0][0] = ori0;
            move[0][1] = ori1;
            move[1][0] = des0;
            move[1][1] = des1;

            bd.drawBoard();
            try {
                bd.makeMove(move[0], move[1]);
            } catch (invalidMoveException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            bd.drawBoard();

        }

        scanner.close(); // 关闭Scanner对象


    }

    private static String getInput(String ask, Scanner scanner){
        
        
        System.out.print(ask); // 提示用户输入内容
        String input = scanner.next(); // 读取用户输入的字符串

        return input;
    }

}