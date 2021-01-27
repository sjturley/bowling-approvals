package bowling.approvals;

public class SpareScoringState extends FrameScoreState {
    public SpareScoringState(Frame frame) {
        super(frame);
    }

    @Override
    public void potentiallyAddBonusToFrame(Integer firstRoll, Integer secondRoll) {
        frame.frameScore += firstRoll;
        frame.runningScore += firstRoll;
    }
}
