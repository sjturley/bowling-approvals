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
        return leftPadTensPlace(totalScore);
    }

    private String leftPadTensPlace(int totalScore) {
        return totalScore > 9 ? String.valueOf(totalScore) : " " + totalScore;
    }

    public int getFrameSum() {
        int frameSum = sumOfRolls();
        if (frameSum == 10 && hasAnotherRoll()) {
            frameSum += this.rolls.get(indexOfFirstRollInNextFrame());
        }
        return frameSum;
    }

    private int sumOfRolls() {
        return this.rolls.get(indexOfFirstRollInFrame()) + this.rolls.get(indexOfSecondRollInFrame());
    }

    @Override
    public String getFrameLine() {
        String firstRoll = getRollString(indexOfFirstRollInFrame());
        String secondRoll = getSecondFrameRollString(indexOfSecondRollInFrame());
        return "|  " + firstRoll + "|" + secondRoll;
    }

    private int indexOfFirstRollInFrame() {
        return frameIndex * 2;
    }

    private int indexOfSecondRollInFrame() {
        return indexOfFirstRollInFrame() + 1;
    }

    private int indexOfFirstRollInNextFrame() {
        return indexOfFirstRollInFrame() + 2;
    }

    @Override
    public String getScoreBox() {
        String score = getFrameScore();
        if (sumOfRolls() == 10 && !hasAnotherRoll()) {
            score = "  ";
        }
        return "|  " + score + " ";
    }

    private boolean hasAnotherRoll() {
        return this.rolls.size() > indexOfFirstRollInNextFrame();
    }
}
