module gw.test {
    requires kotlin.stdlib;
    requires kotlin.stdlib.jdk8;

    requires tornadofx;
    requires java.xml;

//    requires javafx.swing;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.web;
    requires java.desktop;
    requires javafx.fxml;

    // for ssl. to get the db file
    requires jdk.crypto.ec;

    opens com.example.demo.view to tornadofx;
    exports com.example.demo.app;
}
