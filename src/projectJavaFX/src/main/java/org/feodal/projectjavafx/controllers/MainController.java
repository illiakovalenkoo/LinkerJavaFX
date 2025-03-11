package org.feodal.projectjavafx.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.feodal.projectjavafx.DB;
import org.feodal.projectjavafx.HelloApplication;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button add_button;

    @FXML
    private TextField long_link_field;

    @FXML
    private TextField short_link_field;

    @FXML
    private VBox vbox;

    @FXML
    private Label console_label;

    private DB db = new DB();

    public static String ID;



    @FXML
    void initialize() throws IOException, SQLException {
        loadLinks();

        add_button.setOnAction(event -> {
            String longLink = long_link_field.getText();
            String shortLink = short_link_field.getText();

            if(!(longLink.startsWith("http") || longLink.startsWith("www"))) {
                long_link_field.setStyle("-fx-border-color: red");
                console_label.setText("Enter link");
                console_label.setStyle("-fx-text-fill: red");
            } else if(shortLink.isEmpty()) {
                short_link_field.setStyle("-fx-border-color: red");
                console_label.setText("Too short title");
                console_label.setStyle("-fx-text-fill: red");
            }
            else if(db.isExists(shortLink)) {
                short_link_field.setStyle("-fx-border-color: red");
                console_label.setText("This title already exists");
                console_label.setStyle("-fx-text-fill: red ");
            } else {
                db.addLink(longLink, shortLink);
                short_link_field.setText("");
                long_link_field.setText("");
                console_label.setText("");
                long_link_field.setStyle("-fx-border-color: #0b003d");
                short_link_field.setStyle("-fx-border-color: #0b003d");
                console_label.setStyle("-fx-text-fill: #FFFFFF");
                console_label.setText("Done");

                try {
                    loadLinks();
                } catch (IOException | SQLException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void loadLinks() throws IOException, SQLException {
        ResultSet resultSet = db.getAll();
        vbox.getChildren().clear();
        while(resultSet.next()) {
            Node node = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("link.fxml")));

            Label shortText = (Label) node.lookup("#short_link_label");
            shortText.setText(resultSet.getString("short_link"));

            node.setOnMouseEntered(mouseEvent ->  {
                node.setStyle("-fx-background-color: #0291b5");
            });

            node.setOnMouseExited(mouseEvent -> {
                node.setStyle("-fx-background-color: #343434");
            });

            String localID = resultSet.getString("id");

            node.setOnMouseClicked(mouseEvent ->  {
                ID = localID;
                Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
                try {
                    HelloApplication.setScene("fullText.fxml", stage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            vbox.getChildren().add(node);
            vbox.setSpacing(10);
        }
    }


}
