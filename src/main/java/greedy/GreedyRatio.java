package greedy;

import java.util.ArrayList;
import java.util.Collections;

/**
 * todo Document type GreedyRatio
 */
public class GreedyRatio {

    private ArrayList<RatioJob> jobs;

    public GreedyRatio(ArrayList<RatioJob> jobs) {
        this.jobs = jobs;
    }


    private void createSequence() {
        Collections.sort(jobs);
    }

    public int calculateEfficiency() {
        createSequence();
        int result = 0;
        int currentLength = 0;
        for (RatioJob job: jobs) {
            currentLength += job.getLength();
            result += job.getImportance() * currentLength;
        }
        return result;
    }

    public void addJob(RatioJob job) {
        jobs.add(job);
    }

    public static class RatioJob implements Comparable<RatioJob> {

        int length;
        int importance;

        public RatioJob(int length, int importance) {
            this.length = length;
            this.importance = importance;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getImportance() {
            return importance;
        }

        public void setImportance(int importance) {
            this.importance = importance;
        }

        @Override
        public int compareTo(RatioJob o) {
            if( (this.importance * 1.0 / this.length) - (o.importance * 1.0 / o.length) > 0) {
                return -1;
            } else if ((this.importance * 1.0 / this.length) - (o.importance * 1.0 / o.length) < 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
