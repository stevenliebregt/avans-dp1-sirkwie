package com.rickensteven.sirkwie.gui;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;

public class ImageLoader
{
    public static final String IMAGES_BASEPATH = "images/";

    private static ImageLoader instance;

    public static ImageLoader getInstance()
    {
        if (instance == null) instance = new ImageLoader();
        return instance;
    }

    public Image load(String name)
    {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(IMAGES_BASEPATH + name);

        if (inputStream == null) return null;

        return new Image(inputStream);
    }

    public ImageView loadView(String name)
    {
        Image image = load(name);

        if (image == null) return new ImageView();

        return new ImageView(image);
    }
}
