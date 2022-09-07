package count_inv;

import java.util.HashMap;
import java.util.List;

/**
 * todo Document type InversionCounterDemonstration
 */
public class InversionCounterDemonstration {

    public static void main(String[] args) {
        InversionsCounter counter = new InversionsCounter();

        List<Integer> list = List.of(6,5,4,3);

       HashMap<List<Integer>, Integer> res =  counter.count(list);

        for (Integer i: res.values()) {
            System.out.println(i);
        }
    }

}
