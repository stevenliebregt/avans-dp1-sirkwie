package com.rickensteven.sirkwie.gui;

import com.rickensteven.sirkwie.core.CircuitLoaderFacade;
import com.rickensteven.sirkwie.core.ISimulationListener;
import com.rickensteven.sirkwie.core.domain.Circuit;
import com.rickensteven.sirkwie.core.domain.Input;
import com.rickensteven.sirkwie.core.exception.*;
import com.rickensteven.sirkwie.core.parsing.CircuitParserFactory;
import com.rickensteven.sirkwie.core.parsing.ICircuitParser;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;

public class Controller
{
    private final ViewModel viewModel;
    private final FileChooser fileChooser;
    private final CircuitParserFactory circuitParserFactory;
    private final CircuitLoaderFacade circuitLoaderFacade;

    public Controller(ViewModel viewModel)
    {
        this.viewModel = viewModel;
        fileChooser = new FileChooser();
        circuitParserFactory = new CircuitParserFactory();

        circuitLoaderFacade = new CircuitLoaderFacade();

        viewModel.setParserNames(circuitParserFactory.circuitParserNames);
        setCircuitParser(
                circuitParserFactory
                        .circuitParserNames
                        .stream()
                        .findFirst()
                        .orElse(null)
        );
    }

    public void loadFileButtonClicked(Window ownerWindow)
    {
        File selectedFile = fileChooser.showOpenDialog(ownerWindow);

        if (selectedFile == null) { // Cancel clicked in dialog
            return;
        }

        tryToLoadFile(selectedFile.getAbsolutePath());
        simulateButtonClicked();
    }

    public void simulateButtonClicked()
    {
        Circuit circuit = viewModel.circuitProperty.getValue();

        if (circuit == null) {
            alert("There was a problem loading the circuit");
            return;
        }

        simulate(circuit);
    }

    public void quit(MouseEvent mouseEvent)
    {
        Platform.exit();
        System.exit(0);
    }

    public void tryToLoadFile(String filePath)
    {
        try {
            Circuit circuit = circuitLoaderFacade.loadCircuit(filePath);

            if (circuit == null) {
                alert("There was a problem loading the circuit");
                return;
            }

            circuit.addSimulationListener(viewModel.propagationDelayCalculator);

            viewModel.circuitProperty.setValue(circuit);
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
        } catch (NodeNotParentable exception) {
            alert("The selected file contains specified nodes as children that cannot be children");
        }
    }

    public void inputButtonClicked(String nodeName)
    {
        Circuit circuit = viewModel.circuitProperty.getValue();

        if (circuit == null) {
            return;
        }

        Input input = circuit.getInput(nodeName);

        if (input == null) {
            return;
        }

        input.setValue(!input.getValue());
        simulate(circuit);
    }

    public void addListener(ISimulationListener simulationListener)
    {
        circuitLoaderFacade.addSimulationListener(simulationListener);
    }

    private void simulate(Circuit circuit)
    {
        viewModel.circuitSimulateStartTriggerProperty.setValue(!viewModel.circuitSimulatedTriggerProperty.getValue());
        circuit.simulate();
        viewModel.circuitSimulatedTriggerProperty.setValue(!viewModel.circuitSimulatedTriggerProperty.getValue());
    }

    private void alert(String message)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR, message);
        alert.showAndWait();
    }

    public void setCircuitParser(String name)
    {
        ICircuitParser circuitParser = circuitParserFactory.getCircuitParser(name);

        if (circuitParser == null) {
            alert("Chosen option does not have a valid parser");
            return;
        }

         circuitLoaderFacade.setCircuitParser(circuitParser);
    }
}
