public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 ={1,3};
        int[] nums2 = {2};
        System.out.println(new Solution3().findMedianSortedArrays(nums1,nums2));
    }
}

class Solution3 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int middle = (nums1.length + nums2.length) / 2;
        if((nums1.length + nums2.length) % 2==0)middle-=1;
        int[] arr = new int[nums1.length + nums2.length];
        if(nums1.length!=0){
            for (int i = 0; i < nums1.length;i++) {
                arr[i] = nums1[i];
            }
        }
        if(nums2.length!=0){
            for (int i = nums1.length; i < nums1.length+nums2.length;i++) {
                arr[i] = nums2[i - nums1.length];
            }
        }
        sortArray(arr);
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (float)(arr[middle] + arr[middle + 1]) / 2;
        } else{
            if(middle<=-1) return arr[0];
            else return arr[middle];
        }
    }
    private void sortArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if(arr[i]>arr[j]){
                    arr[i] = arr[i] + arr[j];
                    arr[j]=arr[i]-arr[j];
                    arr[i]=arr[i]-arr[j];
                }
            }
        }
    }
}
