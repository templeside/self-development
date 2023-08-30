/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Interval> heap = new PriorityQueue<>((a,b)-> a.start-b.start);
        List<Interval> result = new ArrayList<>();
        
        for(List<Interval> time: schedule)
            heap.addAll(time);
        
        Interval prev = heap.poll();
        
        while(heap.size()>0){
            Interval curr = heap.poll();
            if(prev.end>= curr.start){   // yes overlapped
                prev = prev.end > curr.end? prev: curr;
            }else{
                result.add(new Interval(prev.end, curr.start));
                prev = curr;
            }
        }
        // System.out.println(result);
        return result;
    }
}