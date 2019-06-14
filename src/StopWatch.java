
import java.time.*;
import java.time.temporal.ChronoUnit;

public class StopWatch implements EventHandler {

    public State state;
    public LocalDateTime startTime;
    public LocalDateTime lapTime;
    public LocalDateTime endTime;

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
