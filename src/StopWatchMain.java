
import java.util.Timer;
import java.util.TimerTask;

public class StopWatchMain {

    public static void main(String[] args) {
        State idle = new Idle();
        StopWatch stopWatch = new StopWatch(idle);
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println(stopWatch.getTime() / 1000.0 + " seconds");
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask, 100, 100);

    }

}
