
import java.time.LocalDateTime;

public class Idle implements State {

    private StopWatch stopWatch;

    public Idle(StopWatch stopWatch) {
        this.stopWatch = stopWatch;
    }

    @Override
    public void setState(State state) {
        this.stopWatch.state = state;
    }


    @Override
    public long getTime() {
        return 0;
    }

    @Override
    public void handleEventB1() {
        // idle -> running
        this.stopWatch.startTime = LocalDateTime.now();
        this.stopWatch.state = this.stopWatch.running;

    }

    @Override
    public void handleEventB2() {
    // do nothing!
    }
}
