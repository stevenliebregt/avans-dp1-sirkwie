package com.rickensteven.sirkwie.gui;

import com.rickensteven.sirkwie.core.domain.Circuit;
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

    private String labelText;

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
        view.setCenter(new Label("Please select a circuit file first"));
    }

    private void connectViewModel()
    {
        mainViewModel.circuitProperty.addListener(((observable, oldValue, newValue) -> {
            if (newValue == null) {
                simulateButton.setDisable(true);
                return;
            }

            simulateButton.setDisable(false);
            view.setCenter(setupUiSimulation());
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
        Circuit circuit = mainViewModel.circuitProperty.getValue();
        labelText = "";
        NodeDrawingVisitor drawingVisitor = new NodeDrawingVisitor();
        circuit.getInputs().forEach(input -> {
            input.accept(drawingVisitor);
            labelText += (drawingVisitor.getValue() + System.lineSeparator());
        });
        circuit.getProbes().forEach(probe -> {
            probe.accept(drawingVisitor);
            labelText += (drawingVisitor.getValue() + System.lineSeparator());
        });
        return new Label(labelText);
    }
}
