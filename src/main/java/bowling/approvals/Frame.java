package bowling.approvals;

import java.util.List;

public class Frame {
    Integer firstRoll;
    Integer secondRoll;
    Integer frameScore;
    Integer runningScore;
    Frame previousFrame;

    public Frame(Frame previousFrame) {
        this.previousFrame = previousFrame;
    }

    public void addRoll(int roll) {
        if (firstRoll == null) {
            firstRoll = roll;
        } else {
            secondRoll = roll;

            frameScore = firstRoll + secondRoll;
            runningScore = calculateRunningScore();
        }
    }

    public boolean isDone() {
        return firstRoll != null && secondRoll != null;
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