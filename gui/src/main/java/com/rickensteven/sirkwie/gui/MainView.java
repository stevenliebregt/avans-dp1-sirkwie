package com.rickensteven.sirkwie.gui;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Window;

public class MainView
{
    private MainViewController controller;
    private StackPane view;

    public MainView(MainViewController controller)
    {
        this.controller = controller;

        setupUi();
    }

    public Parent getView()
    {
        return view;
    }

    private void setupUi()
    {
        view = new StackPane();

        ToolBar toolBar = new ToolBar();

        Button loadFileButton = new Button("Load circuit file");
        loadFileButton.setOnMouseClicked((mouseEvent -> controller.loadFileButtonClicked(getView().getScene().getWindow())));

        Button simulateButton = new Button("Simulate");
        simulateButton.setOnMouseClicked((mouseEvent -> controller.simulateButtonClicked()));

        toolBar.getItems().addAll(loadFileButton, simulateButton);

        VBox vBox = new VBox(toolBar);

        view.getChildren().add(vBox);
    }
}
