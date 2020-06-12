package com.rickensteven.sirkwie.gui.view;

import com.rickensteven.sirkwie.core.ISimulationListener;
import com.rickensteven.sirkwie.core.domain.Circuit;
import com.rickensteven.sirkwie.core.domain.Node;
import com.rickensteven.sirkwie.gui.Controller;
import com.rickensteven.sirkwie.gui.ViewModel;
import javafx.scene.layout.StackPane;

public class LogView extends AbstractSimulationView implements ISimulationListener
{
    public LogView(Controller controller, ViewModel viewModel)
    {
        super(controller, viewModel);

        controller.addListener(this);
    }

    @Override
    protected void setupUi()
    {
        view = new StackPane();
    }

    @Override
    protected void draw(Circuit circuit)
    {

    }

    @Override
    public void onStartCalculate(Node node)
    {
        System.err.println(node.getName() + " starts calculating");
    }

    @Override
    public void onStopCalculate(Node node, boolean calculatedValue)
    {
        System.err.println(node.getName() + " stops calculating");
    }

    @Override
    protected void connectViewModel()
    {
        viewModel.circuitProperty.addListener((observable, oldValue, newValue) -> {
            newValue.addSimulationListener(this);
        });
    }
}
