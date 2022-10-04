module com.johannes.fractal {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.johannes.fractal to javafx.fxml;
    exports com.johannes.fractal;
}
