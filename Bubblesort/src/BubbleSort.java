public class BubbleSort {
    public static void main(String Args[]){
    int nums[] = {8, -5, 3, 2, 1, 0, 45};
        System.out.print("Unsorted nums: ");
        for (int x: nums){
            System.out.print(x+" ");
        }
    int n = nums.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
            if (nums[j] > nums[j+1])
    {
        int temp = nums[j];
        nums[j] = nums[j+1];
        nums[j+1] = temp;
    }
        System.out.print( "\n"+"Sorted nums: ");
        for (int x: nums){
            System.out.print(x+" ");
        }
}
}
