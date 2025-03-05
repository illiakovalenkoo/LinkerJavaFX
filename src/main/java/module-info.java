module org.feodal.projectjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens org.feodal.projectjavafx to javafx.fxml;
    exports org.feodal.projectjavafx;
    exports org.feodal.projectjavafx.controllers;
    opens org.feodal.projectjavafx.controllers to javafx.fxml;
}