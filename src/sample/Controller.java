package sample;

import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.fxml.FXML;

public class Controller{

    public Label lableOne;
    public TextField keyField;
    public TextArea tableText;
    public TextArea inputText;
    public TextArea outputText;
    public Boolean EncodeMode = Boolean.TRUE;
    public Encoder encoder;

    @FXML
    public void initialize () {
        inputText.setText("Hello World!");
        encoder = new Encoder();
        KeyChanged();
    }

    public void EncodeModeOn () {
        System.out.println("Encode mode");
        EncodeMode = Boolean.TRUE;
        InputTextChanged();
    }

    public void DecodeModeOn () {
        System.out.println("Decode mode");
        EncodeMode = Boolean.FALSE;
        InputTextChanged();
    }

    public void InputTextChanged () {
        String text = inputText.getText();
        String outText;
        if (EncodeMode)
            outText = encoder.Encode(text);
        else
            outText = encoder.Decode(text);
        outputText.setText(outText);
    }

    public void  KeyChanged () {
        String text = "";
        encoder.setKey(keyField.getText());
        for (char symbol = 'A'; symbol <= 'Z'; symbol++) {
            text += symbol + "->" + encoder.Encode(Character.toString(symbol)) + "\n";
        }
        tableText.setText(text);
        InputTextChanged();
    }
}
