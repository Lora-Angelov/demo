package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.SudokuResponse.NewBoard;
import reactor.core.publisher.Mono;

@RestController
public class SudokuController {
    
    @Autowired
    private SudokuService sudokuService;

    @GetMapping ("/sudoku")
    public Mono<NewBoard> getSudokuPuzzle() {
        return sudokuService.fetchSudokuPuzzle()
            .map(SudokuResponse::getNewBoard);
    }
}
