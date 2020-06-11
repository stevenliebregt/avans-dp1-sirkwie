package com.rickensteven.sirkwie.gui;

import com.rickensteven.sirkwie.core.domain.Circuit;
import com.rickensteven.sirkwie.core.domain.Input;
import com.rickensteven.sirkwie.core.domain.Node;
import com.rickensteven.sirkwie.core.domain.NodeComposite;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.fx_viewer.FxViewPanel;
import org.graphstream.ui.fx_viewer.FxViewer;
import org.graphstream.ui.javafx.FxGraphRenderer;
import org.graphstream.ui.view.Viewer;

import java.util.List;
import java.util.Set;

public class SimulationView
{
    private MainViewController controller;
    private MainViewModel mainViewModel;

    private GraphNodeDrawingVisitor visitor = new GraphNodeDrawingVisitor();
    private Graph graph;

    private StackPane view;

    public SimulationView(MainViewController controller, MainViewModel mainViewModel)
    {
        this.controller = controller;
        this.mainViewModel = mainViewModel;

        setupUi();
        connectViewModel();
    }

    public Pane getView()
    {
        return view;
    }

    private void setupUi()
    {
        view = new StackPane();
    }

    private void draw(Circuit circuit)
    {
        graph = new SingleGraph("Sirkwie");

        // TODO:

        drawNodes(circuit);
        drawEdges(circuit);

        // TODO:

        FxViewer graphViewer = new FxViewer(graph, FxViewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        graphViewer.enableAutoLayout();

        view.getChildren().add((FxViewPanel) graphViewer.addView(FxViewer.DEFAULT_VIEW_ID, new FxGraphRenderer()));
    }

    private void drawNodes(Circuit circuit)
    {
        circuit.getNodes().forEach(node -> {
            // TODO: Use visitor to determine what to draw

            String name = node.getName();

            graph.addNode(name);
            graph.getNode(name).setAttribute("ui.label", name + System.lineSeparator() + System.lineSeparator());
        });
    }

    private void drawEdges(Circuit circuit)
    {
        circuit.getNodes().forEach(node -> {
            if (node instanceof NodeComposite) {
                List<Node> parents = ((NodeComposite) node).getParents();

                String name = node.getName();

                parents.forEach(parent -> {
                    String parentName = parent.getName();

                    graph.addEdge(name + parentName, name, parentName);
                });
            }
        });
    }

    private void connectViewModel()
    {
        mainViewModel.circuitProperty.addListener(((observable, oldValue, newValue) -> {
            if (newValue == null) {
                view.getChildren().forEach(child -> view.getChildren().remove(child));
                return;
            }

            draw(newValue);
        }));
    }
}
