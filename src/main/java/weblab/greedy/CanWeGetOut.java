package weblab.greedy;

import java.util.*;

public class CanWeGetOut {

    static class Node {

        List<Node> outgoingEdges;

        boolean marked;

        public Node() {
            this.outgoingEdges = new ArrayList<>();
            this.marked = false;
        }
    }

    /**
     * @param nodes the nodes in the graph
     * @param s the starting node
     * @param t the final node
     * @return true iff there is a path from the start node to the final node
     */
    public static boolean solve(Set<Node> nodes, Node s, Node t) {
        // use BFS to check if there exists a path between s and t
        Deque<Node> q = new ArrayDeque<>();

        q.add(s);
        s.marked = true;

        while(!q.isEmpty()) {
            Node p = q.remove();
            if (p.equals(t)) {
                return true;
            }

            for (Node neighbour : p.outgoingEdges) {
                if (!neighbour.marked) {
                    q.add(neighbour);
                    neighbour.marked = true;
                }
            }
        }
        return false;
    }
}


