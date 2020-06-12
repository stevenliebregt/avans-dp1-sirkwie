package com.rickensteven.sirkwie.gui;

import com.rickensteven.sirkwie.gui.graphstream.GraphstreamSimulationView;
import com.rickensteven.sirkwie.gui.text.TextSimulationView;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class MainView
{
    private final MainViewController controller;
    private final MainViewModel mainViewModel;

    private BorderPane view;
    private Button simulateButton;

    public MainView(MainViewController controller, MainViewModel mainViewModel)
    {
        this.controller = controller;
        this.mainViewModel = mainViewModel;

        setupUi();
        connectViewModel();

        // TODO: Maybe remove, useful for testing to load default circuit on startup
        controller.tryToLoadFile(ClassLoader.getSystemResource("Circuit1_FullAdder.txt").getPath());
        controller.simulateButtonClicked();
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

        // Set the input and output views
        InputView inputView = new InputView(controller, mainViewModel);
        view.setLeft(inputView.getView());

        ProbeView probeView = new ProbeView(controller, mainViewModel);
        view.setRight(probeView.getView());

        // Set the simulation views
        TextSimulationView textSimulationView = new TextSimulationView(controller, mainViewModel);
        GraphstreamSimulationView graphstreamSimulationView = new GraphstreamSimulationView(controller, mainViewModel);

        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        tabPane.getTabs().add(new Tab("Text", textSimulationView.getView()));
        tabPane.getTabs().add(new Tab("Graphstream", graphstreamSimulationView.getView()));

        view.setCenter(tabPane);
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
        simulateButton.setOnMouseClicked((mouseEvent -> controller.simulateButtonClicked())); // TODO: Update view correctly

        Pane spacer = new Pane();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button closeButton = new Button("Close");
        closeButton.setOnMouseClicked(controller::quit);

        toolBar.getItems().addAll(loadFileButton, simulateButton, spacer, closeButton);

        return toolBar;
    }
}
