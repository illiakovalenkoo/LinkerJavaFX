package org.feodal.projectjavafx.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.feodal.projectjavafx.DB;
import org.feodal.projectjavafx.HelloApplication;
import org.w3c.dom.Text;

public class FullTextController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back_btn;

    @FXML
    private Button delete_btn;

    @FXML
    private TextField full_text;

    @FXML
    private TextField short_text;

    private DB db = new DB();

    @FXML
    void initialize() throws SQLException {
        String idLink = MainController.ID;
        ResultSet resultSet = db.getOneLink(idLink);
        while (resultSet.next()) {
            String longLink = resultSet.getString("long_link");
            String shortLink = resultSet.getString("short_link");
            full_text.setText(longLink);
            short_text.setText(shortLink);
        }

        back_btn.setOnAction(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                HelloApplication.setScene("main.fxml", stage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        delete_btn.setOnAction(event -> {
            db.deleteLink(idLink);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                HelloApplication.setScene("main.fxml", stage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });



    }

}
