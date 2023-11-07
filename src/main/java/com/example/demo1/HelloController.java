package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onEnterButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    //week 9 assignment


}