package com.rickensteven.sirkwie.gui;

import com.rickensteven.sirkwie.core.CircuitLoaderFacade;
import com.rickensteven.sirkwie.core.domain.Circuit;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainViewController
{
    private FileChooser fileChooser;
    private CircuitLoaderFacade circuitLoaderFacade;

    public MainViewController()
    {
        fileChooser = new FileChooser();
        circuitLoaderFacade = new CircuitLoaderFacade();
    }

    public void loadFileButtonClicked(Window ownerWindow)
    {
        File selectedFile = fileChooser.showOpenDialog(ownerWindow);

        try {
            Circuit circuit = circuitLoaderFacade.loadCircuit(selectedFile.getAbsolutePath());
            System.out.println(circuit); // TODO:
        } catch (IOException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "The selected file could not be read");
            alert.showAndWait();
        } // TODO: Error for invalid file
    }

    public void simulateButtonClicked()
    {
        // TODO: Implement this
    }

    public void quit(MouseEvent mouseEvent)
    {
        Platform.exit();
    }
}
