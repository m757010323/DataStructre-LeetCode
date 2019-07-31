import org.junit.Test;

import java.util.Arrays;

public class DoublePointer {

    /**
     * 167. Two Sum II - Input array is sorted
     *
     * Input: numbers={2, 7, 11, 15}, target=9
     * Output: index1=1, index2=2
     * DESCRIPTION:
     *
     * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
     *
     * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
     *
     * 人话:在有序数组中找出两个数,使他们的和为target,小的在前大的在后组成数组返回
     * "https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/"
     */
    @Test
    public void test1_1(){
        //1.1  ---- 我的方法
        //使用双层for循环
        int[] numbers = new int[]{2,7,11,15};
        int target = 9;

        for (int i = 1; i <=numbers.length ; i++) {
            for (int j = i + 1; j <= numbers.length ; j++) {
                while (numbers[i-1] + numbers[j-1] == target){
                    System.out.println(Arrays.toString(new int[]{i,j}));
                    break;
                }
            }
        }

    }
    @Test
    public void test1_2(){
        //1.2 -----使用双指针
        //双指针
        int[] numbers = new int[]{2,7,11,15};
        int target = 9;

        int i = 0;int j = numbers.length-1;
        while(i<j){
            int sum = numbers[i] + numbers[j];
            if(sum == target){
                System.out.println(Arrays.toString(new int[]{i+1,j+1}));
                break;
            }
            else if(sum > target){
                j--;
            }
            else{
                i++;
            }
        }
    }

    /**
     * https://leetcode.com/problems/sum-of-square-numbers/description/
     *
     * Input: 5
     * Output: True
     * Explanation: 1 * 1 + 2 * 2 = 5
     * 题目描述：判断一个数是否为两个数的平方和。
     */
    @Test
    public void test2(){
        int target = 41;
        int i = 0;int j = (int)Math.sqrt(target);//Math.sqrt函数是对该变量开平方
        while(i<j){
            int sum = i*i +j*j;
            if(sum == target){
                System.out.println(i);
                System.out.println(j);
                break;
            }
            else if (sum < target){
                i++;
            }
            else{
                j--;
            }
        }
    }



}
