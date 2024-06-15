module org.example.cryptosistema {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.cryptosistema to javafx.fxml;
    exports org.example.cryptosistema;
}