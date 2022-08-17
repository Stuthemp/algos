package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * todo Document type GreedyDif
 */
public class GreedyDiff {

    private ArrayList<DiffJob> jobs;

    public GreedyDiff(ArrayList<DiffJob> jobs) {
        this.jobs = jobs;
    }

    private void createSequence() {
        Collections.sort(jobs);
    }

    public int calculateEfficiency() {
        createSequence();
        int result = 0;
        int currentLength = 0;
        for (DiffJob job: jobs) {
            currentLength += job.getLength();
            result += job.getImportance() * currentLength;
        }
        return result;
    }

    public void addJob(DiffJob job) {
        jobs.add(job);
    }

    public static class DiffJob implements Comparable<DiffJob> {

        int length;
        int importance;

        public DiffJob(int length, int importance) {
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
        public int compareTo(DiffJob o) {
            return (o.importance - o.length) - (this.importance - this.length);
        }
    }
}
