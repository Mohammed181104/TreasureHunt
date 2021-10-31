package com.company;


import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final String[][] board = new String[10][10];
    public static Random random = new Random();

    static void board(){
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
    static void cheatBoard(){
        // For checking contents of grid. NOT MEANT FOR PLAYERS
        for (int i = 0; i< 10; i++){
            for (int j = 0; j<10; j++){
                System.out.print("[" + board[i][j] + "] ");
            }
            System.out.println(" ");
        }
    }
    static void playerBoard(){
        // For checking contents of grid. FOR PLAYERS
        for (int i = 0; i< 10; i++){
            for (int j = 0; j<10; j++){
                if (board[i][j].equals("X")) {
                    System.out.print(" " + board[i][j] + " ");
                }else{
                    System.out.print("[ ]");
                }
            }
            System.out.println(" ");
        }
    }
    static void boardItems(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int coinFlip = random.nextInt(7);
                if (coinFlip == 0 || coinFlip == 1 || coinFlip == 2) {
                    int coins = random.nextInt(200)+1;
                    board[i][j] = String.valueOf(coins);
                }else if (coinFlip == 3) {
                    board[i][j] = "M";
                }else if (coinFlip == 4 || coinFlip == 5){
                    board[i][j] = "R";
                }else{
                    board[i][j] = "0";
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int money = 0;
        board();
        // Assigns items(coins, monsters etc.) to the grid
        boardItems();

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
                if(board[coOrdX][coOrdY].equals("M")) {
                    System.out.println("You got trapped by a monster");
                    break;
                }else if (board[coOrdX][coOrdY].equals("R")){
                    System.out.println("You have encountered a group of pirates!");
                    if (money > 300){
                        int stolen = random.nextInt(75)+100;
                        System.out.println("The pirates have stolen " + stolen + " coins");
                        money -= stolen;
                    }else if((money - 75) <= 0){
                        System.out.println("The pirates have taken everything!!");
                        money = 0;
                        break;
                    }else{
                        System.out.println("The pirates stole 75 coins");
                        money -= 75;
                    }
                }else{
                    money += Integer.parseInt(board[coOrdX][coOrdY]);
                    System.out.println("You got " + board[coOrdX][coOrdY] + " coin(s)!");
                }
            }else if(board[coOrdX][coOrdY].equals("X")) {
                System.out.println("You have dug up this spot before, try again.");
            }else{
                System.out.println("Unlucky, there was nothing there, try again.");
            }
            board[coOrdX][coOrdY] = "X";
            System.out.println("You have " + money + " coins.");
            playerBoard();

        }
        System.out.println("GAME OVER");
        System.out.println("You had " + money + " coins.");
    }
}
