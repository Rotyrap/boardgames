package gapp.ulg.test.Grafica;

import gapp.gui.Windows.*;

import javafx.animation.Animation;
import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.*;
import java.util.*;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import gapp.gui.*;

public class TextTransitions extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
//        HBox h = new HBox(createBottoneSlide("Previous", true), createBottoneSlide("Next", false));
        HBox h = new HBox(createButtonPlayers());
        h.setSpacing(100);
        h.setAlignment(Pos.CENTER);

        /*
        MyTimer timer = new MyTimer();
        StackPane root = new StackPane(timer.getTimer());
        timer.start();
        root.setAlignment(Pos.CENTER);
        root.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, null, null)));
        */

        StackPane root = new StackPane();
        Options opzioni = new Options(new HashMap<>(), root, null);
        root.getChildren().add(opzioni.getWindow());

        Scene scene = new Scene(root);
        scene.getStylesheets().add("resources/style.css");
        stage.setTitle("Sample");
        stage.setScene(scene);
        stage.show();
//        animation.play();
//        
//        
    }
    //        animation.setOnFinished(t -> frecciaAnim.play());
    
    
    public Parent createBottoneSlide(String testo, boolean left) {
        final Text freccia = new Text(left ? "<< " : " >>");
        freccia.setOpacity(0);
        freccia.setTranslateY(-1.5);
        final Text text = new Text(testo);

        StackPane stackpane = new StackPane(freccia, text);
        stackpane.setAlignment(left? Pos.CENTER_LEFT : Pos.CENTER_RIGHT);

        final Animation animation = new Transition() {
            { setCycleDuration(Duration.millis(200)); }
            protected void interpolate(double frac) {
                final int n = Math.round(20 * (float) frac);
                text.setStyle("-fx-translate-x: " + (left ? "" : "-") + n);
                stackpane.setStyle("-fx-translate-x: " + (left ? "-" : "") + n/2);
            }
        };

        final Animation frecciaAnim = new Transition() {
            { setCycleDuration(Duration.millis(200)); }
            protected void interpolate(double frac) {
                final int length = freccia.getText().length();
                final int n = Math.round(length * (float) frac);
                freccia.setOpacity(frac);
            }
        };

        HBox hbox = new HBox(stackpane);
        hbox.setOnMouseEntered(e -> {
            frecciaAnim.setRate(0.5);
            animation.setRate(1.0);
            animation.playFrom(animation.getCurrentTime());
            frecciaAnim.playFrom(frecciaAnim.getCurrentTime());
//            animation.setOnFinished(t -> frecciaAnim.play());
//            frecciaAnim.setOnFinished(t -> {});
        });
        hbox.setOnMouseExited(e -> {
            frecciaAnim.setRate(-2.0);
            animation.setRate(-1.0);
            frecciaAnim.playFrom(frecciaAnim.getCurrentTime());
            animation.playFrom(animation.getCurrentTime());
//            frecciaAnim.setOnFinished(t -> animation.playFrom(animation.getCurrentTime()));
//            animation.setOnFinished(t -> {});
        });
        hbox.setAlignment(Pos.CENTER);
        hbox.setStyle(" -fx-background-color: #eeeeee;" 
                +  " -fx-border-color: #bbbbbb;"
                +  " -fx-border-width: 1;"
                +  " -fx-border-style: solid;");
        hbox.setMaxWidth(100);
        hbox.setPrefWidth(100);
        hbox.setPrefHeight(30);
        hbox.setSpacing(20);
        VBox v = new VBox(hbox);
        v.setAlignment(Pos.CENTER);
        return v;
    }
    
    public Parent createButtonPlayers()  {
        double offset     = 15.0;
        int sfondoWidth   = 80;
        int sfondoHeight  = 40;
        int cerchioRadius = 65;
        int duration      = 300;
        
        
        VBox cerchio = new VBox();
        cerchio.setMinWidth(cerchioRadius);
        cerchio.setMaxWidth(cerchioRadius);
        cerchio.setMinHeight(cerchioRadius);
        cerchio.setMaxHeight(cerchioRadius);
        cerchio.setTranslateX(-offset);
        cerchio.getStyleClass().add("bplayers-cerchio");
        
        VBox sfondo = new VBox();
        sfondo.setMinWidth(sfondoWidth);
        sfondo.setMaxWidth(sfondoWidth);
        sfondo.setMinHeight(sfondoHeight);
        sfondo.setMaxHeight(sfondoHeight);
        sfondo.getStyleClass().add("bplayers-sfondo");
        
        
        final Animation cerchioAnim = new Transition() {
            { setCycleDuration(Duration.millis(duration)); }
            protected void interpolate(double x) {
//                cerchio.setTranslateX((1 - f(1 - x)) * 30);
                double length = 2*offset + (sfondo.getWidth() - cerchio.getWidth());
                cerchio.setTranslateX(-offset + length * (x <= 0.5? f(2*x)/2 : (2 - f(2*(1-x)))/2));
            }
        };
        cerchioAnim.setOnFinished(e -> cerchioAnim.setRate((-1.0) * cerchioAnim.getRate()));
        
        Text uno = new Text("1");
        uno.getStyleClass().add("bplayers-text");
        uno.setTranslateX(11);
        uno.setTranslateY(0);
        uno.setMouseTransparent(true);
        Text due = new Text("2");
        due.getStyleClass().add("bplayers-text");
        due.setTranslateX(58);
        due.setTranslateY(0);
        due.setMouseTransparent(true);
        
        StackPane stackpane = new StackPane(sfondo, cerchio, uno, due);
        stackpane.setOnMouseClicked(e -> cerchioAnim.play());
        stackpane.setAlignment(Pos.CENTER_LEFT);
        return stackpane;
    }
    
    public double f(double x) {
        return Math.pow(1.5, 10 * (x - 1));
    }
    
    
}
