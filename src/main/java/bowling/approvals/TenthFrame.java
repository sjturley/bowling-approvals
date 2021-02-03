package bowling.approvals;

public class TenthFrame implements Frame {
    public TenthFrame() {
    }

    @Override
    public String getFrameLine() {
        return "|  |_|_|\n";
    }

    @Override
    public String getScoreBox() {
        return "|      |\n";
    }
}
