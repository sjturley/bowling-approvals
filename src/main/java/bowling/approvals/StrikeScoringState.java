package bowling.approvals;

public class StrikeScoringState extends FrameScoreState {
    public StrikeScoringState(Frame frame) {
        super(frame);
    }

//    @Override
//    public void potentiallyAddBonusToPreviousFrame(Integer firstRoll, Integer secondRoll) {
//        if (frame.previousFrame != null && (frame.previousFrame.wasStrike())) {
//            frame.previousFrame.frameScore += frame.firstRoll + frame.secondRoll;
//            frame.previousFrame.runningScore += frame.firstRoll + frame.secondRoll;
//        }
//        else if (frame.previousFrame != null && (frame.previousFrame.wasSpare())) {
//            frame.previousFrame.frameScore += frame.firstRoll;
//            frame.previousFrame.runningScore += frame.firstRoll;
//        }
//    }
}
