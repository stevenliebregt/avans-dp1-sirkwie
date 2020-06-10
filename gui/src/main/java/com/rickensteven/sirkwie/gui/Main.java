package com.rickensteven.sirkwie.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage stage)
    {
        MainViewController mainViewController = new MainViewController();
        MainView mainView = new MainView(mainViewController);

        Scene scene = new Scene(mainView.getView(), 640, 480);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
