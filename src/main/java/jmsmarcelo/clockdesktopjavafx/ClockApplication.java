package jmsmarcelo.clockdesktopjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ClockApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader clock = new FXMLLoader(ClockApplication.class.getResource("clock-view.fxml"));
        Scene scene = new Scene(clock.load(), 800, 600);
        scene.getStylesheets().add(ClockApplication.class.getResource("clock-style.css").toExternalForm());
        stage.setTitle("Clock");
        stage.setScene(scene);
        stage.show();
        stage.setMinWidth(stage.getWidth() + 4);
        stage.setMinHeight(stage.getHeight() + 4);
    }
    public static void main(String[] args) {
        launch();
    }
}