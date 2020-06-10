package com.rickensteven.sirkwie.gui;

import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;

public class MainViewController
{
    private FileChooser fileChooser;

    public MainViewController()
    {
        fileChooser = new FileChooser();
    }

    public void loadFileButtonClicked(Window ownerWindow)
    {
        File selectedFile = fileChooser.showOpenDialog(ownerWindow);
        System.out.println(selectedFile);
    }

    public void simulateButtonClicked()
    {
        // TODO: Implement this
    }
}
