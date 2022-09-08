package strassen;

/**
 * todo Document type StrassenDemonstration
 */
public class StrassenDemonstration {

    public static void main(String[] args) {
        int[][] a = new int[][] {{1,2,3,4},
                                 {5,6,7,8},
                                 {9,10,11,12},
                                 {13,14,15,16}};

        Strassen strassen = new Strassen();
        int[][] result = strassen.iteration(a,a);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j]+"|");
            }
            System.out.println();
        }
    }

}
