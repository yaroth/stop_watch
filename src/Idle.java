
import java.time.Instant;
import java.time.LocalDateTime;

public class Idle implements State {

    private StopWatch stopWatch;


    @Override
    public void setState(State state) {
        this.stopWatch.state = state;
    }

    @Override
    public void setStopWatch(StopWatch stopWatch) {
        this.stopWatch = stopWatch;
    }

    @Override
    public long getTime() {
        return 0;
    }

    @Override
    public void handleEventB1() {
        // idle -> running
        this.stopWatch.start = LocalDateTime.now();
        this.stopWatch.state = new Running();
        this.stopWatch.state.setStopWatch(stopWatch);

    }

    @Override
    public void handleEventB2() {
    // do nothing!
    }
}
