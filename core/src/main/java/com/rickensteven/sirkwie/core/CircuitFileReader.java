package com.rickensteven.sirkwie.core;

import java.io.*;

public class CircuitFileReader
{
    public String read(String filePath) throws IOException
    {
        InputStream inputStream = getClass().getResourceAsStream(filePath);

        // Try to fetch the file another way, this allows us to read files from
        // inside, and outside of a JAR.
        if (inputStream == null) {
            inputStream = new FileInputStream(filePath);
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
