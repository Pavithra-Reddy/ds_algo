package leetcode_algo_selfstudy;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class OpenTheLock {

	public static void main(String[] args) {
		System.out.println(openLock(new String[] {"0201","0101","0102","1212","2002"}, "0202"));

	}
	
	public static int openLock(String[] deadends, String target) {
        /*HashSet<String> deadends_set = new HashSet<String>();
        for(String s : deadends){
            deadends_set.add(s);
        }
        */
        Queue<String> q = new ArrayDeque<String>();
        HashSet<String> visited = new HashSet<String>();
        for(String s : deadends){
            visited.add(s);
        }
        q.add("0000");
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                String curr = q.poll();
                size--;
                if(target.equals(curr)){
                    return res;
                }
                /*
                if(deadends_set.contains(curr)){
                    continue;
                }
                */
                
                if(!visited.contains(curr)){
                    visited.add(curr);
                }
                else{
                    continue;
                }
                
                for(int i = 0; i< 4; i++){
                    char ch = curr.charAt(i);
                   String s1 = curr.substring(0, i)+ (ch == '9' ? 0 : (ch - '0' + 1)) + curr.substring(i+1);
                    String s2 = curr.substring(0, i)+ (ch == '0' ? 9 : (ch - '0' - 1)) + curr.substring(i+1);
                    
                    if(!visited.contains(s1) /*&& !deadends_set.contains(s1)*/){
                        q.add(s1);
                    }
                    if(!visited.contains(s2) /*&& !deadends_set.contains(s2)*/){
                        q.add(s2);
                    }
                } 
            }
            res++;
            
        }
        return -1;
    }

}
