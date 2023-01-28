package L20230128.Solution;

import java.util.Random;

public class Solution {
         int [] nums;
         int [] reset;
        public Solution(int[] nums) {
             this.nums=nums;
             reset = nums.clone();
        }

        public int[] reset() {
          return reset;
        }

        public int[] shuffle() {
            int len = nums.length;
            Random random =new Random();

            for (int i = 0; i < len / 2; i++) {
                int j = random.nextInt(len);
                int temp = nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
            return nums;

        }
    }

