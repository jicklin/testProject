package test;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/5/11
 */
public class TwoTest {

    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static int binary(int arr[], int target) {
        int min = 0;

        int max = arr.length - 1;

        int mind;

        while (min <= max) {
            mind = min + (max - min) / 2;
            if (arr[mind] > target) {
                max = mind - 1;

            } else if (arr[mind] < target) {
                min = mind + 1;
            } else {
                return mind;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        int target = 7;

        System.out.println(binary(arr, target));

    }
}
