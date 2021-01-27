package bowling.approvals;

public class Frame {
    Integer firstRoll;
    Integer secondRoll;
    Integer frameScore;
    Integer runningScore;
    Frame previousFrame;

    FrameScoreState state = new OpenScoringState(this);

    public Frame(Frame previousFrame) {
        this.previousFrame = previousFrame;
    }

    public void addRoll(int roll) {
        if (firstRoll == null) {
            firstRoll = roll;
            if (wasStrike()) {
                state = new StrikeScoringState(this);
                closeFrame();
            }
        } else {
            secondRoll = roll;
            if(wasSpare()) {
                state = new SpareScoringState(this);
            }
            closeFrame();
        }
    }

    private void closeFrame() {
        // done in the state
        if (previousFrame != null) {
            previousFrame.state.potentiallyAddBonusToFrame(firstRoll, secondRoll);
        }
        frameScore = state.calculateFrameScore(firstRoll, secondRoll);
        runningScore = calculateRunningScore();
    }

    public boolean wasStrike() {
        return firstRoll == 10;
    }

    public boolean wasSpare() {
        return !wasStrike() && firstRoll + secondRoll == 10;
    }

    public boolean isDone() {
        return firstRoll != null && (wasStrike() || secondRoll != null);
    }

    private int calculateRunningScore() {
        if (previousFrame == null) {
            return frameScore;
        }
        return frameScore + previousFrame.getRunningScore();
    }

    String getString() {
        String frame = String.format("{\"firstRoll\": %d, \"secondRoll\": %d, frameScore: %d, runningScore: %d}", firstRoll, secondRoll, frameScore, runningScore);
        return frame;
    }

    public int getRunningScore() {
        return runningScore;
    }
}