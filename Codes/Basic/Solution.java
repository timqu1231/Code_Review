public class Solution {
    public static void main(String[] args){
      int[] array = new int[2];
      int input[] = {-1,-2,-4};
      array = twoSum(input,-6);
      System.out.println(array[0] + "," + array[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int total;
        int[] output = new int[2];
        boolean check = false;
        for (int i = 0; i < nums.length; i ++){
              //if (nums[i] != target){
                  int j = i + 1;                  
                  for (; j < nums.length; j++){
                      total = nums[i] + nums[j];
                      System.out.println("total"+total + "target" + target);
                      if (total == target){
                          output[0] = i;
                          output[1] = j;
                          check = true;
                          break;
                      }    
                      //System.out.println("i="+i);
                      //System.out.println("j="+j);
                  }
              //}
              if (check == true){
                  break;
              }
              //System.out.println("i="+output[0]);
                      //System.out.println("j="+output[1]);
        }
        return output;
    }
    // int[] res = new int[]{-1, -1};
// 		if (nums == null || nums.length < 2) return res;
// 		int n = nums.length;
// 		int left = 0;
// 		int right = n - 1;
// 		for(int i = 0; i < n; i++) {
// 			nums[i] = nums[i] * n + (nums[i] < 0 ? -i : i);
// 		}
// 		Arrays.sort(nums);
// 
// 		while (left < right) {
// 			int sum = nums[left] / n + nums[right] / n;
// 			if (sum == target) {
// 				res[0] = nums[left] < 0 ? -nums[left] % n : nums[left] % n;
// 				res[1] = nums[right] < 0 ? -nums[right] % n : nums[right] % n;
// 				return res;
// 			} else if (sum < target) {
// 				left++;
// 			} else {
// 				right--;
// 			}
// 		}
//         throw new IllegalArgumentException();
}