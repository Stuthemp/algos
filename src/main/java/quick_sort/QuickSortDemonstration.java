package quick_sort;

/**
 * todo Document type QuickSortDemonstration
 */
public class QuickSortDemonstration {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[] {5,5,10,4,9,3,8,2,7,1,6};
        int low = 0;
        int high = arr.length - 1;
        int[] res = quickSort.iteration(arr,low,high);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
