package test.algorithm;

/**
 * 二分法
 * @author mal
 * @date 2023-03-01 16:58
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(new int[]{1}, 1));
    }


    public int search(int[] arr, int value) {
        int left = 0;
        int right = arr.length-1;
        int middle = 0;

        while (left <= right) {
            middle = left + ((right - left) >> 1);
            if (arr[middle] > value) {
                right = middle - 1;
            } else if (arr[middle] < value) {
                left = middle + 1;
            } else if (arr[middle] == value) {
                return middle;
            }
        }
        return -1;
    }
}
