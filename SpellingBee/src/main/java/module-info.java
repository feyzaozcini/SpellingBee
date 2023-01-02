module com.example.spellingbee1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.spellingbee1 to javafx.fxml;
    exports com.example.spellingbee1;
}