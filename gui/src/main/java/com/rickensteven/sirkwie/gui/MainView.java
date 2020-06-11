package com.rickensteven.sirkwie.gui;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class MainView
{
    private MainViewController controller;
    private MainViewModel mainViewModel;

    private BorderPane view;
    private Button simulateButton;

    private SimulationView simulationView;

    public MainView(MainViewController controller, MainViewModel mainViewModel)
    {
        this.controller = controller;
        this.mainViewModel = mainViewModel;

        setupUi();
        connectViewModel();

        // TODO: Maybe remove, useful for testing to load default circuit on startup
        controller.tryToLoadFile(ClassLoader.getSystemResource("Circuit1_FullAdder.txt").getPath());
    }

    public Parent getView()
    {
        return view;
    }

    private void setupUi()
    {
        view = new BorderPane();
        view.setTop(setupUiToolbar());
        view.setCenter(new Label("Please select a circuit file first"));

        simulationView = new SimulationView(controller, mainViewModel);
        view.setCenter(simulationView.getView());
    }

    private void connectViewModel()
    {
        mainViewModel.circuitProperty.addListener(((observable, oldValue, newValue) -> {
            if (newValue == null) {
                simulateButton.setDisable(true);
                return;
            }

            simulateButton.setDisable(false);
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
}
