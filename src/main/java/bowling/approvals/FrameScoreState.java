package bowling.approvals;

public class FrameScoreState {
    protected Frame frame;

    public FrameScoreState(Frame frame) {

        this.frame = frame;
    }

    public void potentiallyAddBonusToPreviousFrame(Integer firstRoll, Integer secondRoll) {
        if (frame != null && (frame.wasStrike())) {
            frame.frameScore += firstRoll + secondRoll;
            frame.runningScore += firstRoll + secondRoll;
        }
        else if (frame != null && (frame.wasSpare())) {
            frame.frameScore += firstRoll;
            frame.runningScore += firstRoll;
        }
    }
}
