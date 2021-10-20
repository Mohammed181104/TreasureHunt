package com.company;


import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final String[][] board = new String[10][10];
    public static Random random = new Random();

    public static void board(){
        //Creates the first board to show players all spaces available
        for (int i = 0; i< 10; i++){
            for (int j = 0; j<10; j++){
                board[i][j] = "[ ]";
                System.out.print(board[i][j]);
            }
            System.out.println(" ");
        }
        System.out.println("This is your board. It is 10 by 10.");
    }
    public static void cheatBoard(){
        // For checking contents of grid. NOT MEANT FOR PLAYERS
        for (int i = 0; i< 10; i++){
            for (int j = 0; j<10; j++){
                System.out.print("[" + board[i][j] + "] ");
            }
            System.out.println(" ");
        }
    }
    public static void playerBoard(){
        // For checking contents of grid. FOR PLAYERS
        for (int i = 0; i< 10; i++){
            for (int j = 0; j<10; j++){
                if (board[i][j].equals("X")) {
                    System.out.print("[" + board[i][j] + "] ");
                }else{
                    System.out.print("[ ]");
                }
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int points = 0;
        board();
        // Assigns items(coins, monsters etc.) to the grid
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int coinFlip = random.nextInt(6);
                if (coinFlip == 1 || coinFlip == 3 || coinFlip == 4) {
                    int coins = random.nextInt(100);
                    board[i][j] = String.valueOf(coins);
                }else if (coinFlip == 2){
                    board[i][j] = "M";
                }else{
                    board[i][j] = "0";
                }
            }
        }

        //cheatBoard();

        // Main game
        while (true) {
            System.out.println("What are your coordinates (Type Y beneath X):");
            int coOrdY = input.nextInt()-1;
            int coOrdX = input.nextInt()-1;
            while(coOrdX>9 || coOrdX<0 || coOrdY>9 || coOrdY<0){
                System.out.println("Invalid coordinates, try again (Type Y beneath X):");
                coOrdX = input.nextInt()-1;
                coOrdY = input.nextInt()-1;
            }
            if (!board[coOrdX][coOrdY].equals("0") && !board[coOrdX][coOrdY].equals("X")) {
                if(board[coOrdX][coOrdY].equals("M")){
                    System.out.println("You got trapped by a monster");
                    break;
                }
                points += Integer.parseInt(board[coOrdX][coOrdY]);
                System.out.println("You got " + board[coOrdX][coOrdY] + " coin(s)!");
            }else if(board[coOrdX][coOrdY].equals("X")) {
                System.out.println("You have dug up this spot before, try again.");
            }else{
                System.out.println("Unlucky, there was nothing there, try again.");
            }
            board[coOrdX][coOrdY] = "X";
            System.out.println("You have " + points + " coins.");
            playerBoard();

        }
        System.out.println("GAME OVER");
        System.out.println("You had " + points + " coins.");
    }
}
