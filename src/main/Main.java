package main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.StopWatch;
import view.StopWatchView;

/**
 * Created by yann on 23.04.18.<br>
 * main.Main application class to startTime the qwixx game.<br>
 */
public final class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        StopWatch stopWatch = new StopWatch();
        StopWatchView stopWatchView = new StopWatchView(primaryStage);
        Scene scene = stopWatchView.createScene(stopWatch);

        primaryStage.setTitle("Stop Watch");
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
