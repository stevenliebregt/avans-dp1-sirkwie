package com.rickensteven.sirkwie.gui.view;

import com.rickensteven.sirkwie.gui.Controller;
import com.rickensteven.sirkwie.gui.ViewModel;
import com.rickensteven.sirkwie.gui.view.graphstream.GraphstreamSimulationView;
import com.rickensteven.sirkwie.gui.view.text.TextSimulationView;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class MainView
{
    private final Controller controller;
    private final ViewModel viewModel;

    private BorderPane view;
    private Button simulateButton;

    public MainView(Controller controller, ViewModel viewModel)
    {
        this.controller = controller;
        this.viewModel = viewModel;

        setupUi();
        connectViewModel();

        // Load the full-adder circuit on startup so it is not so empty.
        controller.tryToLoadFile("/Circuit1_FullAdder.txt");
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
        InputView inputView = new InputView(controller, viewModel);
        view.setLeft(inputView.getView());

        ProbeView probeView = new ProbeView(controller, viewModel);
        view.setRight(probeView.getView());

        // Set the simulation views
        TextSimulationView textSimulationView = new TextSimulationView(controller, viewModel);
        GraphstreamSimulationView graphstreamSimulationView = new GraphstreamSimulationView(controller, viewModel);

        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        tabPane.getTabs().add(new Tab("Text", textSimulationView.getView()));
        tabPane.getTabs().add(new Tab("Graphstream", graphstreamSimulationView.getView()));

        // Add the log view
        LogView logView = new LogView(controller, viewModel);

        // Create pane which has log and tab
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(tabPane);
        borderPane.setBottom(logView.getView());

        view.setCenter(borderPane);
    }

    private void connectViewModel()
    {
        viewModel.circuitProperty.addListener(((observable, oldValue, newValue) -> {
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
