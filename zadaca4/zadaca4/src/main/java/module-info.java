module com.ptf.rs.zadaca4 {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.desktop;
	requires javafx.base;
	requires java.sql;
	requires java.sql.rowset;

    opens com.ptf.rs.zadaca4 to javafx.fxml;
    exports com.ptf.rs.zadaca4;

    opens com.ptf.rs.zadaca4.controllers to javafx.fxml;
    exports com.ptf.rs.zadaca4.controllers;
    
    opens com.ptf.rs.zadaca4.models to javafx.fxml;
    exports com.ptf.rs.zadaca4.models;

}