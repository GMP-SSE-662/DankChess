package chess_game;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        primaryStage.setTitle("Dank Chess");
        primaryStage.resizableProperty().setValue(false);

        Board mainBoard = new Board();
        mainBoard.draw();
        root.getChildren().add(mainBoard);
        for(int i = 0; i < Constants.TILES_PER_SIDE; i++){
            for(int j = 0; j < Constants.TILES_PER_SIDE; j++){
                root.getChildren().add(mainBoard.tiles[i][j]);
            }
        }

        primaryStage.setScene(new Scene(root, Constants.BOARD_SIZE, Constants.BOARD_SIZE));
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
