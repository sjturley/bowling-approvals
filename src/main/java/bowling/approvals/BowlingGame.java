/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bowling.approvals;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    List<Integer> rolls = new ArrayList<>();
    public static final String LINE_HEADER = " ____________________________________________________________\n" +
            "|__1__|__2__|__3__|__4__|__5__|__6__|__7__|__8__|__9__|__10__|\n";
    public static final String LINE_FOOTER = "|_____|_____|_____|_____|_____|_____|_____|_____|_____|______|";

    public String score() {
        String frameRollRecord = "";
        String frameScore = "";

        Frame[] frames = new Frame[10];
        for(int i = 0; i < 9; i++) {
            frames[i] = new NullFrame();
        }
        TenthFrame tenthFrame = new TenthFrame();
        frames[9] = tenthFrame;

        int frameIndex = 0;
        int lastScore = 0;
        for(; rolls.size() >= 2 && frameIndex != 9; frameIndex++) {
            FullFrame completeFrame = new FullFrame(this.rolls, lastScore);
            lastScore += completeFrame.fullFrameDomain.getFrameSum();
            frames[frameIndex] = completeFrame;
            int advance = 2;
            if (completeFrame.isStrike()) {
                advance = 1;
            }
            this.rolls = this.rolls.subList(advance, this.rolls.size());
        }

        if (rolls.size() > 0 && frameIndex != 9) {
            if (rolls.get(0) == 10) {
                FullFrame completeFrame = new FullFrame(this.rolls, lastScore);
                frames[frameIndex] = completeFrame;
            } else {
                frames[frameIndex] = new PartialFrame(this.rolls);
            }
        } else if (rolls.size() > 0) {
            tenthFrame.setRolls(rolls);
            tenthFrame.setLastScore(lastScore);
        }

        for(Frame frame : frames) {
            frameRollRecord += frame.getFrameLine();
            frameScore += frame.getScoreBox();
        }

        return LINE_HEADER +
                frameRollRecord +
                frameScore +
                LINE_FOOTER;
    }

    public void roll(int roll) {
        rolls.add(roll);
    }
}
