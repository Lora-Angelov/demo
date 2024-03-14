package com.example.demo;
import java.util.HashSet;

public class Sudoku {

    private static final int gridSize = 9;

    //Method to display the grid in the console
    public static void displayGrid(int[][] grid) {
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                System.out.print(grid[row][col]);
                if (col == 2 || col == 5) {
                    System.out.print(" | ");
                } else if (col < 8) {
                    System.out.print(" ");
                }
            }
            if (row == 2 || row == 5) {
                System.out.println("\n------+-------+------");
            } else if (row < 8) {
                System.out.println();
            }
        }
    }

    //Method to check if a certain number can be placed in a given cell
    /*public static boolean canPlaceNumber(int[][] grid, int row, int col, int number) {
        //Check the row
        for(int i = 0; i < gridSize; i++) {
            if(grid[row][i] == number) {
                return false;
            }
        }

        //Check the column
        for(int j = 0; j < gridSize; j++) {
            if(grid[j][col] == number) {
                return false;
            }
        }

        //Check the 3x3 square
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int r = startRow; r < startRow + 3; r++) {
            for(int c = startCol; c < startCol + 3; c++) {
                if(grid[r][c] == number) {
                    return false;
                }
            }
        }
        return true;
    }*/

    public static boolean canPlaceNumber(int[][] grid, int row, int col, int number) {
        final boolean[] canPlace = {true};

        //Thread for row
        Thread checkRow = new Thread(() -> {
            //System.out.println("Row thread starting");
            for (int i = 0; i < gridSize; i++) {
                if (grid[row][i] == number) {
                    canPlace[0] = false;
                }
            }
            //System.out.println("Row thread completed");
        });

        //Thread for column
        Thread checkColumn = new Thread(() -> {
            //System.out.println("Column thread starting");
            for (int i = 0; i < gridSize; i++) {
                if (grid[i][col] == number) {
                    canPlace[0] = false;
                }
            }
            //System.out.println("Column thread completed");
        });

        //Thread for square
        Thread checkSquare = new Thread(() -> {
            //System.out.println("Square thread starting");
            int startRow = row - row % 3;
            int startCol = col - col % 3;
            for (int r = startRow; r < startRow + 3; r++) {
                for (int c = startCol; c < startCol + 3; c++) {
                    if (grid[r][c] == number) {
                        canPlace[0] = false;
                    }
                }
            }
            //System.out.println("Square thread completed");
        });

        //Start threads
        checkRow.start();
        checkColumn.start();
        checkSquare.start();

        //Wait for all to finish
        try {
            checkRow.join();
            checkColumn.join();
            checkSquare.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        return canPlace[0];
    }

    //Method to determine if the starting grid is valid
    public static boolean isValid(int[][] grid) {
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int current_val = grid[i][j];
                if (current_val != 0) {
                    if (!seen.add(current_val + "found in row" + i) ||
                            !seen.add(current_val + "found in column" + j) ||
                            !seen.add(current_val + "found in square" + i / 3 + "-" + j / 3))
                        return false;

                }
            }
        }
        return true;
    }

    //Method to solve the starting grid
    public static boolean solveBoard(int[][] grid) {
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                if(grid[row][col] == 0) {
                    for(int numberToTry = 1; numberToTry <= gridSize; numberToTry++) {
                        if(canPlaceNumber(grid, row, col, numberToTry)) {
                            grid[row][col] = numberToTry;

                            if(solveBoard(grid)) {
                                return true;
                            } else {
                                grid[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}


