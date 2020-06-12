package com.rickensteven.sirkwie.core.parsing;

import com.rickensteven.sirkwie.core.building.CircuitDefinition;
import com.rickensteven.sirkwie.core.exception.CircuitSyntaxException;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLCircuitParser implements ICircuitParser
{
    private Map<String, String> nodes;
    private Map<String, List<String>> edges;

    @Override
    public CircuitDefinition parse(String cleanedTxtCircuit) throws CircuitSyntaxException
    {
        nodes = new HashMap<>();
        edges = new HashMap<>();
        CircuitDefinition circuitDefinition = new CircuitDefinition(nodes, edges);

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.parse(new InputSource(new StringReader(cleanedTxtCircuit)));

            parseNodes(document);
            parseEdges(document);
        } catch (ParserConfigurationException | SAXException | IOException exception) {
            System.err.println(exception.getMessage());
            return circuitDefinition;
        }

        return circuitDefinition;
    }

    private void parseNodes(Document document) throws CircuitSyntaxException
    {
        NodeList nodeList = document.getElementsByTagName("node");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() != Node.ELEMENT_NODE) throw new CircuitSyntaxException("Unexpected XML node");

            Element element = (Element) node;
            String name = element.getAttribute("name");
            String type = element.getAttribute("type");

            if (name == null) throw new CircuitSyntaxException("Node " + node + " does not have \"name\" attribute");
            if (type == null) throw new CircuitSyntaxException("Node " + node + " does not have \"type\" attribute");

            nodes.put(name, type);
        }
    }

    private void parseEdges(Document document) throws CircuitSyntaxException
    {
        NodeList nodeList = document.getElementsByTagName("edge");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() != Node.ELEMENT_NODE) throw new CircuitSyntaxException("Unexpected XML node");

            Element element = (Element) node;
            String source = element.getAttribute("source");
            String target = element.getAttribute("target");

            if (source == null) throw new CircuitSyntaxException("Node " + node + " does not have \"source\" attribute");
            if (target == null) throw new CircuitSyntaxException("Node " + node + " does not have \"target\" attribute");

            if (!edges.containsKey(source)) {
                edges.put(source, new ArrayList<>());
            }

            edges.get(source).add(target);
        }
    }
}
