package com.rickensteven.sirkwie.gui.text;

import com.rickensteven.sirkwie.core.domain.Circuit;
import com.rickensteven.sirkwie.gui.AbstractSimulationView;
import com.rickensteven.sirkwie.gui.MainViewController;
import com.rickensteven.sirkwie.gui.MainViewModel;

public class TextSimulationView extends AbstractSimulationView
{
    public TextSimulationView(MainViewController controller, MainViewModel mainViewModel)
    {
        super(controller, mainViewModel);
    }

    @Override
    protected void setupUi()
    {
        // TODO:
    }

    private void draw(Circuit circuit)
    {
        // TODO:
    }

    @Override
    protected void connectViewModel()
    {
        mainViewModel.circuitProperty.addListener(((observable, oldValue, newValue) -> {
            if (newValue == null) {
                view.getChildren().forEach(child -> view.getChildren().remove(child));
                return;
            }

            draw(newValue);
        }));

        mainViewModel.circuitSimulatedTriggerProperty.addListener((observable, oldValue, newValue) -> {
            Circuit circuit = mainViewModel.circuitProperty.getValue();

            System.err.println("Circuit was simulated");
        });
    }
}
