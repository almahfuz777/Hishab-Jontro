package main;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class Controller {
    @FXML private Label display;
    @FXML private Label tempDisplay;
    @FXML private Pane btnClear,btnEqual,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnDot,btnBackspace,btnPlus,btnMinus,btnMultiply,btnDivide;

    //private String currentDisplay = (display != null)? display.getText(): "";
    private double num1;
    private String operator;
    @FXML public void numberClick(MouseEvent event){
        String value = ((Pane)event.getSource()).getId().replace("btn","");

        if (display.getText().equals("0")) {
            display.setText(value);
        } else {
            display.setText(display.getText() + value);
        }
    }
    @FXML
    public void symbolClick(MouseEvent event) {
        String symbol = ((Pane)event.getSource()).getId().replace("btn","");
        // Clear Screen
        if(symbol.equals("Clear")){
            display.setText("0");
            tempDisplay.setText("");
            num1 = 0;
        }
        // Dot
        else if(symbol.equals("Dot")){
            if(!(display.getText().contains("."))){ // checking for existing point
                if(display.getText().equals("0")) display.setText("0.");
                else display.setText(display.getText()+".");
            }
        }

        // Backspace
        else if(symbol.equals("Backspace")){
            String str = display.getText();
            str = str.substring(0, str.length()-1);
            display.setText(str);
        }
        // Result
        else if(symbol.equals("Equal")){
            double result = 0;
            double num2 = Double.parseDouble(display.getText());
            tempDisplay.setText(tempDisplay.getText()+display.getText()+"=");
            switch (operator){
                case "+" -> result = num1+num2;
                case "-" -> result = num1-num2;
                case "*" -> result = num1*num2;
                case "/" -> result = num1/num2;
            }
            display.setText(String.valueOf(result));
            num1 = result;
            operator = ".";
        }
        // Second number Input
        else{
            switch (symbol) {
                case "Plus" -> operator = "+";
                case "Minus" -> operator = "-";
                case "Multiply" -> operator = "*";
                case "Divide" -> operator = "/";
            }
            num1 = Double.parseDouble(display.getText());
            tempDisplay.setText(display.getText()+operator);
            display.setText("0");
        }
    }
    @FXML public void exit(){
        System.exit(0);
    }
    @FXML public void about() {

        String contentText = "Created and Maintained by:\nAl Mahfuz\nGitHub: github.com/almahfuz777";

        Alert alert = new Alert(Alert.AlertType.INFORMATION, contentText, ButtonType.OK);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        ImageView info = new ImageView("images/info.png");
        info.setFitHeight(48); info.setFitWidth(48);
        alert.setGraphic(info);

        alert.showAndWait();
    }

}
