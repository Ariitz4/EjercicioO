module es.aritzherrero.ejercicioo {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.aritzherrero.ejercicioo to javafx.fxml,javafx.base;
    exports es.aritzherrero.ejercicioo;
}