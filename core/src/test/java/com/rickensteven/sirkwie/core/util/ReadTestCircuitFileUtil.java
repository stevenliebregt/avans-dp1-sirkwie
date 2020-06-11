package com.rickensteven.sirkwie.core.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class ReadTestCircuitFileUtil
{
    @SuppressWarnings("ConstantConditions")
    public static String read(String filePath)
    {
        return new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(filePath)))
                .lines()
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
