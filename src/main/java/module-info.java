module com.example.jfx_employee {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jfx_employee to javafx.fxml;
    exports com.example.jfx_employee;
}