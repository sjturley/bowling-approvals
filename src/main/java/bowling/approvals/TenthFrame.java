package bowling.approvals;

import java.util.List;

public class TenthFrame implements Frame {
    protected final TenthFrameDomain fullFrameDomain = new TenthFrameDomain();

    public TenthFrame() {
    }

    @Override
    public String getFrameLine() {
        if (fullFrameDomain.rolls != null) {
            String firstRoll = getFirstRollString();
            String secondRoll = getSecondRollString();
            String thirdRoll = getThirdRollString();
            return "| " + firstRoll + "|" + secondRoll + "|" + thirdRoll + "|\n";
        }
        return "|  |_|_|\n";
    }

    private String getFirstRollString() {
        if (fullFrameDomain.rolls.get(fullFrameDomain.FIRST_ROLL) == 10) {
            return "X";
        }

        if (this.fullFrameDomain.rolls.get(fullFrameDomain.FIRST_ROLL) == 0) return "-";

        return fullFrameDomain.rolls.get(fullFrameDomain.FIRST_ROLL).toString();
    }

    private String getSecondRollString() {
        if (fullFrameDomain.rolls.size() > 1) {
            if (fullFrameDomain.rolls.get(fullFrameDomain.SECOND_ROLL) == 10) {
                return "X";
            }
        }

        if (fullFrameDomain.rolls.size() > 1) {
            if (fullFrameDomain.isSpare()) {
                return "/";
            }
            if (this.fullFrameDomain.rolls.get(fullFrameDomain.SECOND_ROLL) == 0) return "-";

            return fullFrameDomain.rolls.get(fullFrameDomain.SECOND_ROLL).toString();
        }
        return "_";
    }

    private String getThirdRollString() {
        if (fullFrameDomain.rolls.size() > 2) {
            if (fullFrameDomain.rolls.get(fullFrameDomain.THIRD_ROLL) == 10) {
                return "X";
            }
            return fullFrameDomain.rolls.get(fullFrameDomain.THIRD_ROLL).toString();
        }
        return "_";
    }

    @Override
    public String getScoreBox() {
        String score = "   ";
        if (fullFrameDomain.lastScore != null && fullFrameDomain.rolls != null && fullFrameDomain.rolls.size() >= 2) {
            int frameSum = fullFrameDomain.getFrameSum() + fullFrameDomain.lastScore;

            if (!fullFrameDomain.isSpare() || this.fullFrameDomain.hasAnotherRoll()) {
                score = this.leftPad(frameSum);
            }
        }
        return "| " + score + "  |\n";
    }

    public void setRolls(List<Integer> rolls) {
        this.fullFrameDomain.rolls = rolls;
    }

    public void setLastScore(int lastScore) {
        this.fullFrameDomain.lastScore = lastScore;
    }
}
