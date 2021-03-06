package gapp.ulg.test.Grafica;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Created by Edoardo on 04/09/2016.
 */

public class Flip extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Rectangle front = new Rectangle(50, 50);

        ScaleTransition stHideFront = new ScaleTransition(Duration.millis(1500), front);
        stHideFront.setFromX(1);
        stHideFront.setToX(0);

        Rectangle back = new Rectangle(50, 50, Color.RED);
        back.setScaleX(0);

        ScaleTransition stShowBack = new ScaleTransition(Duration.millis(1500), back);
        stShowBack.setFromX(0);
        stShowBack.setToX(1);

        stHideFront.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                stShowBack.play();
            }
        });

        StackPane root = new StackPane();
        root.getChildren().addAll(front, back);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setScene(scene);

        primaryStage.show();
        stHideFront.play();
    }
}