package com.rickensteven.sirkwie.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage stage)
    {
        MainViewModel mainViewModel = new MainViewModel();
        MainViewController mainViewController = new MainViewController(mainViewModel);
        MainView mainView = new MainView(mainViewController, mainViewModel);

        Scene scene = new Scene(mainView.getView(), 640, 480);

        stage.setTitle("Sirkwie - Rick Berkers & Steven Liebregt");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
