package com.rickensteven.sirkwie.gui.view;

import com.rickensteven.sirkwie.core.domain.Circuit;
import com.rickensteven.sirkwie.gui.Controller;
import com.rickensteven.sirkwie.gui.ViewModel;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.LinkedHashMap;
import java.util.Map;

public class ProbeView extends AbstractSimulationView
{
    private static final int WIDTH = 80;
    private Map<String, Button> probeButtons;

    public ProbeView(Controller controller, ViewModel viewModel)
    {
        super(controller, viewModel);
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
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(4);

        probeButtons = new LinkedHashMap<>();

        circuit.getProbes().forEach(probe -> {
            Button button = new Button(probe.getName(), getImageView(probe.getValue()));
            button.setContentDisplay(ContentDisplay.TOP);
            button.setPrefSize(60, 60);

            probeButtons.put(probe.getName(), button);
        });

        vBox.getChildren().addAll(probeButtons.values());
        view.getChildren().add(vBox);
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
