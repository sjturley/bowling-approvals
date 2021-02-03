package bowling.approvals;

import java.util.List;

public class PartialFrame implements Frame {
    public List<Integer> rolls;

    public PartialFrame(List<Integer> rolls) {
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
        int rollIndex1 = 0;
        int rollIndex2 = 1;
        String firstRoll = getRollString(rollIndex1);
        String secondRoll = getSecondFrameRollString(rollIndex2);
        return "|  " + firstRoll + "|" + secondRoll;
    }

    @Override
    public String getScoreBox() {
        String frameScore = getFrameScore(0);
        return "|  " + frameScore + " ";
    }
}
