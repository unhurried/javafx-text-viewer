module io.github.unhurried.jfxtv {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens io.github.unhurried.jfxtv to javafx.fxml;
    exports io.github.unhurried.jfxtv;
}
