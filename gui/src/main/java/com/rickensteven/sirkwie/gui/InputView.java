package com.rickensteven.sirkwie.gui;

import com.rickensteven.sirkwie.core.domain.Circuit;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.LinkedHashMap;
import java.util.Map;

public class InputView extends AbstractSimulationView
{
    private static final int WIDTH = 100;
    private Map<String, Button> inputButtons;

    public InputView(MainViewController controller, MainViewModel mainViewModel)
    {
        super(controller, mainViewModel);

        inputButtons = new LinkedHashMap<>();
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
                                new BorderWidths(0, 1, 0, 0))
                )
        );
    }

    @Override
    protected void draw(Circuit circuit)
    {
        VBox vBox = new VBox();

        circuit.getInputs().forEach(input -> {
            Button button = new Button(input.getName(), getImageView(input.getValue()));
            button.setContentDisplay(ContentDisplay.TOP);
            button.setOnMouseClicked((mouseEvent -> controller.inputButtonClicked(input.getName())));

            inputButtons.put(input.getName(), button);
        });

        vBox.getChildren().addAll(inputButtons.values());
        view.getChildren().add(vBox); // TODO: Check
    }

    @Override
    protected void update(Circuit circuit)
    {
        circuit.getInputs().forEach(input -> inputButtons.get(input.getName()).setGraphic(getImageView(input.getValue())));
    }

    private ImageView getImageView(boolean value)
    {
        ImageView imageView = value
                ? imageLoader.loadView("switch-on.png")
                : imageLoader.loadView("switch-off.png");

        imageView.setFitWidth(32);
        imageView.setFitHeight(32);

        return imageView;
    }
}
