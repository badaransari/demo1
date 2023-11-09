package com.example.demo1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.regex.Pattern;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Registration Form");
        GridPane grid = createRegistrationForm();

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createRegistrationForm() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Labels
        Label firstNameLabel = new Label("First Name:");
        Label lastNameLabel = new Label("Last Name:");
        Label emailLabel = new Label("Email:");
        Label dobLabel = new Label("Date of Birth:");
        Label zipCodeLabel = new Label("Zip Code:");

        // TextFields
        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        TextField emailField = new TextField();
        TextField dobField = new TextField();
        TextField zipCodeField = new TextField();

        // Add labels and fields to the grid
        grid.add(firstNameLabel, 0, 0);
        grid.add(firstNameField, 1, 0);
        grid.add(lastNameLabel, 0, 1);
        grid.add(lastNameField, 1, 1);
        grid.add(emailLabel, 0, 2);
        grid.add(emailField, 1, 2);
        grid.add(dobLabel, 0, 3);
        grid.add(dobField, 1, 3);
        grid.add(zipCodeLabel, 0, 4);
        grid.add(zipCodeField, 1, 4);

        // Add validation labels
        Label firstNameValidation = new Label();
        Label lastNameValidation = new Label();
        Label emailValidation = new Label();
        Label dobValidation = new Label();
        Label zipCodeValidation = new Label();

        grid.add(firstNameValidation, 2, 0);
        grid.add(lastNameValidation, 2, 1);
        grid.add(emailValidation, 2, 2);
        grid.add(dobValidation, 2, 3);
        grid.add(zipCodeValidation, 2, 4);

        // Add button
        Button addButton = new Button("Add");
        grid.add(addButton, 1, 5);

        // Add a message label for successful submission
        Label successMessage = new Label();
        grid.add(successMessage, 0, 6, 3, 1);

        // Disable the "Add" button initially
        addButton.setDisable(true);

        // Input validations using regular expressions
        String namePattern = "^[A-Za-z]{2,25}$";
        String emailPattern = "^[A-Za-z0-9+_.-]+@farmingdale.edu$";
        String dobPattern = "^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/\\d{4}$";
        String zipCodePattern = "^[0-9]{5}$";

        // Validate First Name
        firstNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (Pattern.matches(namePattern, newValue)) {
                firstNameValidation.setText("Valid");
                firstNameValidation.setTextFill(Color.GREEN);
            } else {
                firstNameValidation.setText("Invalid");
                firstNameValidation.setTextFill(Color.RED);
            }
            checkFormValidity(addButton, firstNameField, lastNameField, emailField, dobField, zipCodeField);
        });

        // Validate Last Name
        lastNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (Pattern.matches(namePattern, newValue)) {
                lastNameValidation.setText("Valid");
                lastNameValidation.setTextFill(Color.GREEN);
            } else {
                lastNameValidation.setText("Invalid");
                lastNameValidation.setTextFill(Color.RED);
            }
            checkFormValidity(addButton, firstNameField, lastNameField, emailField, dobField, zipCodeField);
        });

        // Validate Email
        emailField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (Pattern.matches(emailPattern, newValue)) {
                emailValidation.setText("Valid");
                emailValidation.setTextFill(Color.GREEN);
            } else {
                emailValidation.setText("Invalid");
                emailValidation.setTextFill(Color.RED);
            }
            checkFormValidity(addButton, firstNameField, lastNameField, emailField, dobField, zipCodeField);
        });

        // Validate Date of Birth
        dobField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (Pattern.matches(dobPattern, newValue)) {
                dobValidation.setText("Valid");
                dobValidation.setTextFill(Color.GREEN);
            } else {
                dobValidation.setText("Invalid");
                dobValidation.setTextFill(Color.RED);
            }
            checkFormValidity(addButton, firstNameField, lastNameField, emailField, dobField, zipCodeField);
        });

        // Validate Zip Code
        zipCodeField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (Pattern.matches(zipCodePattern, newValue)) {
                zipCodeValidation.setText("Valid");
                zipCodeValidation.setTextFill(Color.GREEN);
            } else {
                zipCodeValidation.setText("Invalid");
                zipCodeValidation.setTextFill(Color.RED);
            }
            checkFormValidity(addButton, firstNameField, lastNameField, emailField, dobField, zipCodeField);
        });

        // Handle "Add" button click
        addButton.setOnAction(event -> {
            successMessage.setText("Registration successful!");
            // Here, you can navigate to a new UI or perform further actions
        });

        return grid;
    }

    // Function to enable/disable "Add" button based on form validity
    private void checkFormValidity(Button addButton, TextField firstNameField, TextField lastNameField, TextField emailField, TextField dobField, TextField zipCodeField) {
        boolean isValid = Pattern.matches("^[A-Za-z]{2,25}$", firstNameField.getText())
                && Pattern.matches("^[A-Za-z]{2,25}$", lastNameField.getText())
                && Pattern.matches("^[A-Za-z0-9+_.-]+@farmingdale.edu$", emailField.getText())
                && Pattern.matches("^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/\\d{4}$", dobField.getText())
                && Pattern.matches("^[0-9]{5}$", zipCodeField.getText());

        addButton.setDisable(!isValid);
    }

    /*
     *
     * @param primaryStage The primary stage of the application.
     */





        }

