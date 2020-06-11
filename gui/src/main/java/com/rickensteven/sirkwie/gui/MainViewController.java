package com.rickensteven.sirkwie.gui;

import com.rickensteven.sirkwie.core.CircuitLoaderFacade;
import com.rickensteven.sirkwie.core.building.ANTLRCircuitParser;
import com.rickensteven.sirkwie.core.building.ICircuitParser;
import com.rickensteven.sirkwie.core.domain.Circuit;
import com.rickensteven.sirkwie.core.exception.CircuitInfiniteLoopException;
import com.rickensteven.sirkwie.core.exception.CircuitNotConnectedException;
import com.rickensteven.sirkwie.core.exception.CircuitSyntaxException;
import com.rickensteven.sirkwie.core.exception.NodeTypeUnknownException;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;

public class MainViewController
{
    private MainViewModel mainViewModel;
    private FileChooser fileChooser;
    private CircuitLoaderFacade circuitLoaderFacade;

    public MainViewController(MainViewModel mainViewModel)
    {
        this.mainViewModel = mainViewModel;
        fileChooser = new FileChooser();

        // This circuitparser could be swapped out for another, for example, XMLCircuitParser
        ICircuitParser circuitParser = new ANTLRCircuitParser();
        circuitLoaderFacade = new CircuitLoaderFacade(circuitParser);
    }

    public void loadFileButtonClicked(Window ownerWindow)
    {
        File selectedFile = fileChooser.showOpenDialog(ownerWindow);

        try {
            Circuit circuit = circuitLoaderFacade.loadCircuit(selectedFile.getAbsolutePath());
            mainViewModel.circuitProperty.setValue(circuit);
        } catch (IOException exception) {
            alert("The selected file could not be read");
        } catch (CircuitSyntaxException exception) {
            alert("The selected file contains syntax errors");
        } catch (CircuitInfiniteLoopException exception) {
            alert("The selected file contains an infinite loop");
        } catch (CircuitNotConnectedException exception) {
            alert("The selected file contains probes that are not reachable");
        } catch (NodeTypeUnknownException exception) {
            alert("The selected file contains unknown node types");
        }
    }

    public void simulateButtonClicked()
    {
        // TODO: Implement this
    }

    public void quit(MouseEvent mouseEvent)
    {
        Platform.exit();
    }

    private void alert(String message)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR, message);
        alert.showAndWait();
    }
}
