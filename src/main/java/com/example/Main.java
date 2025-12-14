package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/calcuator.png")));
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/sceneCalculator.fxml")));

        Scene scene = new Scene(parent);
        String css = Objects.requireNonNull(this.getClass().getResource("/style.css")).toExternalForm();
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        stage.setTitle("Calculator");
        stage.getIcons().add(image);
        stage.show();
    }
}