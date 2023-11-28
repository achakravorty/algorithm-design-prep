package weblab.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.*;
import java.util.concurrent.TimeUnit;

import weblab.greedy.TrainingRoutes.*;


class TrainingRoutesTest {

//    private static void runTestWithFile(String fileName) {
//        ProblemInstance p =
//                parseInput(
//                        new ByteArrayInputStream(
//                                WebLab.getData(fileName + ".in").getBytes(StandardCharsets.UTF_8)));
//        Assertions.assertEquals(
//                WebLab.getData(fileName + ".out").trim().equals("yes"),
//                Solution.isThereACycle(p.n, p.m, p.edges));
//    }

//    private static ProblemInstance parseInput(ByteArrayInputStream input) {
//        Scanner sc = new Scanner(input);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int s = sc.nextInt();
//        Set<Edge> edges = new HashSet<>();
//        for (int i = 1; i <= m; i++) {
//            edges.add(new Edge(sc.nextInt(), sc.nextInt()));
//            sc.nextInt();
//        }
//        sc.close();
//        return new ProblemInstance(n, m, s, edges);
//    }

    static class ProblemInstance {

        int n;

        int m;

        int s;

        Set<Edge> edges;

        public ProblemInstance(int n, int m, int s, Set<Edge> edges) {
            this.n = n;
            this.m = m;
            this.s = s;
            this.edges = edges;
        }
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    public void example() {
        int n = 5;
        int m = 6;
        Set<Edge> edges = new HashSet<>();
        edges.add(new Edge(1, 2));
        edges.add(new Edge(3, 2));
        edges.add(new Edge(1, 3));
        edges.add(new Edge(4, 5));
        edges.add(new Edge(2, 4));
        edges.add(new Edge(5, 3));
        Assertions.assertTrue(TrainingRoutes.isThereACycle(n, m, edges));
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    public void exampleRememberItIsDirected() {
        int n = 4;
        int m = 5;
        Set<Edge> edges = new HashSet<>();
        edges.add(new Edge(1, 2));
        edges.add(new Edge(1, 3));
        edges.add(new Edge(2, 4));
        edges.add(new Edge(3, 4));
        edges.add(new Edge(2, 3));
        Assertions.assertFalse(TrainingRoutes.isThereACycle(n, m, edges));
    }

}