import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Intermediate implements State {

    private StopWatch stopWatch;
    private State state;

    public Intermediate(StopWatch stopWatch) {
        this.stopWatch = stopWatch;
    }

    @Override
    public void setState(State state) {
        this.state = state;
    }

    @Override
    public long getTime() {
        return ChronoUnit.MILLIS.between(stopWatch.startTime, stopWatch.lapTime);
    }

    @Override
    public void handleEventB1() {
        // intermediate -> running
        this.stopWatch.state = this.stopWatch.running;

    }

    @Override
    public void handleEventB2() {
        // intermediate ->stopped
        this.stopWatch.endTime = LocalDateTime.now();
        this.stopWatch.state = this.stopWatch.stopped;
    }
}
