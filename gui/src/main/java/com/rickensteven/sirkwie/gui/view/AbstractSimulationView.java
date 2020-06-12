package com.rickensteven.sirkwie.gui.view;

import com.rickensteven.sirkwie.core.domain.Circuit;
import com.rickensteven.sirkwie.gui.Controller;
import com.rickensteven.sirkwie.gui.ImageLoader;
import com.rickensteven.sirkwie.gui.ViewModel;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public abstract class AbstractSimulationView
{
    protected final Controller controller;
    protected final ViewModel viewModel;
    protected final ImageLoader imageLoader;

    protected Pane view;

    public Pane getView()
    {
        return view;
    }

    public AbstractSimulationView(Controller controller, ViewModel viewModel)
    {
        this.controller = controller;
        this.viewModel = viewModel;
        this.imageLoader = ImageLoader.getInstance();

        setupUi();
        connectViewModel();
    }

    protected abstract void setupUi();

    protected abstract void draw(Circuit circuit);

    protected void update(Circuit circuit)
    {
        resetView();
        draw(circuit);
    }

    protected void connectViewModel()
    {
        viewModel.circuitProperty.addListener(((observable, oldValue, newValue) -> {
            if (newValue == null) {
                resetView();
                return;
            }

            resetView();
            draw(newValue);
        }));

        viewModel.circuitSimulatedTriggerProperty.addListener((observable, oldValue, newValue) -> {
            Circuit circuit = viewModel.circuitProperty.getValue();
            update(circuit);
        });
    }

    protected void resetView()
    {
        view.getChildren().removeAll(new ArrayList<>(view.getChildren()));
    }
}
