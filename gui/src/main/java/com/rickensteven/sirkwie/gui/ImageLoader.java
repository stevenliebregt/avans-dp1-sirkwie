package com.rickensteven.sirkwie.gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * This class uses the Flyweight pattern, by storing the images they only
 * have to be fetched once.
 */
public class ImageLoader
{
    private static final String IMAGES_BASEPATH = "images/";

    private Map<String, Image> images = new HashMap<>();

    private static ImageLoader instance;

    public static ImageLoader getInstance()
    {
        if (instance == null) instance = new ImageLoader();
        return instance;
    }

    public Image load(String name)
    {
        if (!images.containsKey(name)) {
            InputStream inputStream = ClassLoader.getSystemResourceAsStream(IMAGES_BASEPATH + name);

            if (inputStream == null) return null;

            images.put(name, new Image(inputStream));
        }

        return images.get(name);
    }

    public ImageView loadView(String name)
    {
        Image image = load(name);

        if (image == null) return new ImageView();

        return new ImageView(image);
    }
}
