package state;

import logic.StopWatch;
import state.State;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Stopped extends State {

    public Stopped(StopWatch stopWatch) {
        super(stopWatch);
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
        this.setStopWatchState(this.stopWatch.running);
    }

    @Override
    public void handleEventB2() {
        // stopped -> idle
        this.setStopWatchState(this.stopWatch.idle);
    }
}
