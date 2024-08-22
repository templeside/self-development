class Solution {
    /*
    update with values.
    shift after found overlapped
    update the index.
    */
    public int[][] intervalIntersection(int[][] intervalLista, int[][] intervalListb) {
        List<int[]> intersections = new ArrayList<>(); 
        int i = 0, j = 0;

        while (i < intervalLista.length && j < intervalListb.length) {
            int start = Math.max(intervalLista[i][0], intervalListb[j][0]);
            int end = Math.min(intervalLista[i][1], intervalListb[j][1]);
            
            if (start <= end) 
                intersections.add(new int[]{start, end}); 
            if (intervalLista[i][1] < intervalListb[j][1])
                i += 1;
            else
                j += 1;
        }

        return intersections.toArray(new int[0][]);
    }
}