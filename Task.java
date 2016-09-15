import java.util.concurrent.Callable;

/**
 * Created by Alexandra on 9/13/2016.
 */
public class Task {
    private final long time;
    private final Callable callable;

    public Task(long time, Callable callable) {
        this.time = time;
        this.callable = callable;
    }

    public long getTime() {
        return time;
    }

    public Callable getCallable() {
        return callable;
    }
}
