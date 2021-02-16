package bowling.approvals;

public class TenthFrameDomain extends FullFrameDomain {
    @Override
    public int getFrameSum() {
        int frameSum = sumOfRolls();
        if(this.hasAnotherRoll() &&
                (this.isStrike() || isSpare())) {
            frameSum = (frameSum + this.rolls.get(THIRD_ROLL));
        }
        return frameSum;
    }
    
    @Override
    public int sumOfRolls() {
        return rolls.get(FIRST_ROLL) + rolls.get(SECOND_ROLL);
    }

}
