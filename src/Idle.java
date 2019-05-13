
import java.time.Instant;
import java.time.LocalDateTime;

public class Idle implements State {

    private StopWatch stopWatch;


    @Override
    public void setState(State state) {

    }

    @Override
    public void setStopWatch(StopWatch stopWatch) {
        this.stopWatch = stopWatch;
        this.stopWatch.start = LocalDateTime.now();
    }

    @Override
    public void handleEventB1() {
        this.stopWatch.start = LocalDateTime.now();
    }

    @Override
    public void handleEventB2() {

    }
}
