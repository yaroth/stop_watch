package state;

import logic.EventHandler;
import logic.StopWatch;

public abstract class State implements EventHandler {

    public StopWatch stopWatch;

    public State (StopWatch stopWatch) {
        this.stopWatch = stopWatch;
    }


    void setStopWatchState(State state){
        this.stopWatch.state = state;
    };

    public abstract long getTime();

}

