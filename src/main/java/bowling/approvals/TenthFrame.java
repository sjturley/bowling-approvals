package bowling.approvals;

public class TenthFrame extends Frame{
    Integer tenthFrameThirdRoll;

    public TenthFrame(Frame previousFrame) {
        super(previousFrame);
    }

    @Override
    public void addRoll(int roll) {
        if (isFirstRollOfFrame()) {
            firstRoll = roll;
            if (wasStrike()) {
                state = new StrikeScoringState(this);
                closeFrame();
            }
        } else if (secondRoll == null) {
            secondRoll = roll;
            if(wasSpare()) {
                state = new SpareScoringState(this);
            } else  {
                state = new OpenScoringState(this);
            }
            closeFrame();
        } else {
            tenthFrameThirdRoll = roll;
            frameScore += tenthFrameThirdRoll;
            runningScore += tenthFrameThirdRoll;
        }
    }

    @Override
    String getString() {
        String thirdRoll = tenthFrameThirdRoll == null ? "" : "thirdRoll: "+ tenthFrameThirdRoll + ", ";
        String frame = String.format("{\"firstRoll\": %d, \"secondRoll\": %d, %sframeScore: %d, runningScore: %d}", firstRoll, secondRoll, thirdRoll, frameScore, runningScore);
        return frame;
    }


}
