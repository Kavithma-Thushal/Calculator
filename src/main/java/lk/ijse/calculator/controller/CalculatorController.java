package lk.ijse.calculator.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.regex.Pattern;

public class CalculatorController {

    @FXML
    private TextField display;

    private double firstNumber = 0;
    private double secondNumber = 0;
    private String currentOperation = "";

    private boolean operationSelected = false;

    @FXML
    private void handleNumberButtonAction(ActionEvent event) {
        Button button = (Button) event.getSource();
        String currentText = display.getText();
        if (operationSelected) {
            display.setText(currentText + button.getText());
            operationSelected = false;
        } else {
            display.setText(currentText + button.getText());
        }
    }


    @FXML
    private void handleOperationButtonAction(ActionEvent event) {
        Button button = (Button) event.getSource();
        firstNumber = Double.parseDouble(display.getText());
        currentOperation = button.getText();
        display.setText(display.getText() + currentOperation);
        operationSelected = true;
    }

    @FXML
    private void handleDecimalButtonAction(ActionEvent event) {
        String currentText = display.getText();
        if (!currentText.contains(".")) {
            display.setText(currentText + ".");
        }
    }

    @FXML
    private void handleClearButtonAction(ActionEvent event) {
        display.setText("");
        firstNumber = 0;
        secondNumber = 0;
        currentOperation = "";
    }

    @FXML
    private void handleEqualButtonAction(ActionEvent event) {
        String[] numbers = display.getText().split(Pattern.quote(currentOperation), 2);
        if (numbers.length < 2) {
            // Error handling: the second number is missing
            return;
        }
        double secondNumber = Double.parseDouble(numbers[1]);
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
}
