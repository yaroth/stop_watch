import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Intermediate implements State {

    private StopWatch stopWatch;
    private State state;

    @Override
    public void setState(State state) {
        this.state = state;
    }

    @Override
    public void setStopWatch(StopWatch stopWatch) {
        this.stopWatch = stopWatch;
    }

    @Override
    public long getTime() {
        return ChronoUnit.MILLIS.between(stopWatch.start, stopWatch.lap);
    }

    @Override
    public void handleEventB1() {
        // intermediate -> running
        this.stopWatch.state = new Running();
        this.stopWatch.state.setStopWatch(stopWatch);

    }

    @Override
    public void handleEventB2() {
        // intermediate ->stopped
        this.stopWatch.end = LocalDateTime.now();
        this.stopWatch.state = new Stopped();
        this.stopWatch.state.setStopWatch(stopWatch);
    }
}
