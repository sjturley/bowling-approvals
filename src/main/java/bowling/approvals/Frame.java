package bowling.approvals;

public interface Frame {
    String getFrameLine();

    String getScoreBox();

    default String leftPad(int totalScore) {
        String score = String.valueOf(totalScore);
        if (score.length() == 1) {
            score = " " + score;
        }
        return score;
    }
}
