package bowling.approvals;

import java.util.ArrayList;

public class CompleteFrame implements Frame {
    private int frameIndex;
    public ArrayList<Integer> rolls;
    private Integer frameSum;

    public CompleteFrame(int frameIndex, ArrayList<Integer> rolls) {
        this.frameIndex = frameIndex;
        this.rolls = rolls;
    }

    private String getSecondFrameRollString(int index) {
        if (this.rolls.get(index) == 0) return "-";

        return this.rolls.get(index).toString();
    }

    private String getRollString(int index) {
        if (this.rolls.get(index) == 0) return "-";

        return this.rolls.get(index).toString();
    }

    private String getFrameScore(int frameIndex) {
        int rollIndex1 = frameIndex * 2;
        int rollIndex2 = frameIndex * 2 + 1;
        frameSum = this.rolls.get(rollIndex1) + this.rolls.get(rollIndex2);
        return String.format("% 2d", this.rolls.get(rollIndex1) + this.rolls.get(rollIndex2));
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
