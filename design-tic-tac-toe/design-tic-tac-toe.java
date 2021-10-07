class TicTacToe {
    private int n;
    //              <pair<player, index>, count>
    private HashMap<Pair<Integer,Integer>,Integer> rowMap;
    private HashMap<Pair<Integer,Integer>,Integer> colMap;
    private HashMap<Pair<Integer,Integer>,Integer> diagMap;
    
    public TicTacToe(int n) {
        this.n = n;
        rowMap = new HashMap<>();
        colMap = new HashMap<>();
        diagMap = new HashMap<>();
    }
    
    private boolean update(HashMap<Pair<Integer,Integer>,Integer>map, Pair<Integer, Integer> p){
        map.put(p, map.getOrDefault(p, 0)+1);
        return map.get(p) == n;
    }
    
    public int move(int row, int col, int player) {
        Pair<Integer, Integer> rowPos = new Pair<>(player, row);
        if(update(rowMap, rowPos))
            return player;
        Pair<Integer, Integer> colPos = new Pair<>(player, col);
        if(update(colMap, colPos))
            return player;
        
        if(row == col){
            Pair<Integer, Integer> diagPos = new Pair<>(player, 1);
                if(update(diagMap, diagPos))
                    return player;
        }
        if(row+col == n-1){
            Pair<Integer, Integer> diagPos = new Pair<>(player, -1);
                if(update(diagMap, diagPos))
                    return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */