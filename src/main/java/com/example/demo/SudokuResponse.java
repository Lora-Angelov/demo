package com.example.demo;

import java.util.List;

public class SudokuResponse {

    private NewBoard newBoard;

    public static class NewBoard {
        private List<Grid> grids;
        private int results;
        private String message;

        public List<Grid> getGrids() {
            return grids;
        }

        public void setGrids(List<Grid> grids) {
            this.grids = grids;
        }

        public int getResults() {
            return results;
        }

        public void setResults(int results) {
            this.results = results;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class Grid {
        List<List<Integer>> value;
        List<List<Integer>> solution;
        String difficulty;

        public List<List<Integer>> getValue() {
            return value;
        }

        public void setValue(List<List<Integer>> value) {
            this.value = value;
        }

        public List<List<Integer>> getSolution() {
            return solution;
        }

        public void setSolution(List<List<Integer>> solution) {
            this.solution = solution;
        }

        public String getDifficulty() {
            return difficulty;
        }

        public void setDifficulty(String difficulty) {
            this.difficulty = difficulty;
        }
    }

    // Getters and Setters for newBoard
    public NewBoard getNewBoard() {
        return newBoard;
    }

    public void setNewBoard(NewBoard newBoard) {
        this.newBoard = newBoard;
    }
}
