package chess_game;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        primaryStage.setTitle("Dank Chess");
        primaryStage.resizableProperty().setValue(false);

        Stage settingsPopup = new Stage();
        settingsPopup.setTitle("Board Settings");
        settingsPopup.resizableProperty().setValue(false);

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
            int boardSize = getBoardSize(toggleGroup.getSelectedToggle().equals(sml));
            settingsPopup.close();
            root.getChildren().add(new Board(boardSize));
            primaryStage.setScene(new Scene(root, boardSize + Constants.scoreboardWidth, boardSize));
            primaryStage.sizeToScene();
            primaryStage.show();
        });
        confirmContainer.getChildren().add(confirmButton);

        BorderPane popupLayout = new BorderPane();
        popupLayout.setTop(new Label("Please select the desired board size:"));
        popupLayout.setCenter(choices);
        popupLayout.setBottom(confirmContainer);
        Scene popupScene = new Scene(popupLayout, 250, 80);

        settingsPopup.setScene(popupScene);
        settingsPopup.show();
    }

    private int getBoardSize(boolean isSmallBoard) {
        return isSmallBoard ? Constants.smallBoardSize : Constants.largeBoardSize;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
