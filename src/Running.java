import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Running implements State {

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
        return ChronoUnit.MILLIS.between(stopWatch.start, LocalDateTime.now()) ;
    }

    @Override
    public void handleEventB1() {
        // running -> intermediate
        this.stopWatch.lap = LocalDateTime.now();
        this.stopWatch.state = new Intermediate();
        this.stopWatch.state.setStopWatch(stopWatch);
    }

    @Override
    public void handleEventB2() {
        // running -> stopped
        this.stopWatch.end = LocalDateTime.now();
        this.stopWatch.state = new Stopped();
        this.stopWatch.state.setStopWatch(stopWatch);

    }
}
