package bowling.approvals;

public class NullFrame implements Frame {

    public NullFrame() {
    }

    public String getFrameLine() {
        return "|   |_";
    }

    public String getScoreBox() {
        return "|     ";
    }

}
