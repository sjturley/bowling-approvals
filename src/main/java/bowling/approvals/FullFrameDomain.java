package bowling.approvals;

import java.util.List;

public class FullFrameDomain {
    protected static final int FIRST_ROLL = 0;
    protected static final int SECOND_ROLL = 1;
    protected static final int THIRD_ROLL = 2;
    protected List<Integer> rolls;
    protected Integer lastScore;

    public FullFrameDomain() {
    }

    protected int getFrameSum() {
        int frameSum = sumOfRolls();
        if (isSpare() && hasAnotherRoll()) {
            if (isStrike()) {
                frameSum += this.rolls.get(SECOND_ROLL) + this.rolls.get(THIRD_ROLL);
            } else {
                frameSum += this.rolls.get(THIRD_ROLL);
            }
        }
        return frameSum;
    }

    protected int sumOfRolls() {
        if (isStrike()) {
            return 10;
        }
        return this.rolls.get(FIRST_ROLL) + this.rolls.get(SECOND_ROLL);
    }

    protected boolean isStrike() {
        return this.rolls.get(FIRST_ROLL) == 10;
    }

    protected boolean hasAnotherRoll() {
        return this.rolls.size() > 2;
    }

    boolean isSpare() {
        return sumOfRolls() == 10;
    }
}