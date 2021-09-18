package arrays;

import java.util.HashMap;
import java.util.Map.Entry;

public class NRepeatingNTimes {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 3, 4, 4 };
		System.out.println(countMoves(nums));
		
	}
	
	public static int countMoves(int[] A) {
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        int moves = 0;
        for(int num: A){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        } 
        for(Entry<Integer, Integer> numEntry: countMap.entrySet() ) {
        	moves += Math.min(Math.abs(numEntry.getKey() - numEntry.getValue()), numEntry.getValue());
        }
        return moves;
    }

}
	