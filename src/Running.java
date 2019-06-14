import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Running implements State {

    private StopWatch stopWatch;

    public Running(StopWatch stopWatch) {
        this.stopWatch = stopWatch;
    }

    @Override
    public void setState(State state) {
        this.stopWatch.state = state;
    }

    @Override
    public long getTime() {
        return ChronoUnit.MILLIS.between(stopWatch.startTime, LocalDateTime.now()) ;
    }

    @Override
    public void handleEventB1() {
        // running -> intermediate
        this.stopWatch.lapTime = LocalDateTime.now();
        this.stopWatch.state = this.stopWatch.intermediate;
    }

    @Override
    public void handleEventB2() {
        // running -> stopped
        this.stopWatch.endTime = LocalDateTime.now();
        this.stopWatch.state = this.stopWatch.stopped;

    }
}
