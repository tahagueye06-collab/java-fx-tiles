package be.kdg.tiles.view;

import be.kdg.tiles.model.TileModel;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

public class Presenter {
    private final TileModel model;
    private final TileView view;

    private int currentHoverColumn;
    private int currentHoverRow;

    public Presenter(TileModel model, TileView view) {
        this.model = model;
        this.view = view;

        this.currentHoverColumn = -1;
        this.currentHoverRow = -1;

        this.addEventHandlers();
        this.updateView();
    }

    private int translateXToColumn(final double x) {
        final double width = this.view.getCanvas().getWidth();
        final int columnResult = (int)(x / width * TileModel.COLUMNS);
        if (columnResult >= 0 && columnResult < TileModel.COLUMNS) {
            return columnResult;
        }
        else {
            return -1;
        }
    }

    private int translateYToRow(final double y) {
        final double height = this.view.getCanvas().getHeight();
        final int rowResult = (int)(y / height * TileModel.ROWS);
        if (rowResult >= 0 && rowResult < TileModel.ROWS) {
            return rowResult;
        }
        else {
            return -1;
        }
    }

    private void addEventHandlers() {
        // TODO: complete this method
        Canvas canvas= view.getCanvas(); // we pakken de canvas van de vieuw

        canvas.setOnMouseMoved(event -> {
            // event.getX() = x positie van de muis
            // event.getY() = y positie van de muis
            currentHoverColumn = translateXToColumn(event.getX());  // x positie van de muis
            currentHoverRow = translateYToRow(event.getY());  // y positie van de muis
            updateView();
        });


        canvas.setOnMouseClicked(event -> {
            // hier bereken we de kolom en de rij op basis van hun positie
            int column= translateXToColumn(event.getX());
            int row= translateYToRow(event.getY());
            model.setSelectedTile(column,row);  // zetten hier de colum en de row in het model
            updateView();
        });

        canvas.setOnMouseExited(event -> {
            currentHoverColumn=-1;
            currentHoverRow=-1;
            updateView();
        });


    }

    private void updateView() {
        // TODO: complete this method
        view.displayCurrentTiles(currentHoverColumn,currentHoverRow, model.getSelectedTileColumn(), model.getSelectedTileRow());


    }
}
