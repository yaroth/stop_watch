package view;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import logic.StopWatch;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by yann on 17.6.2019.<br>
 */
public final class StopWatchView {

    private Stage stage;
    private StopWatch stopWatch;

    public StopWatchView(Stage stage) {
        this.stage = stage;
    }

    public Scene createScene(StopWatch stopWatch) {
        this.stopWatch = stopWatch;

        BorderPane borderPane = new BorderPane();
        Insets insets = new Insets(10);
        borderPane.setPadding(insets);

        Button b1 = new Button("Start / Lap");
        b1.setOnAction((event) -> stopWatch.handleEventB1());

        Button b2 = new Button("Stop / Reset");
        b2.setOnAction((event) -> stopWatch.handleEventB2());

        HBox bottomHBox = new HBox();

        bottomHBox.setSpacing(10);
        bottomHBox.setAlignment(Pos.CENTER);
        bottomHBox.getChildren().addAll(b1, b2);
        borderPane.setCenter(bottomHBox);

        Label timeLabel = new Label();
        timeLabel.setText(String.valueOf(stopWatch.getTime() / 1000));

        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override public void run() {
                Platform.runLater(() ->timeLabel.setText(String.valueOf(stopWatch.getTime() / 1000.0)));
            }
        }, 0L, 10L);

        HBox timeBox = new HBox();
        timeBox.setSpacing(10);
        timeBox.setAlignment(Pos.CENTER);
        timeBox.getChildren().addAll(timeLabel);
        borderPane.setBottom(timeBox);

        Scene scene = new Scene(borderPane, 400, 100);
        return scene;
    }

}
