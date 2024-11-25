import java.util.*;

class Solution {
    /*
    equations = [["a","b"],["b","c"]], 
    values = [2.0,3.0], 

    위의 정보를 graph로 표현하자면,
        a/b(a->b) = 2.0
        b/a(b->a) = 1/2
        a/c(a->c) = 3
        c/a(c->a) = 1/3
    
    queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
    queries의 정보를 graph로 표현하자면,
        [a,c] = a->c    source:a, target:c
        [b,a] = b->a    source:b, target:a
        [a,e] = a->e    source:a, target:e
    
        그래프에서 source에서 target 가는 방법을 찾는 것.
        이제 bfs로 source에서 target가는 방법을 찾으면 된다.
    
    bfs로 source에서 target 가는 법
        
    */

    // 엣지 정보를 저장할 Pair 클래스
    private static class Pair {
        String node;
        double value;

        Pair(String node, double value) {
            this.node = node;
            this.value = value;
        }
    }

    private Map<String, List<Pair>> graph = new HashMap<>();//global variable
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 그래프 구축
        buildGraph(equations, values);

        double[] results = new double[queries.size()];

        // 각 쿼리에 대해 BFS를 통해 결과 계산
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String start = query.get(0);
            String end = query.get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                // 시작 변수나 끝 변수가 그래프에 존재하지 않는 경우
                results[i] = -1.0;
            } else if (start.equals(end)) {
                // 동일한 변수 간의 비율은 항상 1.0
                results[i] = 1.0;
            } else {
                // BFS를 사용하여 경로 탐색
                results[i] = bfs(start, end);
            }
        }

        return results;
    }

    // 그래프를 구축하는 메서드
    private void buildGraph(List<List<String>> equations, double[] values) {
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String A = eq.get(0);
            String B = eq.get(1);
            double value = values[i];

            // A와 B가 그래프에 존재하지 않으면 추가
            graph.putIfAbsent(A, new ArrayList<>());
            graph.putIfAbsent(B, new ArrayList<>());

            // A -> B = value
            graph.get(A).add(new Pair(B, value));

            // B -> A = 1 / value
            graph.get(B).add(new Pair(A, 1.0 / value));
        }
    }

    // BFS를 사용하여 경로를 탐색하고 값을 계산하는 메서드
    private double bfs(String src, String target) {
        Queue<Pair> queue = new LinkedList<>();
        // 시작 노드와 누적 값을 큐에 추가
        queue.offer(new Pair(src, 1.0));

        // 방문한 노드를 추적하기 위한 집합
        Set<String> visited = new HashSet<>();
        visited.add(src);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String currentNode = current.node;
            double currentProduct = current.value;

            // 현재 노드가 목표 노드인 경우 누적 값을 반환
            if (currentNode.equals(target)) {
                return currentProduct;
            }

            // 현재 노드의 모든 인접 노드를 탐색
            for (Pair neighbor : graph.getOrDefault(currentNode, new ArrayList<>())) {
                if (!visited.contains(neighbor.node)) {
                    visited.add(neighbor.node);
                    queue.offer(new Pair(neighbor.node, currentProduct * neighbor.value));
                }
            }
        }

        // 경로가 존재하지 않는 경우 -1.0 반환
        return -1.0;
    }
}
