package lk.ijse.calculator.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private TextField display;

    private double firstNumber = 0;
    private double secondNumber = 0;
    private String currentOperation = "";

    @FXML
    private void handleNumberButtonAction(ActionEvent event) {
        Button button = (Button) event.getSource();
        String currentText = display.getText();
        display.setText(currentText + button.getText());
    }

    @FXML
    private void handleOperationButtonAction(ActionEvent event) {
        Button button = (Button) event.getSource();
        firstNumber = Double.parseDouble(display.getText());
        display.setText("");
        currentOperation = button.getText();
    }

    @FXML
    private void handleDecimalButtonAction(ActionEvent event) {
        String currentText = display.getText();
        if (!currentText.contains(".")) {
            display.setText(currentText + ".");
        }
    }

    @FXML
    private void handleEqualButtonAction(ActionEvent event) {
        secondNumber = Double.parseDouble(display.getText());
        double result;

        switch (currentOperation) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber == 0) {
                    display.setText("Error");
                    return;
                } else {
                    result = firstNumber / secondNumber;
                }
                break;
            default:
                return;
        }

        display.setText(String.valueOf(result));
        currentOperation = "";
    }

    @FXML
    private void handleClearButtonAction(ActionEvent event) {
        display.setText("");
        firstNumber = 0;
        secondNumber = 0;
        currentOperation = "";
    }
}
