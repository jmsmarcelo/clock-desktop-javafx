module jmsmarcelo.clockdesktopjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens jmsmarcelo.clockdesktopjavafx to javafx.fxml;
    exports jmsmarcelo.clockdesktopjavafx;
}