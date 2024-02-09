package com.example.demo;

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

    }
}
