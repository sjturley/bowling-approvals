package bowling.approvals;

public class Frame {
    Integer firstRoll;
    Integer secondRoll;
    Integer frameScore;
    Integer runningScore;
    Frame previousFrame;

    FrameScoreState state = null;

    public Frame(Frame previousFrame) {
        this.previousFrame = previousFrame;
    }

    public void addRoll(int roll) {
        if (isFirstRollOfFrame()) {
            firstRoll = roll;
            if (wasStrike()) {
                state = new StrikeScoringState(this);
                closeFrame();
            }
        } else {
            secondRoll = roll;
            if(wasSpare()) {
                state = new SpareScoringState(this);
            } else  {
                state = new OpenScoringState(this);
            }
            closeFrame();
        }
    }

    public boolean isDone() {
        return firstRoll != null && (wasStrike() || secondRoll != null);
    }

    public boolean wasSpare() {
        return !wasStrike() && firstRoll + secondRoll == 10;
    }

    private boolean isFirstRollOfFrame() {
        return firstRoll == null;
    }

    private void closeFrame() {
        if (!isFirstFrame()) {
            previousFrame.potentiallyAddBonusToFrame(firstRoll, secondRoll);
        }
        frameScore = state.calculateFrameScore(firstRoll, secondRoll);
        runningScore = calculateRunningScore();
    }

    private void potentiallyAddBonusToFrame(Integer firstRoll, Integer secondRoll) {
        state.potentiallyAddBonusToFrame(firstRoll, secondRoll);
    }

    public boolean wasStrike() {
        return firstRoll == 10;
    }

    private int calculateRunningScore() {
        if (isFirstFrame()) {
            return frameScore;
        }
        return frameScore + previousFrame.getRunningScore();
    }

    private boolean isFirstFrame() {
        return previousFrame == null;
    }

    String getString() {
        String frame = String.format("{\"firstRoll\": %d, \"secondRoll\": %d, frameScore: %d, runningScore: %d}", firstRoll, secondRoll, frameScore, runningScore);
        return frame;
    }

    public int getRunningScore() {
        return runningScore;
    }
}