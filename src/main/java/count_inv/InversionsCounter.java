package count_inv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * todo Document type InversionsCounter
 */
public class InversionsCounter {

    public HashMap<List<Integer>, Integer> count(List<Integer> arr) {

        HashMap<List<Integer>, Integer> res = new HashMap<>();

        if(arr.size() <= 1){

            res.put(arr,0);
            return res;
        }
        List<Integer> left = arr.subList(0, arr.size() / 2);
        List<Integer> right = arr.subList(arr.size() / 2, arr.size());

        HashMap<List<Integer>, Integer>  leftInv = count(left);
        HashMap<List<Integer>, Integer>  rightInv = count(right);

        HashMap<List<Integer>, Integer> splitInv  =
            countSplitInv(leftInv.keySet().stream().toList().get(0),rightInv.keySet().stream().toList().get(0));

        res.put(splitInv.keySet().stream().toList().get(0),leftInv.values().stream().toList().get(0) +
            rightInv.values().stream().toList().get(0) +
            splitInv.values().stream().toList().get(0));

        return res;
    }

    public HashMap<List<Integer>,Integer> countSplitInv(List<Integer> arr1, List<Integer> arr2) {
        ArrayList<Integer> mergedArray = new ArrayList<>();
        int inversions = 0;
        HashMap<List<Integer>, Integer> result = new HashMap<>();
        int arr1Size = arr1.size();
        int arr2Size = arr2.size();
        int i = 0;
        int j = 0;
        for (int k = 0; k < arr1.size() + arr2.size() ; k++) {
            if(i == arr1Size) {
                mergedArray.add(arr2.get(j));
                j++;
                continue;
            }
            if(j == arr2Size) {
                mergedArray.add(arr1.get(i));
                i++;
                continue;
            }
            if(arr1.get(i) < arr2.get(j)) {
                mergedArray.add(arr1.get(i));
                i++;
            } else {
                mergedArray.add(arr2.get(j));
                j++;
                inversions += arr1Size - i;
            }
        }
        result.put(mergedArray, inversions);
        return result;
    }

}
