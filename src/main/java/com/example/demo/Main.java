package com.example.demo;

import static com.example.demo.SudokuBoardGenerator.generateBoard;
import static com.example.demo.SudokuBoardGenerator.removeDigits;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {
                { 8, 0, 6, 0, 0, 2, 0, 0, 1 },
                { 2, 0, 0, 0, 8, 4, 9, 0, 3 },
                { 0, 0, 0, 5, 0, 9, 0, 0, 6 },
                { 0, 0, 3, 9, 5, 0, 0, 2, 0 },
                { 0, 7, 1, 4, 2, 0, 0, 0, 0 },
                { 9, 2, 0, 1, 0, 0, 7, 5, 0 },
                { 4, 5, 7, 0, 9, 0, 3, 0, 0 },
                { 0, 6, 0, 0, 0, 0, 8, 9, 5 },
                { 0, 0, 0, 2, 3, 5, 0, 6, 0 }
        };

        Sudoku.displayGrid(grid);

        //Pick a row, column and number and check if it can be placed in that cell
        int row = 0;
        int col = 1;
        int number = 9;

        //Outputs if a number can be placed in a given cell or not
        if (Sudoku.canPlaceNumber(grid, row , col , number)) {
            System.out.println("\n\nNumber " + number + " can be placed at row " + row + " column " + col + ".");
        } else {
            System.out.println("\n\nNumber " + number + " cannot be placed at row " + row + " column " + col + ".");
        }

        //Outputs if a grid is valid or not
        if(Sudoku.isValid(grid)) {
            System.out.println("\nThe grid is valid.");
        } else {
            System.out.println("\nThe grid is not valid.");
        }


        //Outputs if a sudoku can be solved or not
        if(Sudoku.solveBoard(grid)) {
            System.out.println("\nSudoku was solved successfully!\n");
        } else {
            System.out.println("\nSudoku is unsolvable!\n");
        }

        Sudoku.displayGrid(grid);

        //Generate a new sudoku board
        int[][] board = generateBoard();

        //Remove digits to create a new puzzle
                // Easy - 20; Medium - 40; Hard - 60
        removeDigits(board, 40);

        //Print the new puzzle
        System.out.println("\n\nHere is a new sudoku for you to solve!\n");
        Sudoku.displayGrid(board);

        //Check if new sudoku grid is valid
        if(Sudoku.isValid(board)) {
            System.out.println("\n\nThe grid is valid, so you should be able to solve it.");
        } else {
            System.out.println("\n\nThe grid is not valid, please generate a new one.");
        }

        //Solve the new sudoku
        /*if(Sudoku.solveBoard(board)) {
            System.out.println("\nOkay lazy, I've solved it for ya\n");
        } else {
            System.out.println("\nSudoku is unsolvable!\n");
        }

        Sudoku.displayGrid(board);*/
    }
}
