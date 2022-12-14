package quick_sort;

/**
 * low нижняя граница подмассива, в котором надо отсортировать элементы вокруг опрного
 * high верхняя граница подмассива, в котором надо отсортировать элементы вокруг опрного
 */
public class QuickSort {

    public int[] iteration(int[] arr, int low, int high) {
       if(arr.length == 0)
           return arr;
       if(low >= high)
           return arr;

        int middle = low + (high - low) / 2;
        int opora = arr[middle];

        int i = low, j = high;

        while (i <= j) {
            while (arr[i] < opora) {
                i++;
            }

            while (arr[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            iteration(arr, low, j);

        if (high > i)
            iteration(arr, i, high);

        return arr;

    }


}
