package be.wimdetroyer.javasandbox.jcip.puzzlesolver.fifteenpuzzle;

import be.wimdetroyer.javasandbox.jcip.puzzlesolver.Puzzle;

import java.util.Set;

public class FifteenPuzzle implements Puzzle<FifteenPuzzlePosition, FifteenPuzzleMove> {

    private final FifteenPuzzlePosition initialPosition;

    public FifteenPuzzle(FifteenPuzzlePosition initialPosition) {
        this.initialPosition = initialPosition;
    }

    @Override
    public FifteenPuzzlePosition initialPosition() {
        return initialPosition;
    }

    @Override
    public boolean isGoalPosition(FifteenPuzzlePosition position) {
        return false;
    }

    @Override
    public Set<FifteenPuzzleMove> legalMoves(FifteenPuzzlePosition position) {
        return Set.of();
    }

    @Override
    public FifteenPuzzlePosition move(FifteenPuzzlePosition position, FifteenPuzzleMove move) {
        return null;
    }
}
