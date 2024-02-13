package Homework5;
/**
 *
 * @author emira
 */
public class Soru2_MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        Soru2_MissingNumber missingNumber = new Soru2_MissingNumber();
        int[] nums1 = {3, 0, 1};
        System.out.println("1. Listede Eksik olan Sayı: "+missingNumber.missingNumber(nums1));  // Output: 2

        int[] nums2 = {0,1};
        System.out.println("2. Listede Eksik olan Sayı: "+missingNumber.missingNumber(nums2));  // Output: 2

        int[] nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println("3. Listede Eksik olan Sayı: "+missingNumber.missingNumber(nums3));  // Output: 8
    }
}
