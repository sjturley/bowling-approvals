package bowling.approvals;

import java.util.List;

public class TenthFrame implements Frame {
    private List<Integer> rolls;
    private Integer lastScore;

    public TenthFrame() {
    }

    @Override
    public String getFrameLine() {
        if (rolls != null) {
            String firstRoll = rolls.get(0).toString();
            String secondRoll = rolls.size() > 1 ? rolls.get(1).toString() : "_";
            String thirdRoll = rolls.size() > 2 ? rolls.get(2).toString() : "_";
            return "| " + firstRoll + "|" + secondRoll + "|" + thirdRoll + "|\n";
        }
        return "|  |_|_|\n";
    }

    private boolean hasAnotherRoll() {
        return this.rolls.size() > 2;
    }

    @Override
    public String getScoreBox() {
        if (lastScore != null && rolls != null && rolls.size() >= 2) {
            String score = "";
            if (sumOfRolls() == 10 && !hasAnotherRoll()) {
                score = "  ";
            } else if(sumOfRolls() == 10) {
                score = this.leftPad(lastScore + sumOfRolls() + this.rolls.get(2));
            } else {
                score = this.leftPad(lastScore + sumOfRolls());
            }
            return "| " + score + "   |\n";
        }
        return "|      |\n";
    }

    private int sumOfRolls() {
        return rolls.get(0) + rolls.get(1);
    }

    public void setRolls(List<Integer> rolls) {
        this.rolls = rolls;
    }

    public void setLastScore(int lastScore) {
        this.lastScore = lastScore;
    }
}
