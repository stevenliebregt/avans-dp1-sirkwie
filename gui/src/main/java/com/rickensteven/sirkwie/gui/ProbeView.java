package com.rickensteven.sirkwie.gui;

import com.rickensteven.sirkwie.core.domain.Circuit;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.LinkedHashMap;
import java.util.Map;

public class ProbeView extends AbstractSimulationView
{
    private static final int WIDTH = 100;
    private Map<String, Button> probeButtons;

    public ProbeView(MainViewController controller, MainViewModel mainViewModel)
    {
        super(controller, mainViewModel);

        probeButtons = new LinkedHashMap<>();
    }

    @Override
    protected void setupUi()
    {
        view = new StackPane();
        view.setMinWidth(WIDTH);
        view.setMaxWidth(WIDTH);
        view.setBorder(
                new Border(
                        new BorderStroke(
                                Color.BLACK,
                                BorderStrokeStyle.SOLID,
                                CornerRadii.EMPTY,
                                new BorderWidths(0, 0, 0, 1))
                )
        );
    }

    @Override
    protected void draw(Circuit circuit)
    {
        VBox vBox = new VBox();

        circuit.getProbes().forEach(probe -> {
            Button button = new Button(probe.getName(), getImageView(probe.getValue()));
            button.setContentDisplay(ContentDisplay.TOP);

            probeButtons.put(probe.getName(), button);
        });

        vBox.getChildren().addAll(probeButtons.values());
        view.getChildren().add(vBox); // TODO: Check
    }

    @Override
    protected void update(Circuit circuit)
    {
        circuit.getProbes().forEach(probe -> probeButtons.get(probe.getName()).setGraphic(getImageView(probe.getValue())));
    }

    private ImageView getImageView(boolean value)
    {
        ImageView imageView = value
                ? imageLoader.loadView("bulb-on.png")
                : imageLoader.loadView("bulb-off.png");

        imageView.setFitWidth(32);
        imageView.setFitHeight(32);

        return imageView;
    }
}
