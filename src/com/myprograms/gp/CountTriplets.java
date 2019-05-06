package com.myprograms.gp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {
	//count triplet forming GP
	public long countTriplets(List<Long> arr, long r) {
        long triplets = 0;
        if(r == 1) {
        	long count = 0;
        	Map<Long,Long> mapCount = new HashMap<>();
        	for(int i = 0; i<arr.size(); i++) 
        		mapCount.put(arr.get(i), mapCount.getOrDefault(arr.get(i), 0L) + 1);
        	for(Long val : mapCount.values()) {
        		//nCr
        		count += val*(val-1)*(val-2)/6;
        	}
        	return count;
        }
        for(int i = 1; i<arr.size(); i++){
            Long a = arr.get(i-1);
            Long val = 1L;
            boolean notFound = false;

            List<Long> ls = new ArrayList<>(
            		arr.subList(i, arr.size()));
            
            for(int j = 1; j<=2; j++){
                Long res = (long)(a*Math.pow(r, j));
                
                if(ls.contains(res)){
                    val *= Collections.frequency(ls, res);
                    ls = ls.subList(ls.indexOf(res)+1, ls.size());
                }else{
                    notFound = true;
                    break;
                }
            }

            if(!notFound)
                triplets += val;
        }
        return triplets;
    }
}
