package com.rickensteven.sirkwie.gui;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.*;

public class MainView
{
    private MainViewController controller;
    private MainViewModel mainViewModel;

    private BorderPane view;
    private Button simulateButton;

    public MainView(MainViewController controller, MainViewModel mainViewModel)
    {
        this.controller = controller;
        this.mainViewModel = mainViewModel;

        setupUi();
        connectViewModel();
    }

    public Parent getView()
    {
        return view;
    }

    private void setupUi()
    {
        view = new BorderPane();
        view.setTop(setupUiToolbar());
        view.setCenter(setupUiSimulation());
    }

    private void connectViewModel()
    {
        mainViewModel.circuitProperty.addListener(((observable, oldValue, newValue) -> {
            simulateButton.setDisable(newValue == null);
        }));
    }

    private ToolBar setupUiToolbar()
    {
        ToolBar toolBar = new ToolBar();

        Button loadFileButton = new Button("Load circuit file");
        loadFileButton.setOnMouseClicked((mouseEvent -> controller.loadFileButtonClicked(getView().getScene().getWindow())));

        simulateButton = new Button("Simulate");
        simulateButton.setDisable(true);
        simulateButton.setOnMouseClicked((mouseEvent -> controller.simulateButtonClicked()));

        Pane spacer = new Pane();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button closeButton = new Button("Close");
        closeButton.setOnMouseClicked(controller::quit);

        toolBar.getItems().addAll(loadFileButton, simulateButton, spacer, closeButton);

        return toolBar;
    }

    private Label setupUiSimulation()
    {
        // TODO: Display the simulation

        return new Label("Hello, world!");
    }
}
