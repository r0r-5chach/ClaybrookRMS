package com.mawkish.claybrookrms.login;

import com.mawkish.claybrookrms.Application;
import com.mawkish.claybrookrms.tools.ScreenHandler;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {
    @FXML
    private TextField username;
    private final LoginHandler loginHandler = new LoginHandler();

    private double xOffset;
    private double yOffset;

    @FXML
    private PasswordField password;

    @FXML
    private Label errorLabel;

    @FXML
    protected void onExitButtonClick() {
        Platform.exit();
    }

    @FXML
    protected void onMinButtonClick() {
        Stage stage = (Stage) username.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    protected void dragOnMousePressed(MouseEvent event) {
        xOffset = username.getScene().getWindow().getX() - event.getScreenX();
        yOffset = username.getScene().getWindow().getY() - event.getScreenY();
    }

    @FXML
    protected void dragOnMouseDragged(MouseEvent event) {
        username.getScene().getWindow().setX(event.getScreenX() + xOffset);
        username.getScene().getWindow().setY(event.getScreenY() + yOffset);
    }

    @FXML
    protected void onLoginButtonClick() throws IOException {
        ScreenHandler screenHandler = new ScreenHandler(username.getScene());

        screenHandler.addScreen("main", FXMLLoader.load(Objects.requireNonNull(Application.class.getResource("main.fxml"))));

        if(loginHandler.checkLogin(username.getText(), password.getText())) {
            screenHandler.changeScreen("main");
        }else {
            errorLabel.setText("Incorrect username/password");
        }
    }

    private void onEnterPress() throws IOException {
        ScreenHandler screenHandler = new ScreenHandler(username.getScene());

        screenHandler.addScreen("main", FXMLLoader.load(Objects.requireNonNull(Application.class.getResource("main.fxml"))));

        if(loginHandler.checkLogin(username.getText(), password.getText())) {
            screenHandler.changeScreen("main");
        }else {
            errorLabel.setText("Incorrect username/password");
        }
    }

    @FXML
    protected  void onPassFocus() {
        password.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    onEnterPress();
                }catch (IOException exception) {
                    errorLabel.setText("There was an error logging in");
                }
            }
        });
    }

}