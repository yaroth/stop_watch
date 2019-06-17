package logic;

import state.*;

import java.time.*;

public class StopWatch implements EventHandler {

    // the state the logic.StopWatch is in NOW
    public State state;

    public LocalDateTime startTime;
    public LocalDateTime lapTime;
    public LocalDateTime endTime;

    // the POSSIBLE states the logic.StopWatch can be in...
    // each one of them need to know about the logic.StopWatch!
    public State running = new Running(this);
    public State idle = new Idle(this);
    public State intermediate = new Intermediate(this);
    public State stopped = new Stopped(this);


    public StopWatch() {
        this.state = idle;
    }

    @Override
    public void handleEventB1() {
        state.handleEventB1();
    }

    @Override
    public void handleEventB2() {
        state.handleEventB2();
    }

    public long getTime() {
        return state.getTime();
    }
}
