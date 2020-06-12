package com.rickensteven.sirkwie.gui.view.text;

import com.rickensteven.sirkwie.core.domain.Circuit;
import com.rickensteven.sirkwie.gui.view.AbstractSimulationView;
import com.rickensteven.sirkwie.gui.Controller;
import com.rickensteven.sirkwie.gui.ViewModel;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class TextSimulationView extends AbstractSimulationView
{
    private final TextNodeDrawingVisitor visitor;

    public TextSimulationView(Controller controller, ViewModel viewModel)
    {
        super(controller, viewModel);

        visitor = new TextNodeDrawingVisitor();
    }

    @Override
    protected void setupUi()
    {
        view = new StackPane();
    }

    @Override
    protected void draw(Circuit circuit)
    {
        // TODO:
        VBox vBox = new VBox();

        circuit.getNodes().forEach(node -> {
            String name = node.getName();

            node.accept(visitor);

            Label label = new Label("NODE: " + name + " = " + visitor.getValue());
            vBox.getChildren().add(label);
        });

        view.getChildren().add(vBox);
    }
}
