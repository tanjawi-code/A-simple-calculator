import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.swing.*;
import java.util.Arrays;

public class Calculating {

    // For operators.
    @FXML
    private Button addButton, subButton, divisionButton, multiButton, percentButton, equalButton;
    // For numbers.
    @FXML
    private Button zeroButton, oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, eightButton, nineButton;
    // For options.
    @FXML
    private Button clearButton, removeButton, historyButton, decimalButton;
    // For output.
    @FXML
    private Label label;

    String[] numbers = {"0","1","2","3","4","5","6","7","8","9","."};
    String[] operators = {"+","-","*","/","%","="};
    String[] options = {"C","H",""};

    double firstNumber, secondNumber;
    String operator = null;
    double result;

    public void check(ActionEvent event){
        Button button = (Button) event.getSource();
        String value = button.getText();

        if(Arrays.asList(operators).contains(value)) {
            if (value.equals("=")) {
                calculate();
            }
            else {
                selectOperator(value);
            }
        }
        else if(Arrays.asList(options).contains(value)){
            option(value);
        }
        else if (Arrays.asList(numbers).contains(value)){
            checkOutput(value);
        }
    }

    // This is for selecting operators.
    private void selectOperator(String value) {
        switch (value) {
            case "+":
                firstNumber = Double.parseDouble(label.getText());
                operator = "+";
                label.setText("");
                break;
            case "-":
                firstNumber = Double.parseDouble(label.getText());
                operator = "-";
                label.setText("");
                break;
            case "*":
                firstNumber = Double.parseDouble(label.getText());
                operator = "*";
                label.setText("");
                break;
            case "/":
                firstNumber = Double.parseDouble(label.getText());
                operator = "/";
                label.setText("");
                break;
            case "%":
                firstNumber = Double.parseDouble(label.getText());
                operator = "%";
                label.setText("");
                break;
            default:
        }
    }

    // This is for calculating.
    private void calculate(){
        secondNumber = Double.parseDouble(label.getText());
        switch (operator){
            case "+" : result = firstNumber+secondNumber; break;
            case "-" : result = firstNumber-secondNumber; break;
            case "*" : result = firstNumber*secondNumber; break;
            case "/" : result = firstNumber/secondNumber; break;
            case "%" : result = firstNumber%secondNumber; break;
        }
        String text = String.valueOf(result);
        label.setText(text.substring(0,text.length()-2));
    }

    // This is for clearing symbols.
    private void option(String value){
        if(value.equals("C")){
            label.setText("0");
        }
        else if (value.equals("H")){

        }
        else{
            String text = label.getText();
            if(!text.isEmpty()){
                label.setText(text.substring(0,text.length()-1));
            }
            else {
                label.setText("0");
            }
        }
    }

    // This is for printing numbers.
    private void checkOutput(String value){
        if(value.equals(".")){
            if(!label.getText().contains(".")){
                label.setText(label.getText()+value);
            }
        }
        else if("0123456789".contains(value)){
            if(label.getText().equals("0")){
                label.setText(value);
            }
            else{
                label.setText(label.getText()+value);
            }
        }
    }
}
