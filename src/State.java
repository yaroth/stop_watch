
import java.time.LocalDateTime;

public interface State extends EventHandler{

    void setState(State state);

    void setStopWatch(StopWatch stopWatch);

    long getTime();

}

