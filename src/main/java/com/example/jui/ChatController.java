package com.example.jui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements Initializable {
    @FXML
    private VBox myVBox;
    @FXML
    private Button send1;
    @FXML
    private Button send2;
    @FXML
    private TextArea textArea1;
    @FXML
    private TextArea textArea2;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Font font = Font.loadFont(getClass().getResourceAsStream("/Fonts/Quicksand-Bold.ttf"), 18);
        send1.setFont(font);
        send2.fontProperty().bind(send1.fontProperty());
        textArea1.fontProperty().bind(send1.fontProperty());
        textArea2.fontProperty().bind(send1.fontProperty());
        myVBox.setBackground(Background.fill(Color.AQUAMARINE));
        send1.setOnAction(event -> {
            addLabel(textArea1, TextAlignment.LEFT, Pos.CENTER_LEFT);
        });
        send2.setOnAction(event -> {
            addLabel(textArea2, TextAlignment.RIGHT, Pos.CENTER_RIGHT);
        });
    }

    private void addLabel(TextArea textArea, TextAlignment textAlignment, Pos pos) {
        if (textArea.getText().isEmpty()) return;
        Label label = new Label(textArea.getText());
        label.setWrapText(true);
        textArea.clear();
        label.fontProperty().bind(send1.fontProperty());
        label.setTextAlignment(textAlignment);
        label.setAlignment(pos);
        VBox.setMargin(label, new Insets(10, 10, 10, 10));
        label.maxWidthProperty().bind(myVBox.widthProperty());
        label.maxHeightProperty().bind(myVBox.heightProperty());
        label.prefWidthProperty().bind(myVBox.prefWidthProperty());
        myVBox.getChildren().add(label);
    }
}