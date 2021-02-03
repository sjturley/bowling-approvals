/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bowling.approvals;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameApprovals {
    @Test
    public void scoring() {
        Integer[][] games = {{}, {5}, {0}, {1,2}, {3,4,5,1,7,0}};
        Approvals.verifyAll("", games, array -> {
            BowlingGame bowlingGame = new BowlingGame();
            for(int roll : array) {
                bowlingGame.roll(roll);
            }
            return Arrays.toString(array) + "\n" + bowlingGame.score() + "\n";
        });
    }
}
