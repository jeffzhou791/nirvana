import util.Graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jeff on 1/24/15.
 */
public class Dfs {
    enum Color {WHITE, GRAY, BLACK};
    private Map<Graph.Node, Color> colorMap = new HashMap<>();
    private Map<Graph.Node, Integer> depths = new HashMap<>();
    private int currentDepth = 0;
    private Graph graph;
    Dfs(Graph graph) {
        this.graph = graph;
        for (Graph.Node node : graph.getNodes()) {
            colorMap.put(node, Color.WHITE);
        }
        depthFirstTraverse();
    }
    public int[] depthFirstTraverse() {
        if (graph == null || graph.getNodes() == null) {
            return null;
        }
        for (Graph.Node node : graph.getNodes()) {
            dfs(node);
        }
        return null;
    }

    private void dfs(Graph.Node node) {
        if (colorMap.get(node) == Color.WHITE) {
            colorMap.put(node, Color.GRAY);
            for (Graph.Edge edge : node.edges) {
                Graph.Node child = edge.node;
                if (colorMap.get(child) == Color.WHITE) {
                    dfs(child);
                }
            }
            depths.put(node, nextDepth());
            colorMap.put(node, Color.BLACK);
        }
    }

    private int nextDepth() {
        return currentDepth++;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        Graph.Node node1 = new Graph.Node(1);
        Graph.Node node2 = new Graph.Node(2);
        Graph.Node node3 = new Graph.Node(3);
        Graph.Node node4 = new Graph.Node(4);
        Graph.addEdge(node1, 1, node2, node3, node4);
        Graph.addEdge(node2, 1, node3);
        graph.addNodes(node1, node2, node3, node4);
        Dfs dfs = new Dfs(graph);
        for (Map.Entry<Graph.Node, Integer> entry : dfs.depths.entrySet()) {
            System.out.println(entry.getKey().label + ":" + entry.getValue());
        }

    }
}
