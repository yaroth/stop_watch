
import java.time.LocalDateTime;

public interface State extends EventHandler{

    void setState(State state);

    long getTime();

}

