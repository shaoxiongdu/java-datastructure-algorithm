package cn.shaoxiongdu.归并排序;

import cn.shaoxiongdu.RandomIntArray;

import java.util.Arrays;

/**
 * @author zyc
 * @date 2022/10/8
 */
public class MergeSortt {

    public static void main(String[] args) {
        RandomIntArray in = new RandomIntArray();
        int[] numbers = in.getNumbers();
        MergeSortt.MergeSort(numbers);
        Arrays.stream(numbers).forEach(i -> System.out.print(i + " "));
    }

    /**
     * 二路归并排序
     *
     * @param arr 待排序数组
     */
    public static void MergeSort(int[] arr) {
        int[] work = new int[arr.length];//工作空间数组
        MergeSort(arr, 0, arr.length - 1, work);
    }

    //int[] arr = {2, 4, 7, 1, 6, 9, 0};
    private static void MergeSort(int[] arr, int left, int right, int[] work) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            MergeSort(arr, left, mid, work);
            MergeSort(arr, mid + 1, right, work);
            if (arr[mid] <= arr[mid + 1])//原本就是有序的
                return;
            MergeTwoArr(arr, left, mid, right, work);
        }
    }

    private static void MergeTwoArr(int[] arr, int left, int mid, int right, int[] work) {
        //拷贝原数组到工作数组
        System.arraycopy(arr, left, work, left, right - left + 1);
        int i = left, j = mid + 1, k;
        for (k = i; i <= mid && j <= right; ++k) {
            //进行归并
            if (work[i] <= work[j]) {
                arr[k] = work[i++];
            } else {
                arr[k] = work[j++];
            }
        }
        while (i <= mid)
            arr[k++] = work[i++];
        while (j <= right)
            arr[k++] = work[j++];
    }
}
