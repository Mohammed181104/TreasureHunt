package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static String[][] board = new String[10][10];


    public static void board(){
        for (int i = 0; i< 10; i++){
            for (int j = 0; j<10; j++){
                board[i][j] = "[ ]";
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
        System.out.println("This is your board.");


    }



    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        //System.out.println("How wide is your board?");
        //int width = input.nextInt();
        //System.out.println("How tall is your board?");
        //int height = input.nextInt();
        board();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int board[i][j] = random.nextInt(100);

            }
        }




    }
}
