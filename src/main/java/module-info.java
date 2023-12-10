module com.example.jui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jui to javafx.fxml;
    exports com.example.jui;
}