package data_structure_example;

public class TwoPointer {
    public static boolean findPairWithSum(int[] arr, int targetSum) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int currentSum = arr[left] + arr[right];

            if (currentSum == targetSum) {
                System.out.println("Pair found: (" + arr[left] + ", " + arr[right] + ")");
                return true;
            }

            if (currentSum < targetSum) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println("No pair found");
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 7, 11, 15};
        int targetSum = 9;
        findPairWithSum(arr, targetSum); //Pair found: (2, 7)
    }
}
