package test.algorithm;


/**
 * 滑动窗口
 * @author mal
 * @date 2023-03-01 15:09
 */
public class WindowSlip {

    public static void main(String[] args) {
        WindowSlip windowSlip = new WindowSlip();
        System.out.println(windowSlip.maxSum(new int[]{100, 200, 300, 400}, 2));
    }

    public Integer maxSum(int[] array, int windowSize) {
        if (array.length < windowSize) {
            return -1;
        }

        int maxSum = 0;
        for (int i = 0; i < windowSize; i++) {
            maxSum += array[i];
        }

        int sum = maxSum;
        for (int k = windowSize; k < array.length; k++) {
            sum = sum + array[k] - array[k - windowSize];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
