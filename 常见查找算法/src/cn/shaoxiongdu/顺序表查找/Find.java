package cn.shaoxiongdu.顺序表查找;

import cn.shaoxiongdu.RandomIntArray;

import java.util.Arrays;

/**
 * ClassName : Find
 * (c)CopyRight 2021/5/7 All rights reserved to ShaoxiongDu<shaoxiongdu.dev@gmail.com>
 */
public class Find {

    /**
     * 顺序表查找
     * @param number 待查找的序列
     * @param target 目标数字
     * @return 返回目标数字的下标 若不存在 则返回-1
     */
    public static int find(int [] number, int target){

        for (int i = 0; i < number.length; i++) {

            if(target == number[i]){
                return i;
            }

        }
        return -1;

    }

    public static void main(String[] args) {

        RandomIntArray randomIntArray = new RandomIntArray(30, 10);
        int [] number = randomIntArray.getNumbers();
        System.out.println("序列为\n");
        randomIntArray.printArray();

        int target = 5;

        System.out.println("数字" + target + "所在下标为" + find(number, target));

    }

}
