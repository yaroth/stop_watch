import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class Stopped implements State {

    private State state;
    private StopWatch stopWatch;

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
        return ChronoUnit.MILLIS.between(stopWatch.start, stopWatch.end);

    }

    @Override
    public void handleEventB1() {
        // stopped -> running
        long stoppedDurationMillis = Duration.between(stopWatch.end, LocalDateTime.now()).toMillis();
        this.stopWatch.start = this.stopWatch.start.plus(stoppedDurationMillis, ChronoUnit.MILLIS);
        this.stopWatch.state = new Running();
        this.stopWatch.state.setStopWatch(stopWatch);
    }

    @Override
    public void handleEventB2() {
        // stopped -> idle
        this.stopWatch.state = new Idle();
        this.stopWatch.state.setStopWatch(stopWatch);
    }
}
