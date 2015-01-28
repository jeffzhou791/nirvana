package util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jeff on 1/24/15.
 */
public class Graph {
    public static class Node {
        public int label;
        public List<Edge> edges = new LinkedList<>();
        public Node(int label) {
            this.label = label;
        }
    }
    public static class Edge {
        public int weight;
        public Node node;
        public Edge(int weight, Node node) {
            this.weight = weight;
            this.node = node;
        }
    }
    private List<Node> nodes = new ArrayList<>();
    public List<Node> getNodes() {
        return nodes;
    }
    public void addNodes(Node... nodes) {
        for (Node node : nodes) {
            this.nodes.add(node);
        }
    }
    public static void addEdge(Node node1, int weight, Node... nodes) {
        for (Node node : nodes) {
            node1.edges.add(new Edge(weight, node));
            node.edges.add(new Edge(weight, node1));
        }

    }
}
