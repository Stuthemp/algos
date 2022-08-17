package greedy;

import java.util.ArrayList;
import java.util.Random;

/**
 * todo Document type greedy.Main
 */
public class GreedyDemonstration {

    public static void main(String[] args) {

        for (int i = 0; i < 50; i++) {

            GreedyDiff greedyDiff = new GreedyDiff(new ArrayList<>());
            GreedyRatio greedyRatio = new GreedyRatio(new ArrayList<>());

            Random rnd = new Random();

            for (int j = 0; j < 10; j++) {
                int length = rnd.nextInt(10) + 1;
                int importance = rnd.nextInt(10) + 1;
                GreedyDiff.DiffJob diffJob = new GreedyDiff.DiffJob(length,importance);
                greedyDiff.addJob(diffJob);

                GreedyRatio.RatioJob ratioJob = new GreedyRatio.RatioJob(length, importance);
                greedyRatio.addJob(ratioJob);
            }

            int greedyDiffResult = greedyDiff.calculateEfficiency();
            System.out.println("Greedy diff result: " + greedyDiffResult);

            int greedyRatioResult = greedyRatio.calculateEfficiency();
            System.out.println("Greedy ratio result: " + greedyRatioResult);

            if(greedyRatioResult < greedyDiffResult) {
                System.out.println("Case " + i + " Ratio won");
            } else if (greedyRatioResult == greedyDiffResult) {
                System.out.println("Tie");
            } else {
                throw new ArithmeticException("Diff cant win");
            }
        }



    }

}
