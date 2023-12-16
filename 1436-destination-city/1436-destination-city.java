class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> desCity = new HashSet<>();
        int n= paths.size();
        
        for(int i=0; i<n; i++){
            desCity.add(paths.get(i).get(0));
        }
        
        
        for(int i=0; i<n; i++){
            if(!desCity.contains(paths.get(i).get(1)))
                return paths.get(i).get(1);
        }
        return "";
    }
}