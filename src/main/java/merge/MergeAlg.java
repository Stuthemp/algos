package merge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * todo Document type Merge
 */
public class MergeAlg {

    public List<Integer> iteration(List<Integer> arr) {
        if(arr.size() < 2) {
            return arr;
        }
        List<Integer> arr1;
        List<Integer> arr2;
        arr1 = arr.subList(0, arr.size()/2);
        arr2 = arr.subList(arr.size()/2, arr.size());

        arr1 = iteration(arr1);
        arr2 = iteration(arr2);

        return merge(arr1, arr2);
    }

    public List<Integer> merge(List<Integer> arr1, List<Integer> arr2) {
        ArrayList<Integer> result = new ArrayList<>();
        int arr1Size = arr1.size();
        int arr2Size = arr2.size();
        int i = 0;
        int j = 0;
        for (int k = 0; k < arr1.size() + arr2.size(); k++) {
            if(i == arr1Size) {
                result.add(arr2.get(j));
                j++;
                continue;
            }
            if(j == arr2Size) {
                result.add(arr1.get(i));
                i++;
                continue;
            }
            if(arr1.get(i) < arr2.get(j)) {
                result.add(arr1.get(i));
                i++;
            } else {
                result.add(arr2.get(j));
                j++;
            }
        }
        return result;
    }

}
