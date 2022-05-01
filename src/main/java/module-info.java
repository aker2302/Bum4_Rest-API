module com.bum4.bum4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;
    requires gson;
    requires java.sql;
    requires java.desktop;
    requires javafx.swing;
    requires javafx.web;


    opens RestapiApplication to javafx.fxml;
    exports RestapiApplication;
    exports domain;
    opens domain to javafx.fxml;
    exports service;
    opens service to javafx.fxml;
    exports uiController;
    opens uiController to javafx.fxml;
}