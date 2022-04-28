module com.bum4.bum4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;
    requires gson;
    requires java.sql;
    requires batik.transcoder;
    requires java.desktop;
    requires javafx.swing;
    requires javafx.web;


    opens com.bum4.bum4 to javafx.fxml;
    exports com.bum4.bum4;
}