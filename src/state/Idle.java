package state;

import logic.StopWatch;
import state.State;

import java.time.LocalDateTime;

public class Idle extends State {

    public Idle(StopWatch stopWatch) {
        super(stopWatch);
    }

    @Override
    public long getTime() {
        return 0;
    }

    @Override
    public void handleEventB1() {
        // idle -> running
        this.stopWatch.startTime = LocalDateTime.now();
        this.setStopWatchState(this.stopWatch.running);

    }

    @Override
    public void handleEventB2() {
    // do nothing!
    }
}
