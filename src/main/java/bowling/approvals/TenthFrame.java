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
            return "| " + firstRoll + "|" + secondRoll + "|_|\n";
        }
        return "|  |_|_|\n";
    }

    @Override
    public String getScoreBox() {
        if (lastScore != null && rolls != null && rolls.size() >= 2) {
            String score = this.leftPad(lastScore + rolls.get(0) + rolls.get(1));
            return "| " + score + "   |\n";
        }
        return "|      |\n";
    }

    public void setRolls(List<Integer> rolls) {
        this.rolls = rolls;
    }

    public void setLastScore(int lastScore) {
        this.lastScore = lastScore;
    }
}
