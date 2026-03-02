package ABC_DSA_training;

public class SecondLargestElementInArray {
    public static int findSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        if (secondLargest == Integer.MIN_VALUE) {
            return -1;
        }

        return secondLargest;
    }

    public static void main(String[] args) {
        int[] arr1 = {12, 35, 1, 10, 34, 1};
        System.out.println("The second largest element in arr1 is: " + findSecondLargest(arr1));

        int[] arr2 = {10, 10, 10};
        System.out.println("The second largest element in arr2 is: " + findSecondLargest(arr2));
        
        int[] arr3 = {1, 2, 4, 7, 7, 5};
        System.out.println("The second largest element in arr3 is: " + findSecondLargest(arr3));
    }
}
