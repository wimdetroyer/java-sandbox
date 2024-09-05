package be.wimdetroyer.javasandbox.jcip.puzzlesolver;

import java.util.Set;

public interface Puzzle<P, M> {

    P initialPosition();
    boolean isGoalPosition(P position);
    Set<M> legalMoves(P position);
    P move(P position, M move);
}
