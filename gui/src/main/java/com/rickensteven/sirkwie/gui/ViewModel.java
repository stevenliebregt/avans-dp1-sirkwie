package com.rickensteven.sirkwie.gui;

import com.rickensteven.sirkwie.core.domain.Circuit;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

public class ViewModel
{
    public final Property<Circuit> circuitProperty = new SimpleObjectProperty<>(null);

    public final BooleanProperty circuitSimulatedTriggerProperty = new SimpleBooleanProperty(false);
}
