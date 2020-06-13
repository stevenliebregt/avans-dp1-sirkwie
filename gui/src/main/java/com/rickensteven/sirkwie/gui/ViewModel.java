package com.rickensteven.sirkwie.gui;

import com.rickensteven.sirkwie.core.domain.Circuit;
import javafx.beans.property.*;

import java.util.HashSet;
import java.util.Set;

public class ViewModel
{
    public final Property<Circuit> circuitProperty = new SimpleObjectProperty<>(null);

    public final BooleanProperty circuitSimulateStartTriggerProperty = new SimpleBooleanProperty(false);
    public final BooleanProperty circuitSimulatedTriggerProperty = new SimpleBooleanProperty(false);

    private Set<String> parserNames = new HashSet<>();

    public void setParserNames(Set<String> parserNames)
    {
        this.parserNames = parserNames;
    }

    public Set<String> getParserNames()
    {
        return parserNames;
    }
}
