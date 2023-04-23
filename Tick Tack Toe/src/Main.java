/**
 * Tic Tac Toe game implementation in Java.
 *
 * This program allows two players to play Tic Tac Toe on a 3x3 board using the console.
 * The game continues until one player wins by placing three of their marks in a row, column, or diagonal,
 * or until the board is full and the game ends in a draw.
 *
 * @author [Alister D'souza]
 * @since [23/04/2023]
 *
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /** Initializing a 3x3 Tic Tac Toe board */
        char[][] board = new char[3][3];

        /** Filling up the board with empty spaces */
        for (int row = 0; row<board.length;row++){
            for(int column = 0;column<board[row].length; column++){
                board[row][column] = ' ';
            }
        }

        /** Starting with Player X */
        char player = 'X';

        /** Initializing a boolean variable to track the game status */
        boolean gameOVer = false;
        Scanner sc = new Scanner(System.in);

        while(!gameOVer){
            /** Printing the current state of the board */
            printBoard(board);

            System.out.print(" Player "+player + " enter your row and column : ");
            int row = sc.nextInt();
            int column = sc.nextInt();

            if(board[row][column] == ' '){
                board[row][column] = player;
                gameOVer = hasWon(board, player);
                if(gameOVer){
                    System.out.println("Player "+player +" has Won");
                }else {
                    player = (player=='X') ? 'O': 'X';
                    /*if (player=='X'){
                        player = 'O';
                    }else {
                        player = 'X';
                    } */
                }
            }else {
                System.out.println("Invalid Move Try Again!!");
            }
        }
    }

    /** A function to check if the given player has won the game */
    public static boolean hasWon(char[][] board, char player) {
        /* Check for Row */
        for (int row = 0; row<board.length; row++){
            if(board[row][0]== player && board[row][1]== player && board[row][2] == player){
                return true;
            }
        }

        /* Check for Columns */
        for (int column = 0; column<board[0].length; column++){
            if(board[0][column]== player && board[1][column]== player && board[2][column] == player){
                return true;
            }
        }

        /* Check for diagonal condition */
        if(board[0][0]== player && board[1][1]==player && board[2][2]==player){
            return true;
        }

        if(board[0][2]== player && board[1][1]==player && board[2][0]==player){
            return true;
        }

        return false;
    }

    /** A function to print the current state of the board */
    public static void printBoard(char[][] board) {
        for (int row = 0; row<board.length;row++){
            for (int column = 0;column< board[row].length; column++){
                System.out.print(board[row][column]+" | ");
            }
            System.out.println();
        }
    }
}