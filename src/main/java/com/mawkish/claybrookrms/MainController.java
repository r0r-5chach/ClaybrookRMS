package com.mawkish.claybrookrms;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainController {
    @FXML
    private ContextMenu filterMenu;

    @FXML
    private Label filterButton;

    @FXML
    protected void onFilterPress() {
        filterMenu.show(filterButton.getScene().getWindow(), filterButton.getLayoutX() + filterButton.getWidth(), filterButton.getLayoutY() - filterButton.getHeight());
    }

    @FXML
    protected void onExitButtonClick() {
        Platform.exit();
    }

    @FXML
    protected void onMinButtonClick() {
        Stage stage = (Stage) filterButton.getScene().getWindow();
        stage.setIconified(true);
    }
}