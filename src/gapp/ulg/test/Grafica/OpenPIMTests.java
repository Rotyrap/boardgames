package gapp.ulg.test.Grafica;

/**
 * Created by Edoardo on 24/08/2016.
 */
import java.awt.Paint;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Bhathiya
 */
public class OpenPIMTests extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        StackPane root = new StackPane(); // load an fxml
        root.setPrefSize(500, 500);
        stage.initStyle(StageStyle.TRANSPARENT); //undecorated/transparent
        Scene scene = new Scene(new CustomDecorator(stage, root)); // create a scene from new CustomDecorator
        scene.setFill(null);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}