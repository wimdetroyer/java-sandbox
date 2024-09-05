package be.wimdetroyer.javasandbox.jcip.puzzlesolver.fifteenpuzzle;

import be.wimdetroyer.javasandbox.jcip.puzzlesolver.Puzzle;
import be.wimdetroyer.javasandbox.jcip.puzzlesolver.PuzzleSolver;

public class FifteenPuzzleDFSSequentialSolver extends PuzzleSolver<FifteenPuzzlePosition, FifteenPuzzleMove> {


    public FifteenPuzzleDFSSequentialSolver(Puzzle<FifteenPuzzlePosition, FifteenPuzzleMove> puzzle) {
        super(puzzle);
    }

    public static void main(String[] args) {
        var fifteenPuzzle = new FifteenPuzzle();
        var fifteenPuzzleSolver = new FifteenPuzzleDFSSequentialSolver(fifteenPuzzle);
    }
}
