package bowling.approvals;

import java.util.ArrayList;

public class PartialFrame implements Frame {
    private int frameIndex;
    public ArrayList<Integer> rolls;

    public PartialFrame(int frameIndex, ArrayList<Integer> rolls) {
        this.frameIndex = frameIndex;
        this.rolls = rolls;
    }

    private String getSecondFrameRollString(int index) {
        return "_";
    }

    private String getRollString(int index) {
        if (this.rolls.get(index) == 0) return "-";

        return this.rolls.get(index).toString();
    }

    private String getFrameScore(int frameIndex) {
        return "  ";
    }

    @Override
    public String getFrameLine() {
        int rollIndex1 = frameIndex * 2;
        int rollIndex2 = frameIndex * 2 + 1;
        String firstRoll = getRollString(rollIndex1);
        String secondRoll = getSecondFrameRollString(rollIndex2);
        return "|  " + firstRoll + "|" + secondRoll;
    }

    @Override
    public String getScoreBox() {
        String frameScore = getFrameScore(frameIndex);
        return "|  " + frameScore + " ";
    }
}
