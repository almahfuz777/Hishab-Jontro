package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Run extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(loader.load());
        //Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);

        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setTitle("Hishab Jontro");
        stage.getIcons().add(new Image("/images/icon.png"));
        ((Controller)loader.getController()).init(stage);   //
        stage.show();
   }

}