package com.rickensteven.sirkwie.gui.view.text;

import com.rickensteven.sirkwie.core.domain.Circuit;
import com.rickensteven.sirkwie.gui.view.AbstractSimulationView;
import com.rickensteven.sirkwie.gui.Controller;
import com.rickensteven.sirkwie.gui.ViewModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class TextSimulationView extends AbstractSimulationView
{
    private final TableNodeDrawingVisitor visitor;

    public TextSimulationView(Controller controller, ViewModel viewModel)
    {
        super(controller, viewModel);

        visitor = new TableNodeDrawingVisitor();
    }

    @Override
    protected void setupUi()
    {
        view = new StackPane();
    }

    @Override
    protected void draw(Circuit circuit)
    {
        TableView<TableNodeData> tableView = new TableView<>();

        TableColumn<TableNodeData, String> column1 = new TableColumn<>("Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<TableNodeData, String> column2 = new TableColumn<>("Type");
        column2.setCellValueFactory(new PropertyValueFactory<>("type"));
        TableColumn<TableNodeData, String> column3 = new TableColumn<>("Output");
        column3.setCellValueFactory(new PropertyValueFactory<>("output"));
        TableColumn<TableNodeData, String> column4 = new TableColumn<>("Parents");
        column4.setCellValueFactory(new PropertyValueFactory<>("parents"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);

        circuit.getNodes().forEach(node -> {
            node.accept(visitor);
            tableView.getItems().add(visitor.getValue());
        });

        VBox.setVgrow(tableView, Priority.ALWAYS);

        VBox vbox = new VBox(tableView);
        view.getChildren().add(vbox);
    }
}
