package weblab.greedy;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import weblab.greedy.CanWeGetOut.*;

class CanWeGetOutTest {

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void example() {
        int n = 7;
        Node[] nodesArr = new Node[n + 1];
        Set<Node> nodes = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            nodesArr[i] = new Node();
            nodes.add(nodesArr[i]);
        }
        Node s = nodesArr[1];
        Node t = nodesArr[5];
        nodesArr[1].outgoingEdges.add(nodesArr[2]);
        nodesArr[2].outgoingEdges.add(nodesArr[3]);
        nodesArr[3].outgoingEdges.add(nodesArr[4]);
        nodesArr[4].outgoingEdges.add(nodesArr[5]);
        nodesArr[2].outgoingEdges.add(nodesArr[6]);
        nodesArr[6].outgoingEdges.add(nodesArr[7]);
        nodesArr[7].outgoingEdges.add(nodesArr[4]);
        Assertions.assertTrue(CanWeGetOut.solve(nodes, s, t));
        Assertions.assertFalse(CanWeGetOut.solve(nodes, t, s));
    }

}