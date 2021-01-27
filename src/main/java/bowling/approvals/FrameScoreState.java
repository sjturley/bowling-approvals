package bowling.approvals;

public abstract class FrameScoreState {
    protected Frame frame;

    public FrameScoreState(Frame frame) {
        this.frame = frame;
    }

    abstract public void potentiallyAddBonusToFrame(Integer firstRoll, Integer secondRoll);
}
