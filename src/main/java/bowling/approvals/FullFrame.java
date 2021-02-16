package bowling.approvals;

import java.util.List;

public class FullFrame implements Frame {
    protected final FullFrameDomain fullFrameDomain = new FullFrameDomain();

    public FullFrame(List<Integer> rolls, int lastScore) {
        this.fullFrameDomain.rolls = rolls;
        this.fullFrameDomain.lastScore = lastScore;
    }

    private String getFirstRollString() {
        if (this.fullFrameDomain.rolls.get(FullFrameDomain.FIRST_ROLL) == 0) return "-";

        return this.fullFrameDomain.rolls.get(FullFrameDomain.FIRST_ROLL).toString();
    }

    private String getSecondRollString() {
        if (fullFrameDomain.isSpare()) {
            return "/";
        }
        if (this.fullFrameDomain.rolls.get(FullFrameDomain.SECOND_ROLL) == 0) return "-";
        return fullFrameDomain.rolls.get(FullFrameDomain.SECOND_ROLL).toString();
    }

    @Override
    public String getFrameLine() {
        if (fullFrameDomain.isStrike()) {
            return "|   |X";
        }
        String firstRoll = getFirstRollString();
        String secondRoll = getSecondRollString();
        return "|  " + firstRoll + "|" + secondRoll;
    }

    protected boolean isStrike() {
        return fullFrameDomain.isStrike();
    }

    @Override
    public String getScoreBox() {
        int totalScore = fullFrameDomain.getFrameSum() + fullFrameDomain.lastScore;
        String score = leftPad(totalScore);
        if (fullFrameDomain.isSpare() && !fullFrameDomain.hasAnotherRoll()) {
            score = "   ";
        }
        return "| " + score + " ";
    }

    protected boolean hasAnotherRoll() {
        return fullFrameDomain.hasAnotherRoll();
    }
}
