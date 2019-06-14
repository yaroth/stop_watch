import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by yann on 23.04.18.<br>
 * Main application class to start the qwixx game.<br>
 */
public final class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        State idle = new Idle();
        StopWatch stopWatch = new StopWatch(idle);
        StopWatchView stopWatchView = new StopWatchView(primaryStage);
        Scene scene = stopWatchView.createScene(stopWatch);

        primaryStage.setTitle("Stop Watch");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
