package com.rickensteven.sirkwie.gui;

import com.rickensteven.sirkwie.core.domain.Circuit;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;

public class MainViewModel
{
    public Property<Circuit> circuitProperty = new SimpleObjectProperty<>(null);
}
