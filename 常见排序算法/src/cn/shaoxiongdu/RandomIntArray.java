package cn.shaoxiongdu;

import java.util.Random;

/**
 * ClassName : RandomIntArray
 * (c)CopyRight 2021/4/22 All rights reserved to ShaoxiongDu<shaoxiongdu.dev@gmail.com>
 *     随机数序列类
 */
public class RandomIntArray {

    private int[] numbers;

    /**
     * 生成指定长度,最大max的随机数 数组对象
     * @param arrayLength 数组长度
     * @param max 随机数最大值
     */
    public RandomIntArray(int arrayLength, int max) {
        Random random = new Random();
        int [] numbers = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            numbers[i] = random.nextInt(max);
        }
        this.numbers = numbers;
    }

    /**
     * 无参构造 默认生成10个 最大值为100的随机数序列
     */
    public RandomIntArray() {
        this(10,100);
    }

    /**
     * 迭代打印序列
     */
    public void printArray(){
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "\t");
        }
        System.out.println();
    }

    /**
     * 返回序列
     * @return
     */
    public int[] getNumbers(){
        return numbers;
    }
}
