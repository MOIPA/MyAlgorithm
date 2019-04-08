public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(new Solution3().findMedianSortedArrays(nums1, nums2));
        //快排测试
        int[] testNum = {6, 5, 4, 3, 10, 2, 7};
        new Solution3().doQuickSort(testNum, 0, testNum.length - 1);
        for (int i : testNum) {
            System.out.print(i + " ");
        }
    }
}

class Solution3 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int middle = (nums1.length + nums2.length) / 2;
        if ((nums1.length + nums2.length) % 2 == 0) middle -= 1;
        int[] arr = new int[nums1.length + nums2.length];
        if (nums1.length != 0) {
            for (int i = 0; i < nums1.length; i++) {
                arr[i] = nums1[i];
            }
        }
        if (nums2.length != 0) {
            for (int i = nums1.length; i < nums1.length + nums2.length; i++) {
                arr[i] = nums2[i - nums1.length];
            }
        }
        doQuickSort(arr,0,arr.length-1);
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (float) (arr[middle] + arr[middle + 1]) / 2;
        } else {
            if (middle <= -1) return arr[0];
            else return arr[middle];
        }
    }

    private void sortArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    arr[i] = arr[i] + arr[j];
                    arr[j] = arr[i] - arr[j];
                    arr[i] = arr[i] - arr[j];
                }
            }
        }
    }

    private void quickSort(int[] arr) {

    }

    public void doQuickSort(int[] arr, int left, int right) {

        //结束条件
        if (left >= right || left >= arr.length || right <= -1) return;

        //记录当前的LR，用于之后递归
        int recordL = left, recordRight = right;
        //LR循环走  参照值为第一个数
        while (left <= right) {

            //找到第一个比参照物小的数用于放左边
            while (arr[right] > arr[recordL]) {
                if (recordL >= right) break;
                right--;
            }

            //找到第一个比参照物大的数用于放右边
            while (arr[left] < arr[recordL]) {
                if (left >= right) break;
                left++;
            }
            //交换左边大的和右边小的
            if (left < right) {
                swap(arr, left, right);
                continue;
            }

            swap(arr, recordL, right);
            doQuickSort(arr, recordL, right - 1);
            doQuickSort(arr, right + 1, recordRight);

            left++;
            right--;
        }

    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
