package algo.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * <ul>
 *   <li>choose a node to start</li>
 *   <li>REPEAT UNTIL no more unsettledNodes:</li>
 *   <li>
 *       <ur>
 *         <li>find all adjacency nodes to current settleNodes</li>
 *         <li>settle the node with the closest distance(currently)</li>
 *       </ur>
 *   </li>
 * </ul>
 */
public class Dijkstra {
    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source); // add source(start node) to unsettledNodes(start from source)

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry<Node, Integer> adjacencyPair :
                    currentNode.getAdjacentNodes().entrySet()) { // find neighbors of current node
                Node adjacentNode = adjacencyPair.getKey(); // neighbor node
                Integer edgeWeight = adjacencyPair.getValue(); // neighbor node's distance
                if (!settledNodes.contains(adjacentNode)) { // if node is unsettled
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    // this will replace same node that have longer path
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    /**
     * get the closest node in unsettledNode
     *
     * @param unsettledNodes
     * @return
     */
    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node : unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    /**
     * @param evaluationNode node need to be evaluated
     * @param edgeWeigh      distance to evaluationNode
     * @param sourceNode     start from sourceNode
     */
    private static void calculateMinimumDistance(
            Node evaluationNode,
            Integer edgeWeigh,
            Node sourceNode
    ) {
        Integer sourceDistance = sourceNode.getDistance();
        // if we can find shorter path to this evaluationNode
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            // setup the shortest path to evaluationNode (source.shortestPath+source)
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }


    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        Graph graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph = Dijkstra.calculateShortestPathFromSource(graph, nodeA);
    }
}
