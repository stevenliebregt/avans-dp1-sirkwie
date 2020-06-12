package com.rickensteven.sirkwie.gui;

import com.rickensteven.sirkwie.gui.view.MainView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMain extends Application
{
    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 800;

    @Override
    public void start(Stage stage)
    {
        ViewModel viewModel = new ViewModel();
        Controller controller = new Controller(viewModel);
        MainView mainView = new MainView(controller, viewModel);

        Scene scene = new Scene(mainView.getView(), SCENE_WIDTH, SCENE_HEIGHT);

        stage.setTitle("Sirkwie - Rick Berkers & Steven Liebregt");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop()
    {
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
