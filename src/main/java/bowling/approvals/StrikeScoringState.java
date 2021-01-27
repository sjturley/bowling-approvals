package bowling.approvals;

public class StrikeScoringState extends FrameScoreState {
    public StrikeScoringState(Frame frame) {
        super(frame);
    }

    @Override
    public void potentiallyAddBonusToFrame(Integer firstRoll, Integer secondRoll) {
        frame.frameScore += firstRoll + secondRoll;
        frame.runningScore += firstRoll + secondRoll;
    }
}
