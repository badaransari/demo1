package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class HelloController {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField dobField;

    @FXML
    private TextField zipCodeField;

    @FXML
    private Button addButton;

    @FXML
    private Label successMessage;

    public void initialize() {
        // Disable the "Add" button initially
        addButton.setDisable(true);

        // Add input validations and listeners for text fields
        firstNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            // Validate and update UI
            validateAndUpdateUI();
        });

        lastNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            // Validate and update UI
            validateAndUpdateUI();
        });

        emailField.textProperty().addListener((observable, oldValue, newValue) -> {
            // Validate and update UI
            validateAndUpdateUI();
        });

        dobField.textProperty().addListener((observable, oldValue, newValue) -> {
            // Validate and update UI
            validateAndUpdateUI();
        });

        zipCodeField.textProperty().addListener((observable, oldValue, newValue) -> {
            // Validate and update UI
            validateAndUpdateUI();
        });

        // Handle "Add" button click
        addButton.setOnAction(event -> {
            successMessage.setText("Registration successful!");
            // Here, you can navigate to a new UI or perform further actions
        });
    }

    private void validateAndUpdateUI() {
        boolean isValid = validateTextField(firstNameField, "^[A-Za-z]{2,25}$")
                && validateTextField(lastNameField, "^[A-Za-z]{2,25}$")
                && validateTextField(emailField, "^[A-Za-z0-9+_.-]+@farmingdale.edu$")
                && validateTextField(dobField, "^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/\\d{4}$")
                && validateTextField(zipCodeField, "^[0-9]{5}$");

        addButton.setDisable(!isValid);
    }

    private boolean validateTextField(TextField textField, String pattern) {
        String text = textField.getText();
        if (text == null || text.trim().isEmpty()) {
            return false;
        }
        return text.matches(pattern);
    }
}
