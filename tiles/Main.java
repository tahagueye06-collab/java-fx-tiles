package be.kdg.tiles;

import be.kdg.tiles.model.TileModel;
import be.kdg.tiles.view.Presenter;
import be.kdg.tiles.view.TileView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        final TileModel model = new TileModel();
        final TileView view = new TileView();
        primaryStage.setTitle("Tiles");
        primaryStage.setScene(new Scene(view));
        new Presenter(model, view);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
