package be.wimdetroyer.javasandbox.jcip.puzzlesolver;

import java.util.List;

public class PuzzleSolver<P, M> {

    private final Puzzle<P, M> puzzle;

    public PuzzleSolver(Puzzle<P, M> puzzle) {
        this.puzzle = puzzle;
    }

    public List<M> solve() {
        return List.of();
    }
}
