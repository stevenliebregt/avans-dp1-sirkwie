package com.rickensteven.sirkwie.gui.view.graphstream;

import com.rickensteven.sirkwie.core.domain.Circuit;
import com.rickensteven.sirkwie.core.domain.Node;
import com.rickensteven.sirkwie.core.domain.NodeComposite;
import com.rickensteven.sirkwie.gui.view.AbstractSimulationView;
import com.rickensteven.sirkwie.gui.Controller;
import com.rickensteven.sirkwie.gui.ViewModel;
import javafx.application.Platform;
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
    private final GraphNodeDrawingVisitor visitor;
    private MultiGraph graph;

    public GraphstreamSimulationView(Controller controller, ViewModel viewModel)
    {
        super(controller, viewModel);

        visitor = new GraphNodeDrawingVisitor();
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

        // Stop the auto-layout when it is stable, which should be reached in about 1 second, so we can freely drag
        // nodes ourselves without problems.
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);

                Platform.runLater(graphViewer::disableAutoLayout);
            } catch (InterruptedException ignored) {

            }
        });
        thread.start();
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
