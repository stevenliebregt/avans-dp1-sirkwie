package com.rickensteven.sirkwie.gui.graphstream;

import com.rickensteven.sirkwie.core.domain.*;
import com.rickensteven.sirkwie.gui.AbstractSimulationView;
import com.rickensteven.sirkwie.gui.MainViewController;
import com.rickensteven.sirkwie.gui.MainViewModel;
import javafx.scene.layout.StackPane;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.fx_viewer.FxViewPanel;
import org.graphstream.ui.fx_viewer.FxViewer;
import org.graphstream.ui.javafx.FxGraphRenderer;
import org.graphstream.ui.layout.springbox.implementations.LinLog;
import org.graphstream.ui.view.View;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class GraphstreamSimulationView extends AbstractSimulationView
{
    private GraphNodeDrawingVisitor visitor = new GraphNodeDrawingVisitor();
    private MultiGraph graph;

    public GraphstreamSimulationView(MainViewController controller, MainViewModel mainViewModel)
    {
        super(controller, mainViewModel);
    }

    protected void setupUi()
    {
        System.setProperty("org.graphstream.ui.renderer",
                "org.graphstream.ui.j2dviewer.J2DGraphRenderer");

        view = new StackPane();
    }

    protected void draw(Circuit circuit)
    {
        graph = new MultiGraph("Sirkwie");
        graph.setAttribute("ui.stylesheet", getStyleSheet());

        drawNodes(circuit);
        drawEdges(circuit);

        graph.setAttribute("layout.quality", 4);

        FxViewer graphViewer = new FxViewer(graph, FxViewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        graphViewer.enableAutoLayout(new LinLog(false));

        View graphView = graphViewer.addView(FxViewer.DEFAULT_VIEW_ID, new FxGraphRenderer());

        view.getChildren().add((FxViewPanel) graphView);
    }

    private void drawNodes(Circuit circuit)
    {
        circuit.getNodes().forEach(node -> {
            String name = node.getName();

            node.accept(visitor);
            GraphNodeData nodeData = visitor.getValue();

            graph.addNode(name);
            graph.getNode(name).setAttribute("ui.label", nodeData.name + " " + nodeData.type);
            graph.getNode(name).setAttribute("ui.class", node.getValue() ? "on" : "off"); // TODO: ON | OFF
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

                    graph.addEdge(name + parentName, parentName, name, true);
                });
            }
        });
    }

    protected void connectViewModel()
    {
        mainViewModel.circuitProperty.addListener(((observable, oldValue, newValue) -> {
            if (newValue == null) {
                view.getChildren().forEach(child -> view.getChildren().remove(child));
                return;
            }

            draw(newValue);
        }));
    }

    private String getStyleSheet()
    {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("stylesheet.css");

        if (inputStream == null) return "";

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            return bufferedReader.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (Exception exception) {
            return "";
        }
    }
}
