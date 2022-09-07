package karatsuba;

/**
 * todo Document type Karatsuba
 */
public class Karatsuba {

    public int iteration(String x, String y) {
        if(x.length() == 1) {
            return Integer.parseInt(x) * Integer.parseInt(y);
        } else {
            String a = x.substring(0, x.length()/2);
            String b = x.substring(x.length()/2);

            String c = y.substring(0, y.length()/2);
            String d = y.substring(y.length()/2);

            int p = Integer.parseInt(a) + Integer.parseInt(b);
            int q = Integer.parseInt(c) + Integer.parseInt(d);

            int ac = iteration(a,c);
            int bd = iteration(b,d);
            int pq = iteration(String.valueOf(p),String.valueOf(q));

            int abcd = pq - ac - bd;
            Double res = Math.pow(10,x.length()) * ac + Math.pow(10, x.length()/2) * abcd + bd;

            return res.intValue();
        }
    }

}
