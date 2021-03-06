package gogo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class ReconstructQueueByHeight {
	public static void main(String[] args){
		Set<Integer> set=new HashSet<> ();
		set.add(1);
		for(Integer i:set) {
			System.out.println(i);
		}
		System.out.println(-1%26);
		System.out.println(-1/3+1/3);
		System.out.println(Arrays.toString("x+5-3+x".split("(?=\\+)|(?=\\-)")));
		String s="";
		System.out.println(Arrays.toString(s.split(".")));
		//"2001:0db8:85a3:0:0:8A2E:0370:7334:"
		//2001:db8:85a3:0:0:8A2E:0370:7334
		PriorityQueue<Double> q=new PriorityQueue<> ();
		/*
		 * [[1,1],[1,1,1],[1,1,1,1],[1,1,1,1,1],
		 * [9,10],[8,10],[8,9],[8,9,10],[7,10],[7,9],
		 * [7,9,10],[7,8],[7,8,10],[7,8,9],[7,8,9,10],
		 * [6,10],[6,9],[6,9,10],[6,8],[6,8,10],[6,8,9],
		 * [6,8,9,10],[6,7],[6,7,10],[6,7,9],[6,7,9,10],
		 * [6,7,8],[6,7,8,10],[6,7,8,9],[6,7,8,9,10],
		 * [5,10],[5,9],[5,9,10],[5,8],[5,8,10],[5,8,9],
		 * [5,8,9,10],[5,7],[5,7,10],[5,7,9],[5,7,9,10],
		 * [5,7,8],[5,7,8,10],[5,7,8,9],[5,7,8,9,10],[5,6],
		 * [5,6,10],[5,6,9],[5,6,9,10],[5,6,8],[5,6,8,10],[5,6,8,9],
		 * [5,6,8,9,10],[5,6,7],[5,6,7,10],[5,6,7,9],[5,6,7,9,10],[5,6,7,8],
		 * [5,6,7,8,10],[5,6,7,8,9],[5,6,7,8,9,10],[4,10],[4,9],[4,9,10],[4,8],
		 * [4,8,10],[4,8,9],[4,8,9,10],[4,7],[4,7,10],[4,7,9],[4,7,9,10],
		 * [4,7,8],[4,7,8,10],[4,7,8,9],[4,7,8,9,10],[4,6],[4,6,10],[4,6,9],
		 * [4,6,9,10],[4,6,8],[4,6,8,10],[4,6,8,9],[4,6,8,9,10],[4,6,7],
		 * [4,6,7,10],[4,6,7,9],[4,6,7,9,10],[4,6,7,8],[4,6,7,8,10],
		 * [4,6,7,8,9],[4,6,7,8,9,10],[4,5],[4,5,10],[4,5,9],[4,5,9,10],[4,5,8],
		 * [4,5,8,10],[4,5,8,9],[4,5,8,9,10],[4,5,7],[4,5,7,10],[4,5,7,9],[4,5,7,9,10],
		 * [4,5,7,8],[4,5,7,8,10],[4,5,7,8,9],[4,5,7,8,9,10],[4,5,6],[4,5,6,10],[4,5,6,9],
		 * [4,5,6,9,10],[4,5,6,8],[4,5,6,8,10],[4,5,6,8,9],[4,5,6,8,9,10],[4,5,6,7],[4,5,6,7,10],
		 * [4,5,6,7,9],[4,5,6,7,9,10],[4,5,6,7,8],[4,5,6,7,8,10],[4,5,6,7,8,9],[4,5,6,7,8,9,10],
		 * [3,10],[3,9],[3,9,10],[3,8],[3,8,10],[3,8,9],[3,8,9,10],[3,7],[3,7,10],[3,7,9],
		 * [3,7,9,10],[3,7,8],[3,7,8,10],[3,7,8,9],[3,7,8,9,10],[3,6],[3,6,10],[3,6,9],[3,6,9,10],
		 * [3,6,8],[3,6,8,10],[3,6,8,9],[3,6,8,9,10],[3,6,7],[3,6,7,10],[3,6,7,9],[3,6,7,9,10],
		 * [3,6,7,8],[3,6,7,8,10],[3,6,7,8,9],[3,6,7,8,9,10],[3,5],[3,5,10],[3,5,9],[3,5,9,10],
		 * [3,5,8],[3,5,8,10],[3,5,8,9],[3,5,8,9,10],[3,5,7],[3,5,7,10],[3,5,7,9],[3,5,7,9,10],
		 * [3,5,7,8],[3,5,7,8,10],[3,5,7,8,9],[3,5,7,8,9,10],[3,5,6],[3,5,6,10],[3,5,6,9],[3,5,6,9,10],
		 * [3,5,6,8],[3,5,6,8,10],[3,5,6,8,9],[3,5,6,8,9,10],[3,5,6,7],[3,5,6,7,10],[3,5,6,7,9],
		 * [3,5,6,7,9,10],[3,5,6,7,8],[3,5,6,7,8,10],[3,5,6,7,8,9],[3,5,6,7,8,9,10],[3,4],[3,4,10],
		 * [3,4,9],[3,4,9,10],[3,4,8],[3,4,8,10],[3,4,8,9],[3,4,8,9,10],[3,4,7],[3,4,7,10],
		 * [3,4,7,9],[3,4,7,9,10],[3,4,7,8],[3,4,7,8,10],[3,4,7,8,9],[3,4,7,8,9,10],
		 * [3,4,6],[3,4,6,10],[3,4,6,9],[3,4,6,9,10],[3,4,6,8],[3,4,6,8,10],[3,4,6,8,9],
		 * [3,4,6,8,9,10],[3,4,6,7],[3,4,6,7,10],[3,4,6,7,9],[3,4,6,7,9,10],[3,4,6,7,8],
		 * [3,4,6,7,8,10],[3,4,6,7,8,9],[3,4,6,7,8,9,10],[3,4,5],[3,4,5,10],[3,4,5,9],
		 * [3,4,5,9,10],[3,4,5,8],[3,4,5,8,10],[3,4,5,8,9],[3,4,5,8,9,10],[3,4,5,7],
		 * [3,4,5,7,10],[3,4,5,7,9],[3,4,5,7,9,10],[3,4,5,7,8],[3,4,5,7,8,10],[3,4,5,7,8,9],
		 * [3,4,5,7,8,9,10],[3,4,5,6],[3,4,5,6,10],[3,4,5,6,9],[3,4,5,6,9,10],[3,4,5,6,8],[3,4,5,6,8,10],[3,4,5,6,8,9],[3,4,5,6,8,9,10],[3,4,5,6,7],[3,4,5,6,7,10],[3,4,5,6,7,9],[3,4,5,6,7,9,10],[3,4,5,6,7,8],[3,4,5,6,7,8,10],[3,4,5,6,7,8,9],[3,4,5,6,7,8,9,10],[2,10],[2,9],[2,9,10],[2,8],[2,8,10],[2,8,9],[2,8,9,10],[2,7],[2,7,10],[2,7,9],[2,7,9,10],[2,7,8],[2,7,8,10],[2,7,8,9],[2,7,8,9,10],[2,6],[2,6,10],[2,6,9],[2,6,9,10],[2,6,8],[2,6,8,10],[2,6,8,9],[2,6,8,9,10],[2,6,7],[2,6,7,10],[2,6,7,9],[2,6,7,9,10],[2,6,7,8],[2,6,7,8,10],[2,6,7,8,9],[2,6,7,8,9,10],[2,5],[2,5,10],[2,5,9],[2,5,9,10],[2,5,8],[2,5,8,10],[2,5,8,9],[2,5,8,9,10],[2,5,7],[2,5,7,10],[2,5,7,9],[2,5,7,9,10],[2,5,7,8],[2,5,7,8,10],[2,5,7,8,9],[2,5,7,8,9,10],[2,5,6],[2,5,6,10],[2,5,6,9],[2,5,6,9,10],[2,5,6,8],[2,5,6,8,10],[2,5,6,8,9],[2,5,6,8,9,10],[2,5,6,7],[2,5,6,7,10],[2,5,6,7,9],[2,5,6,7,9,10],[2,5,6,7,8],[2,5,6,7,8,10],[2,5,6,7,8,9],[2,5,6,7,8,9,10],[2,4],[2,4,10],[2,4,9],[2,4,9,10],[2,4,8],[2,4,8,10],[2,4,8,9],[2,4,8,9,10],[2,4,7],[2,4,7,10],[2,4,7,9],[2,4,7,9,10],[2,4,7,8],[2,4,7,8,10],[2,4,7,8,9],[2,4,7,8,9,10],[2,4,6],[2,4,6,10],[2,4,6,9],[2,4,6,9,10],[2,4,6,8],[2,4,6,8,10],[2,4,6,8,9],[2,4,6,8,9,10],[2,4,6,7],[2,4,6,7,10],[2,4,6,7,9],[2,4,6,7,9,10],[2,4,6,7,8],[2,4,6,7,8,10],[2,4,6,7,8,9],[2,4,6,7,8,9,10],[2,4,5],[2,4,5,10],[2,4,5,9],[2,4,5,9,10],[2,4,5,8],[2,4,5,8,10],[2,4,5,8,9],[2,4,5,8,9,10],[2,4,5,7],[2,4,5,7,10],[2,4,5,7,9],[2,4,5,7,9,10],[2,4,5,7,8],[2,4,5,7,8,10],[2,4,5,7,8,9],[2,4,5,7,8,9,10],[2,4,5,6],[2,4,5,6,10],[2,4,5,6,9],[2,4,5,6,9,10],[2,4,5,6,8],[2,4,5,6,8,10],[2,4,5,6,8,9],[2,4,5,6,8,9,10],[2,4,5,6,7],[2,4,5,6,7,10],[2,4,5,6,7,9],[2,4,5,6,7,9,10],[2,4,5,6,7,8],[2,4,5,6,7,8,10],[2,4,5,6,7,8,9],[2,4,5,6,7,8,9,10],[2,3],[2,3,10],[2,3,9],[2,3,9,10],[2,3,8],[2,3,8,10],[2,3,8,9],[2,3,8,9,10],[2,3,7],[2,3,7,10],[2,3,7,9],[2,3,7,9,10],[2,3,7,8],[2,3,7,8,10],[2,3,7,8,9],[2,3,7,8,9,10],[2,3,6],[2,3,6,10],[2,3,6,9],[2,3,6,9,10],[2,3,6,8],[2,3,6,8,10],[2,3,6,8,9],[2,3,6,8,9,10],[2,3,6,7],[2,3,6,7,10],[2,3,6,7,9],[2,3,6,7,9,10],[2,3,6,7,8],[2,3,6,7,8,10],[2,3,6,7,8,9],[2,3,6,7,8,9,10],[2,3,5],[2,3,5,10],[2,3,5,9],[2,3,5,9,10],[2,3,5,8],[2,3,5,8,10],[2,3,5,8,9],[2,3,5,8,9,10],[2,3,5,7],[2,3,5,7,10],[2,3,5,7,9],[2,3,5,7,9,10],[2,3,5,7,8],[2,3,5,7,8,10],[2,3,5,7,8,9],[2,3,5,7,8,9,10],[2,3,5,6],[2,3,5,6,10],[2,3,5,6,9],[2,3,5,6,9,10],[2,3,5,6,8],[2,3,5,6,8,10],[2,3,5,6,8,9],[2,3,5,6,8,9,10],[2,3,5,6,7],[2,3,5,6,7,10],[2,3,5,6,7,9],[2,3,5,6,7,9,10],[2,3,5,6,7,8],[2,3,5,6,7,8,10],[2,3,5,6,7,8,9],[2,3,5,6,7,8,9,10],[2,3,4],[2,3,4,10],[2,3,4,9],[2,3,4,9,10],[2,3,4,8],[2,3,4,8,10],[2,3,4,8,9],[2,3,4,8,9,10],[2,3,4,7],[2,3,4,7,10],[2,3,4,7,9],[2,3,4,7,9,10],[2,3,4,7,8],[2,3,4,7,8,10],[2,3,4,7,8,9],[2,3,4,7,8,9,10],[2,3,4,6],[2,3,4,6,10],[2,3,4,6,9],[2,3,4,6,9,10],[2,3,4,6,8],[2,3,4,6,8,10],[2,3,4,6,8,9],[2,3,4,6,8,9,10],[2,3,4,6,7],[2,3,4,6,7,10],[2,3,4,6,7,9],[2,3,4,6,7,9,10],[2,3,4,6,7,8],[2,3,4,6,7,8,10],[2,3,4,6,7,8,9],[2,3,4,6,7,8,9,10],[2,3,4,5],[2,3,4,5,10],[2,3,4,5,9],[2,3,4,5,9,10],[2,3,4,5,8],[2,3,4,5,8,10],[2,3,4,5,8,9],[2,3,4,5,8,9,10],[2,3,4,5,7],[2,3,4,5,7,10],[2,3,4,5,7,9],[2,3,4,5,7,9,10],[2,3,4,5,7,8],[2,3,4,5,7,8,10],[2,3,4,5,7,8,9],[2,3,4,5,7,8,9,10],[2,3,4,5,6],[2,3,4,5,6,10],[2,3,4,5,6,9],[2,3,4,5,6,9,10],[2,3,4,5,6,8],[2,3,4,5,6,8,10],[2,3,4,5,6,8,9],[2,3,4,5,6,8,9,10],[2,3,4,5,6,7],[2,3,4,5,6,7,10],[2,3,4,5,6,7,9],[2,3,4,5,6,7,9,10],[2,3,4,5,6,7,8],[2,3,4,5,6,7,8,10],[2,3,4,5,6,7,8,9],[2,3,4,5,6,7,8,9,10],[1,1,1,1,1,1]]
		 * */
		
	}
	public int[][] reconstructQueue(int[][] people) {
		if (people==null || people.length==0 || people[0]==null || people[0].length==0) return new int[0][0];
        Map<Integer, List<int[]>> map=new HashMap<> ();
        int len=people.length;
        for(int i=0;i<len;i++) {
            int index=people[i][1];
            List<int []> list=map.get(index);
            if (list==null) {
                list=new LinkedList<int[]> ();
            }
            list.add(people[i]);
            map.put(index, list);
        }
        int[][] re=new int[len][2];
        PriorityQueue<int[]> q=new PriorityQueue<int[]> (len,new Comparator<int[]> () {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}});
        for(int i=0;i<len;i++) {
        	List<int []> list=map.get(i);
        	if(list!=null) {
        		for(int[] a:list) {
            		q.add(a);
            	}
        	}      	
        	List<int[]> wl=new LinkedList<int []> ();
        	int[] top=q.poll();//System.out.println(Arrays.toString(top));
            //System.out.println("re: "+Arrays.toString(re));
        	boolean isValid=false;
        	while(true) {
        		int val=top[0];
        		int count=0;
        		int min=top[1];
        		for(int j=0;j<i;j++) {
                    //System.out.println("re[j]="+Arrays.toString(re[j]));
        			if (re[j][0]>=val) count++;       			
        		}
                if (count>=min) isValid=true;
        		if(!isValid){
        			wl.add(top);
        			top=q.poll();
        		} else {
        			break;
        		}
        	}
        	q.addAll(wl);
        	re[i]=top;
        }
        return re;
    }
}
