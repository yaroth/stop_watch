
import java.time.*;
import java.time.temporal.ChronoUnit;

public class StopWatch implements EventHandler {

    public State state;
    public LocalDateTime start;
    public LocalDateTime lap;
    public LocalDateTime end;

    public StopWatch(State state) {
        this.state = state;
        // add the stopwatch to the state.
        this.state.setStopWatch(this);
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
