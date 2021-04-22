package cn.shaoxiongdu.冒泡排序;

import cn.shaoxiongdu.RandomIntArray;
import cn.shaoxiongdu.Sortable;

/**
 * ClassName : Pop
 * (c)CopyRight 2021/4/22 All rights reserved to ShaoxiongDu<shaoxiongdu.dev@gmail.com>
 *     冒泡排序
 */
public class PopSort implements Sortable {


    @Override
    public void sort(int[] numbers) {

        for (int i = 0; i < numbers.length - 1; i++) {

            for (int j = 0; j < numbers.length - i - 1; j++) {

               if(numbers[j] > numbers[j+1]){

                   int temp = numbers[j];
                   numbers[j] = numbers[j+1];
                   numbers[j+1] = temp;

               }

            }

        }

    }

    public static void main(String[] args) {

        RandomIntArray randomIntArray = new RandomIntArray(20,100);

        randomIntArray.printArray();

        new PopSort().sort(randomIntArray.getNumbers());

        randomIntArray.printArray();
    }



}
