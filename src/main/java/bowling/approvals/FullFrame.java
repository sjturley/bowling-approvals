package bowling.approvals;

import java.util.ArrayList;

public class FullFrame implements Frame {
    private int frameIndex;
    public ArrayList<Integer> rolls;
    private int lastScore;

    public FullFrame(int frameIndex, ArrayList<Integer> rolls, int lastScore) {
        this.frameIndex = frameIndex;
        this.rolls = rolls;
        this.lastScore = lastScore;
    }

    private String getSecondFrameRollString(int index) {
        if (this.rolls.get(index) == 0) return "-";

        return this.rolls.get(index).toString();
    }

    private String getRollString(int index) {
        if (this.rolls.get(index) == 0) return "-";

        return this.rolls.get(index).toString();
    }

    private String getFrameScore() {
        int totalScore = getFrameSum() + lastScore;
        if (totalScore > 9) {
            return String.valueOf(totalScore);
        }
        return " " + totalScore;
    }

    @Override
    public String getFrameLine() {
        String firstRoll = getRollString(frameIndex * 2);
        String secondRoll = getSecondFrameRollString(frameIndex * 2 + 1);
        return "|  " + firstRoll + "|" + secondRoll;
    }

    @Override
    public String getScoreBox() {
        return "|  " + getFrameScore() + " ";
    }

    public int getFrameSum() {
        return this.rolls.get(frameIndex * 2) + this.rolls.get(frameIndex * 2 + 1);
    }
}
