import java.util.Comparator;

/**
 * Created by Alexandra on 9/14/2016.
 */
public class TaskComparator implements Comparator<Task> {

    @Override
    public int compare(Task o1, Task o2) {
        if (o1 == null || o2 == null) {
            return 0;
        }
        if (o1.getTime() > o2.getTime()) {
            return 1;
        }
        if (o1.getTime() < o2.getTime()) {
            return -1;
        }
        return 0;
    }
}
