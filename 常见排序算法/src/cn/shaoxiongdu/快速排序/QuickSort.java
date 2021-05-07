package cn.shaoxiongdu.快速排序;

import cn.shaoxiongdu.RandomIntArray;

/**
 * ClassName : QuickSort 快速排序
 * (c)CopyRight 2021/5/7 All rights reserved to ShaoxiongDu<shaoxiongdu.dev@gmail.com>
 */
public class QuickSort{

    /**
     * 快速排序
     * @param number 需要排序的序列
     */
    public void sort(int[] number){

        //递归调用快排
        quickSort(number,0, number.length-1);

    }

    /**
     * 递归快速排序
     * @param number 需要排序的数组
     * @param begin 开始部分
     * @param end 结束部分
     */
    public void quickSort(int [] number, int begin, int end){

        //当左右下标重合时，结束递归
        if(begin >= end) return;

        //选出基准数字（第一个）
        int pivot = number[begin];
        //左右双下标
        int left = begin, right = end;

        while (left < right){

            //找出右部分中的第一个小于基准数字的值
            while (left < right && number[right] > pivot){
                right--;
            }
            //到此处时，right处的数字要比基准数字小
            //则将right处的数字放到左边
            if(left < right){
                number[left] = number[right];
                //将左边下标++
                left++;
            }

            //找出左部分中的第一个大于基准数字的值
            while (left < right && number[left] < pivot) {
                left++;
            }
            //到此处时，left处的数字要比基准数字大
            //则将left处的数字放到右边
            if (left < right) {
                number[right] = number[left];
                //将右边下标--
                right--;
            }

        }

        //此时，pivot左半部分的所有数字比pivot小，右边部分所有数字比pivot大
        //将pivot数字放入到左右下标相交的位置
        number[left] = pivot;
        //将pivot左部分序列递归调用进行排序
        quickSort(number, begin, left - 1);
        //将pivot右部分序列递归调用进行排序
        quickSort(number, left + 1, end);

    }

    /**
     * 测试
     * @param args 参数
     */
    public static void main(String[] args) {

        //生成随机数字序列
        RandomIntArray randomIntArray = new RandomIntArray(20,100);
        //输入随机数字序列
        randomIntArray.printArray(); //86	48	39	41	2	97	97	22	77	5	86	66	63	34	59	3	53	87	94	92
        //调用快速排序
        new QuickSort().sort(randomIntArray.getNumbers());
        //测试结果
        randomIntArray.printArray(); //2	3	5	22	34	39	41	48	53	59	63	66	77	86	86	87	92	94	97	97

    }

}
