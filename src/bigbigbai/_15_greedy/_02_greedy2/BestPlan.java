package bigbigbai._15_greedy._02_greedy2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BestPlan {
    public static void main(String[] args) {
        System.out.println(bestPlan(new int[]{10,40,60,140,30}, new int[]{10,20,25,35,10},5,50));
    }

    private static class Project {
        int cost;
        int profit;

        public Project(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }

        @Override
        public String toString() {
            return "Project{" +
                    "cost=" + cost +
                    ", profit=" + profit +
                    '}';
        }
    }

    public static int bestPlan(int[] costs, int[] profits, int k, int m) {
        Project[] projects = new Project[costs.length];
        for (int i = 0; i < costs.length; i++) {
            projects[i] = new Project(costs[i], profits[i]);
        }

        PriorityQueue<Project> maxProfitQ = new PriorityQueue<Project>(new Comparator<Project>() {
            @Override
            public int compare(Project o1, Project o2) {
                return o2.profit - o1.profit;
            }
        });

        PriorityQueue<Project> minCostQ = new PriorityQueue<>(new Comparator<Project>() {
            @Override
            public int compare(Project o1, Project o2) {
                return o1.cost - o2.cost;
            }
        });
        minCostQ.addAll(Arrays.asList(projects));

        for (int i = 0; i < k; i++) {
            while (!minCostQ.isEmpty() && minCostQ.peek().cost <= m) {
                maxProfitQ.add(minCostQ.poll());
            }

            Project project = maxProfitQ.poll();
            if (project == null) break;
            m += project.profit;
        }

        return m;
    }
}
