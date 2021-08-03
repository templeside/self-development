public class NestedIterator implements Iterator<Integer> {

    List<Integer> flattenList = null;
    int current = 0;
    public NestedIterator(List<NestedInteger> nestedList) {
        flattenList = new ArrayList<>();
        for(NestedInteger integer: nestedList){
            helper(integer);
        }
    }

    @Override
    public Integer next() {
        return flattenList.get(current++);
    }

    @Override
    public boolean hasNext() {
        return current< flattenList.size();
    }

    private void helper(NestedInteger value){
        if(value.isInteger()){
            flattenList.add(value.getInteger());
        }else{
            for(NestedInteger integer: value.getList()){
                helper(integer);
            }
        }
    }
}

