package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    static boolean isNormalBoard;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("chessboard.fxml"));
        primaryStage.resizableProperty().setValue(false);
        primaryStage.setTitle("Dank Chess");

        Stage settingsPopup = new Stage();

        VBox choices = new VBox(5);
        choices.setAlignment(Pos.CENTER_LEFT);
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton sml = new RadioButton("8x8 Tiled Board");
        RadioButton lge = new RadioButton("16x16 Tiled Board");
        sml.setToggleGroup(toggleGroup);
        lge.setToggleGroup(toggleGroup);
        sml.setSelected(true);
        choices.getChildren().addAll(sml, lge);

        VBox confirmContainer = new VBox();
        confirmContainer.setAlignment(Pos.CENTER);
        Button confirmButton = new Button("Confirm");
        confirmButton.setOnAction(e -> {
            if (toggleGroup.getSelectedToggle().equals(sml)) {
                isNormalBoard = true;
                primaryStage.setScene(new Scene(root, 640, 360));
            } else {
                isNormalBoard = false;
                primaryStage.setScene(new Scene(root, 900, 720));
            }
            settingsPopup.close();
            primaryStage.show();
        });
        confirmContainer.getChildren().add(confirmButton);

        BorderPane popupLayout = new BorderPane();
        popupLayout.setTop(new Label("Please select the desired board size:"));
        popupLayout.setCenter(choices);
        popupLayout.setBottom(confirmContainer);
        Scene popupScene = new Scene(popupLayout, 250, 80);

        settingsPopup.setTitle("Board Settings");
        settingsPopup.setScene(popupScene);
        settingsPopup.resizableProperty().setValue(false);
        settingsPopup.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
