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
            String firstRoll = getFirstRoll();
            String secondRoll = getSecondRoll();
            String thirdRoll = getThirdRoll();
            return "| " + firstRoll + "|" + secondRoll + "|" + thirdRoll + "|\n";
        }
        return "|  |_|_|\n";
    }

    private String getThirdRoll() {
        if (rolls.size() > 2) {
            if (rolls.get(2) == 10) {
                return "X";
            }
            return rolls.get(2).toString();
        }
        return "_";
    }

    private String getFirstRoll() {
        if (this.rolls.get(0) == 0) return "-";
        if (rolls.get(0) == 10) {
            return "X";
        }

        return rolls.get(0).toString();
    }

    private String getSecondRoll() {
        if (rolls.size() > 1) {
            if (sumOfRolls() == 10) {
                return "/";
            }
            if (rolls.get(1) == 10) {
                return "X";
            }
            if (this.rolls.get(1) == 0) return "-";

            return rolls.get(1).toString();
        }
        return "_";
    }

    private boolean hasAnotherRoll() {
        return this.rolls.size() > 2;
    }

    @Override
    public String getScoreBox() {
        if (lastScore != null && rolls != null && rolls.size() >= 2) {
            String score = "";
            if (sumOfRolls() == 10 && !hasAnotherRoll()) {
                score = "   ";
            } else if(this.rolls.get(0) == 10 || sumOfRolls() == 10) {
                score = this.leftPad(lastScore + sumOfRolls() + this.rolls.get(2));
            } else {
                score = this.leftPad(lastScore + sumOfRolls());
            }
            return "| " + score + "  |\n";
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
