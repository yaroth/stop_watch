
import java.time.*;
import java.time.temporal.ChronoUnit;

public class StopWatch implements EventHandler {

    public State state;
    public LocalDateTime start;

    public StopWatch(State state) {
        this.state = state;
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
        LocalDateTime now = LocalDateTime.now();
        long millis = ChronoUnit.MILLIS.between(start, now);
        System.out.printf("Some other change");
        return millis;
    }
}
