package com.example.demo;

import java.util.Random;

public class SudokuBoardGenerator {

    private static final int gridSize = 9;
    private static final Random random = new Random();

    //Generate a new Sudoku board
    public static int[][] generateBoard() {
        int[][] board = new int[gridSize][gridSize];
        if(!fillBoard(board)) {
            throw new IllegalStateException("Failed to generate a valid Sudoku board.");
        }

        return board;
    }

    //Method to fill the board with a valid solution
    private static boolean fillBoard(int[][] board) {
        for (int row = 0; row < gridSize; row ++) {
            for (int col = 0; col < gridSize; col++) {
                if (board[row][col] == 0) {
                    for (int number = 1; number <= gridSize; number++) {
                        if(Sudoku.canPlaceNumber(board, row, col, number)) {
                            board[row][col] = number;
                            if (fillBoard(board)) {
                                return true;
                            } else {
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    //Method to remove digits from the generated board
    public static void removeDigits(int[][] board, int digitsToRemove) {
        int count = 0;
        while (count < digitsToRemove) {
            int row = random.nextInt(gridSize);
            int col = random.nextInt(gridSize);
            if (board[row][col] != 0) {
                board[row][col] = 0;
                count++;
            }
        }
    }
}
