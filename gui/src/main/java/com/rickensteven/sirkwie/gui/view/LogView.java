package com.rickensteven.sirkwie.gui.view;

import com.rickensteven.sirkwie.core.ISimulationListener;
import com.rickensteven.sirkwie.core.domain.Circuit;
import com.rickensteven.sirkwie.core.domain.Node;
import com.rickensteven.sirkwie.core.domain.Probe;
import com.rickensteven.sirkwie.gui.Controller;
import com.rickensteven.sirkwie.gui.ImageLoader;
import com.rickensteven.sirkwie.gui.ViewModel;
import com.rickensteven.sirkwie.gui.view.text.TableNodeDrawingVisitor;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.*;

public class LogView extends AbstractSimulationView implements ISimulationListener
{
    private final TableNodeDrawingVisitor tableNodeDrawingVisitor = new TableNodeDrawingVisitor();

    private static final int HEIGHT = 200;
    private TreeView<String> treeView;
    private Label delayLabel;

    private List<TreeItem<String>> rootNodes = new LinkedList<>();
    private Map<Node, TreeItem<String>> history = new LinkedHashMap<>();

    public LogView(Controller controller, ViewModel viewModel)
    {
        super(controller, viewModel);

        controller.addListener(this);
    }

    @Override
    protected void setupUi()
    {
        view = new BorderPane();
        view.setMinHeight(HEIGHT);
        view.setMaxHeight(HEIGHT);
        view.setBorder(
                new Border(
                        new BorderStroke(
                                Color.BLACK,
                                BorderStrokeStyle.SOLID,
                                CornerRadii.EMPTY,
                                new BorderWidths(1, 0, 0, 0))
                )
        );

        treeView = new TreeView<>();
        treeView.setShowRoot(false);

        HBox hBox = new HBox();

        Label label = new Label("Calculation Flow");
        label.setPadding(new Insets(4));

        delayLabel = new Label("");
        delayLabel.setPadding(new Insets(4));

        hBox.getChildren().addAll(label, delayLabel);

        ((BorderPane) view).setTop(hBox);
        ((BorderPane) view).setCenter(treeView);
    }

    @Override
    protected void draw(Circuit circuit)
    {
        // Not needed.
    }

    @Override
    protected void update(Circuit circuit)
    {
        double[] delays = new double[rootNodes.size()];

        for (int i = 0; i < rootNodes.size(); i++) {
            TreeItem<String> node = rootNodes.get(i);

            double delay = (calculateDepth(node) - 1) * 15;
            delays[i] = delay;

            node.setValue(node.getValue() + " has a delay of " + delay + "ns");
        }

        double delay = Arrays.stream(delays).max().orElse(0);

        delayLabel.setText(" : total delay = " + delay + "ns");
    }

    @Override
    public void onStartCalculate(Node node)
    {
        if (history.isEmpty()) {
            history.put(node, new TreeItem<>(node.getName()));
        } else {
            TreeItem<String> last = null;
            for (TreeItem<String> item : history.values()) last = item;

            TreeItem<String> newItem = new TreeItem<>(node.getName());

            last.getChildren().add(newItem);
            history.put(node, newItem);
        }

        refresh();
    }

    @Override
    public void onStopCalculate(Node node, boolean calculatedValue)
    {
        if (node instanceof Probe) {
            rootNodes.add(history.get(node));
        }

        ImageView imageView = ImageLoader.getInstance()
                .loadView(calculatedValue ? "bulb-on.png" : "bulb-off.png");
        imageView.setFitHeight(16);
        imageView.setFitWidth(16);

        node.accept(tableNodeDrawingVisitor);

        history.get(node).setGraphic(imageView);
        history.get(node).setValue(node.getName() + " : " + tableNodeDrawingVisitor.getValue().getType());
        history.remove(node);

        refresh();
    }

    @Override
    protected void connectViewModel()
    {
        super.connectViewModel();

        viewModel.circuitProperty.addListener((observable, oldValue, newValue) -> newValue.addSimulationListener(this));

        viewModel.circuitSimulateStartTriggerProperty.addListener((observable, oldValue, newValue) -> {
            rootNodes = new ArrayList<>();
            history = new LinkedHashMap<>();
            refresh();
        });
    }

    private void refresh()
    {
        TreeItem<String> root = new TreeItem<>();
        root.getChildren().addAll(rootNodes);
        expand(root);

        treeView.setRoot(root);

    }

    @Override
    protected void resetView()
    {
        // We do not want to remove the treeview during reset, as we update
        // the root each time.
    }

    private void expand(TreeItem<String> item)
    {
        item.setExpanded(true);
        item.getChildren().forEach(this::expand);
    }

    private int calculateDepth(TreeItem<String> tree)
    {
        if (tree.getChildren().isEmpty()) return 0;

        int maxDepth = 0;

        for (TreeItem<String> child : tree.getChildren()) {
            maxDepth = Math.max(maxDepth, calculateDepth(child));
        }

        return maxDepth + 1;
    }
}
