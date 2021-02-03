/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bowling.approvals;

import java.util.ArrayList;

public class BowlingGame {
    ArrayList<Integer> rolls = new ArrayList<>();
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
        frames[9] = new TenthFrame();

        int frameIndex = 0;
        int lastScore = 0;
        for(; frameIndex < (rolls.size()) / 2; frameIndex++) {

            // is a spare needs next roll
            FullFrame completeFrame = new FullFrame(frameIndex, rolls, lastScore);
            lastScore += completeFrame.getFrameSum();

            frames[frameIndex] = completeFrame;
        }
        if (frameIndex < (rolls.size() +1) / 2 ) {
            frames[frameIndex] = new PartialFrame(frameIndex, rolls);
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
