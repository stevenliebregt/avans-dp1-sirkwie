package com.rickensteven.sirkwie.gui;

import com.rickensteven.sirkwie.core.domain.Circuit;
import javafx.scene.layout.Pane;

public abstract class AbstractSimulationView
{
    protected final MainViewController controller;
    protected final MainViewModel mainViewModel;
    protected final ImageLoader imageLoader;

    protected Pane view;

    public Pane getView()
    {
        return view;
    }

    public AbstractSimulationView(MainViewController controller, MainViewModel mainViewModel)
    {
        this.controller = controller;
        this.mainViewModel = mainViewModel;
        this.imageLoader = ImageLoader.getInstance();

        setupUi();
        connectViewModel();
    }

    protected abstract void setupUi();

    protected abstract void draw(Circuit circuit);

    protected void update(Circuit circuit)
    {
        // TODO: Empty implementation?
    }

    protected void connectViewModel()
    {
        mainViewModel.circuitProperty.addListener(((observable, oldValue, newValue) -> {
            handleCircuitUpdate(newValue);
        }));

        mainViewModel.circuitSimulatedTriggerProperty.addListener((observable, oldValue, newValue) -> {
            Circuit circuit = mainViewModel.circuitProperty.getValue();

            // TODO: remove log
            System.out.println(this.getClass().getName() + " -- Circuit was simulated");


            // TODO: IS this even necessary?
            //handleCircuitUpdate(circuit);
            update(circuit);
        });
    }

    private void handleCircuitUpdate(Circuit circuit)
    {
        if (circuit == null) {
            resetView();
            return;
        }

        draw(circuit);
    }

    protected void resetView()
    {
        view.getChildren().forEach(child -> view.getChildren().remove(child));
    }
}
