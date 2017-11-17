package view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("chessboard.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));

        Platform.setImplicitExit(false);
        Stage settingsPopup = new Stage();
        settingsPopup.setTitle("Board Settings");
        VBox popupLayout = new VBox();
        popupLayout.setAlignment(Pos.CENTER);
        popupLayout.getChildren().add(new Label("Please select the desired board size:"));

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton sml = new RadioButton("8x8 Tiled Board");
        RadioButton med = new RadioButton("16x16 Tiled Board");
        RadioButton lge = new RadioButton("32x32 Tiled Board");
        sml.setToggleGroup(toggleGroup);
        med.setToggleGroup(toggleGroup);
        lge.setToggleGroup(toggleGroup);
        Button confirmButton = new Button("Confirm");
        popupLayout.getChildren().addAll(sml, med, lge, confirmButton);
        Scene scene = new Scene(popupLayout, 300, 200);
        settingsPopup.setScene(scene);

//        settingsPopup.setOnHidden(() -> {
//            primaryStage.show();
//        });


        settingsPopup.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
