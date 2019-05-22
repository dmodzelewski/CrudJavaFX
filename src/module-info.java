module ProjektJava {
    requires javafx.controls;
    requires javafx.fxml;
    requires sqlite.jdbc;
    requires java.sql;

    opens CrudJava;
}