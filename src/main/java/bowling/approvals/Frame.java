package bowling.approvals;

import java.util.ArrayList;

public class Frame {
    public ArrayList<Integer> rolls;

    public Frame(int i, ArrayList<Integer> rolls) {
        this.rolls = rolls;
    }

    String getSecondFrameRollString(int index) {
        if (this.rolls.size() <= index) return "_";
        if (this.rolls.get(index) == 0) return "-";

        return this.rolls.get(index).toString();
    }

    String getRollString(int index) {
        if (this.rolls.size() <= index) return " ";
        if (this.rolls.get(index) == 0) return "-";

        return this.rolls.get(index).toString();
    }

    String getFrameScore(int frameIndex) {
        int rollIndex1 = frameIndex * 2;
        int rollIndex2 = frameIndex * 2 + 1;
        if (this.rolls.size() > rollIndex2) {
            return String.format("% 2d", this.rolls.get(rollIndex1) + this.rolls.get(rollIndex2));
        }
        return "  ";
    }

    String getFrameLine(int frameIndex) {
        int rollIndex1 = frameIndex * 2;
        int rollIndex2 = frameIndex * 2 + 1;
        String firstRoll = getRollString(rollIndex1);
        String secondRoll = getSecondFrameRollString(rollIndex2);
        return "|  " + firstRoll + "|" + secondRoll;
    }

    String getScoreBox(int i) {
        return "|  " + getFrameScore(i) + " ";
    }
}
