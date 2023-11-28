package weblab.greedy;

import java.util.*;

public class TrainingRoutes {


    static class Node {

        List<Node> outgoingEdges;

        int id;

        boolean marked;

        public Node(int id) {
            this.outgoingEdges = new ArrayList<>();
            this.marked = false;
            this.id = id;
        }

        public String toString() {
            return Integer.toString(id);
        }

        @Override
        public int hashCode() {
            return id;
        }
    }

    static class Edge {

        int from, to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return from == edge.from && to == edge.to;
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }
    }

    /**
     * @param n     the number of nodes
     * @param m     the number of edges
     * @param edges the set of edges, with endpoints labelled between 1 and n inclusive.
     * @return true iff there is a cycle in the graph
     */
    public static boolean isThereACycle(int n, int m, Set<Edge> edges) {
        //create a map of nodes with id and its outgoing edges
        Map<Integer, Node> nodes = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            nodes.put(i, new Node(i));
        }

        for (Edge e : edges) {
            nodes.get(e.from).outgoingEdges.add(nodes.get(e.to));
        }

        //use DFS iteratively to detect cycles
        for (int i = 1; i <= n; i++) {
            if (dfsCycleDetect(nodes.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean dfsCycleDetect(Node node) {
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        for (Node n : node.outgoingEdges) {
            stack.push(n);
            visited.add(n);
        }

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (current == node) {
                return true;
            }
            for (Node n : current.outgoingEdges) {
                if (!visited.contains(n)) {
                    stack.push(n);
                    visited.add(n);
                }
            }
        }
        return false;
    }
}

/*
def has_cycle(graph):
    visited = set()
    stack = set()

    for node in graph.vertices():
        if node not in visited:
            stack.append((node, None))  # (node, parent)
            visited.add(node)

            while stack:
                current, parent = stack.pop()
                stack.add(current)

                for neighbor in graph.neighbors(current):
                    if neighbor not in visited:
                        stack.append((neighbor, current))
                        visited.add(neighbor)
                    elif neighbor in stack and neighbor != parent:
                        return True  # Cycle detected

                if current in stack:
                    stack.remove(current)

    return False  # No cycle found

 */
