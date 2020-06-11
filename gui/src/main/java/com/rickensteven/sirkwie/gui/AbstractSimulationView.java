package com.rickensteven.sirkwie.gui;

import javafx.scene.layout.Pane;

public abstract class AbstractSimulationView
{
    protected MainViewController controller;
    protected MainViewModel mainViewModel;

    protected Pane view;

    public Pane getView()
    {
        return view;
    }

    public AbstractSimulationView(MainViewController controller, MainViewModel mainViewModel)
    {
        this.controller = controller;
        this.mainViewModel = mainViewModel;

        setupUi();
        connectViewModel();
    }

    protected abstract void setupUi();

    protected abstract void connectViewModel();
}
