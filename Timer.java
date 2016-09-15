import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alexandra on 9/13/2016.
 */
public class Timer implements Runnable {

    private static final SortedSet<Task> tasks = new TreeSet<>(new TaskComparator());
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    @Override
    public void run() {
        scheduler.scheduleWithFixedDelay(this::checkTasks, 0, 100, TimeUnit.MILLISECONDS);
    }

    private void checkTasks() {
        synchronized (tasks) {
            if (tasks.isEmpty()) {
                return;
            }
            final long now = System.currentTimeMillis();
            for (Iterator<Task> it = tasks.iterator(); it.hasNext(); ) {
                final Task task = it.next();
                if (task.getTime() <= now) {
                    try {
                        task.getCallable().call();
                        it.remove();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }

    public void addTask(Callable callable, long delay) {
        synchronized (tasks) {
            tasks.add(new Task(System.currentTimeMillis() + delay, callable));
        }
    }
}
