package com.rickensteven.sirkwie.core;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CircuitFileReader
{
    public String read(String name) throws Exception
    {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(name);

        if (inputStream == null) {
            throw new Exception("Could not find circuit file");
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line = bufferedReader.readLine();
        StringBuilder stringBuilder = new StringBuilder();

        while (line != null) {
            if (!line.startsWith("#")) { // Remove comments from the file
                stringBuilder.append(line).append("\r\n");
            }

            line = bufferedReader.readLine();
        }

        return stringBuilder.toString();
    }
}
