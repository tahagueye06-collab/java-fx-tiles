package be.kdg.tiles.view;

import be.kdg.tiles.model.TileModel;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class TileView extends BorderPane {
    private Canvas canvas;
    private final double tileWidth;
    private final double tileHeight;

    private static final double CANVAS_WIDTH = 800.0;
    private static final double CANVAS_HEIGHT = 600.0;

    private static final Color SELECTED_TILE_COLOR = Color.rgb(0, 0, 80);
    private static final Color HOVER_TILE_COLOR = Color.BLUE;
    private static final Color TILE_COLOR = Color.DARKBLUE;

    public TileView() {
        this.tileWidth = CANVAS_WIDTH / TileModel.COLUMNS;
        this.tileHeight = CANVAS_HEIGHT / TileModel.ROWS;

        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        this.canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
    }

    private void layoutNodes() {
        this.setCenter(this.canvas);
    }

    Canvas getCanvas() {
        return canvas;
    }

    void displayCurrentTiles(int currentHoverColumn, int currentHoverRow, int currentSelectedColumn, int currentSelectedRow) {
        final GraphicsContext gc = this.canvas.getGraphicsContext2D();
        gc.setFill(TILE_COLOR);
        gc.fillRect(0.0, 0.0, CANVAS_WIDTH, CANVAS_HEIGHT);

        if (currentHoverColumn != -1 && currentHoverRow != -1) {
            gc.setFill(HOVER_TILE_COLOR);
            gc.fillRect(currentHoverColumn * tileWidth, currentHoverRow * tileHeight, tileWidth, tileHeight);
        }

        if (currentSelectedColumn != -1 && currentSelectedRow != -1) {
            gc.setStroke(SELECTED_TILE_COLOR);
            gc.setLineWidth(20.0);
            gc.strokeRect(currentSelectedColumn * tileWidth + 10.0, currentSelectedRow * tileHeight + 10.0, tileWidth - 20.0, tileHeight - 20.0);
        }
    }
}
