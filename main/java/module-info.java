module com.example.interfacetrabalho {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires MathParser.org.mXparser;

    opens com.example.interfacetrabalho to javafx.fxml;
    exports com.example.interfacetrabalho;
}