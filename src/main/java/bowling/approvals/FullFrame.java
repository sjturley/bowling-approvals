package bowling.approvals;

import java.util.ArrayList;
import java.util.List;

public class FullFrame implements Frame {
    public List<Integer> rolls;
    private int lastScore;

    public FullFrame(List<Integer> rolls, int lastScore) {
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
        if (isStrike()) {
            return 10;
        }
        return this.rolls.get(indexOfFirstRollInFrame()) + this.rolls.get(indexOfSecondRollInFrame());
    }

    @Override
    public String getFrameLine() {
        if (isStrike()) {
            return "|   |X";
        }
        String firstRoll = getRollString(indexOfFirstRollInFrame());
        String secondRoll = getSecondFrameRollString(indexOfSecondRollInFrame());
        return "|  " + firstRoll + "|" + secondRoll;
    }

    public boolean isStrike() {
        return this.rolls.get(indexOfFirstRollInFrame()) == 10;
    }

    private int indexOfFirstRollInFrame() {
        return 0;
    }

    private int indexOfSecondRollInFrame() {
        return 1;
    }

    private int indexOfFirstRollInNextFrame() {
        return 2;
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
