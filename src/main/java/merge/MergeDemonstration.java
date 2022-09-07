package merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * todo Document type MergeDemonstration
 */
public class MergeDemonstration {

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(4));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(2,4,6,8));
        MergeAlg mergeAlg = new MergeAlg();
        List<Integer> res = mergeAlg.iteration(arr1);
        for (Integer i: res) {
            System.out.println(i);
        }
    }

}
