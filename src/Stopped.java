import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Stopped implements State {

    private State state;
    private StopWatch stopWatch;

    public Stopped(StopWatch stopWatch) {
        this.stopWatch = stopWatch;
    }

    @Override
    public void setState(State state) {
        this.state = state;
    }

    @Override
    public long getTime() {
        return ChronoUnit.MILLIS.between(stopWatch.startTime, stopWatch.endTime);

    }

    @Override
    public void handleEventB1() {
        // stopped -> running
        long stoppedDurationMillis = Duration.between(stopWatch.endTime, LocalDateTime.now()).toMillis();
        this.stopWatch.startTime = this.stopWatch.startTime.plus(stoppedDurationMillis, ChronoUnit.MILLIS);
        this.stopWatch.state = this.stopWatch.running;
    }

    @Override
    public void handleEventB2() {
        // stopped -> idle
        this.stopWatch.state = this.stopWatch.idle;
    }
}
