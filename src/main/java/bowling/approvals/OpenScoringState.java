package bowling.approvals;

public class OpenScoringState extends FrameScoreState {
    public OpenScoringState(Frame frame) {
        super(frame);
    }

    @Override
    public void potentiallyAddBonusToFrame(Integer firstRoll, Integer secondRoll) {

    }

    @Override
    int calculateFrameScore(Integer firstRoll, Integer secondRoll) {
        return firstRoll + secondRoll;
    }
}
