package greedy;

/**
 * todo Document type Job
 */
public class Job implements Comparable{

    private int length;
    private int importance;

    public Job(int length, int importance) {
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

    public String showDifference() {
        return "Diff: " + (importance - length);
    }

    public String showRatio() {
        return "Ratio: " + 1.0 * importance/length;
    }

    @Override
    public String toString() {
        return "Importance: " + importance + " Length: " + length;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
