package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class SudokuService {
    private final WebClient webClient;

    public SudokuService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://sudoku-api.vercel.app").build();
    }

    public Mono<SudokuResponse> fetchSudokuPuzzle() {
        return this.webClient.get()
        .uri("/api/dosuku")
        .retrieve()
        .bodyToMono(SudokuResponse.class);
    }
}
