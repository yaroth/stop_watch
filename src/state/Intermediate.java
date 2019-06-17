package state;

import logic.StopWatch;
import state.State;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Intermediate extends State {

    public Intermediate(StopWatch stopWatch) {
        super(stopWatch);
    }

    @Override
    public long getTime() {
        return ChronoUnit.MILLIS.between(stopWatch.startTime, stopWatch.lapTime);
    }

    @Override
    public void handleEventB1() {
        // intermediate -> running
        this.setStopWatchState(this.stopWatch.running);

    }

    @Override
    public void handleEventB2() {
        // intermediate ->stopped
        this.stopWatch.endTime = LocalDateTime.now();
        this.setStopWatchState(this.stopWatch.stopped);
    }
}
