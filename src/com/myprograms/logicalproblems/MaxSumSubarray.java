package com.myprograms.logicalproblems;

import java.util.ArrayList;

public class MaxSumSubarray {

    public ArrayList<Long> maxset(ArrayList<Long> A) {
    	int i = 0, j = 0;
        long maxSum = -1, sum = 0;
        int sbi = 0, sbj = 0;
        boolean isThereNegativeNumber = false;
        boolean consecutiveZeroes = false;
        
        while(j < A.size()){
            
            if(A.get(j)  >= 0){
                sum+=A.get(j);
                consecutiveZeroes = false;
            }else{
                
                isThereNegativeNumber = true; 
                if(!consecutiveZeroes){
                    if(sum > maxSum){
                        sbi = i;
                        sbj = j-1;
                        maxSum = sum;
                    }else if(sum == maxSum){
                        if(j-1-i > sbj-sbi){
                            sbi =i;
                            sbj = j-1;
                            maxSum = sum;
                        }
                    }
                    consecutiveZeroes = true;
                }
                
                i = j+1;
                sum = 0;
            }
            j++;
        }
        if(!isThereNegativeNumber){
            sbi = 0;
            sbj = A.size()-1;
        }
        return new ArrayList<Long>(A.subList(sbi, sbj+1));
    }

}
