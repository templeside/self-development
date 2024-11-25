class Solution {
    /*
    check the row has beend in line or not.
    
    find the stones are connected.
    
    for each rows, find connected lines.
    */

    // Union-Find 자료구조를 HashMap으로 구현
    class UnionFind {
        private Map<Integer, Integer> parent;
        private Map<Integer, Integer> rank;

        public UnionFind() {
            parent = new HashMap<>();
            rank = new HashMap<>();
        }

        // 노드 x의 루트 부모를 찾는 함수 (경로 압축)
        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                rank.put(x, 1);
            }
            if (parent.get(x) != x) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        // 노드 x와 y를 합치는 함수 (랭크 기반 합병)
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) return;

            int rankX = rank.get(rootX);
            int rankY = rank.get(rootY);

            if (rankX < rankY) {
                parent.put(rootX, rootY);
            } else if (rankX > rankY) {
                parent.put(rootY, rootX);
            } else {
                parent.put(rootY, rootX);
                rank.put(rootX, rankX + 1);
            }
        }
    }

    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind();
        int offset = 10001; // 열과 행을 구분하기 위한 오프셋

        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + offset;
            uf.union(row, col);
        }

        Set<Integer> uniqueParents = new HashSet<>();
        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + offset;
            uniqueParents.add(uf.find(row));
        }

        // 제거할 수 있는 돌의 최대 개수 = 전체 돌의 개수 - 연결된 집합의 수
        return stones.length - uniqueParents.size();
    }
}
