package state;

import logic.StopWatch;
import state.State;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Running extends State {

    public Running(StopWatch stopWatch) {
        super(stopWatch);
    }

    @Override
    public long getTime() {
        return ChronoUnit.MILLIS.between(stopWatch.startTime, LocalDateTime.now()) ;
    }

    @Override
    public void handleEventB1() {
        // running -> intermediate
        // display time: lap time
        // time is running in the background.
        this.stopWatch.lapTime = LocalDateTime.now();
        this.setStopWatchState(this.stopWatch.intermediate);
    }

    @Override
    public void handleEventB2() {
        // running -> stopped
        // display time: stopped time
        // time is stopped in the background
        this.stopWatch.endTime = LocalDateTime.now();
        this.setStopWatchState(this.stopWatch.stopped);

    }
}
