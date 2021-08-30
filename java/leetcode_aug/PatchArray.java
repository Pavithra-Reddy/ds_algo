package leetcode_aug; 

class PatchArray{

public static void main(String args[]){

int[] nums = {1,4,10};
int n= 50;

System.out.println(minPatches(nums,n));

}
public static int minPatches(int[] nums, int n) {
long miss = 1;
int count = 0;
int i = 0;
while(miss <= n){
if(i<nums.length && nums[i] <= miss){
miss += nums[i];
i++;
}else{
miss += miss;
count++;
}
}
return count; 
        
    }
}
