package algo.graph;

import java.util.*;

public class Graph {

    private Set<Node> nodes = new HashSet<>();

    private List<Edge> edges = new ArrayList<>();

    public Graph() {
    }

    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

    public void createEdgeList() {
        for (Node node : nodes) {
            for (Map.Entry<Node, Integer> adjacencyPair : node.getAdjacentNodes().entrySet()) {
                edges.add(new Edge(node, adjacencyPair.getKey(), adjacencyPair.getValue()));
            }
        }
    }
}

