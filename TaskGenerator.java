import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Alexandra on 9/13/2016.
 */
public class TaskGenerator implements Runnable {
    private final Timer handler;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

    public TaskGenerator(Timer handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        long delay = generateDelay();
        handler.addTask(() -> {
            System.out.println(dateFormat.format(new Date(delay)));
            return null;
        }, delay);
    }

    private long generateDelay() {
        return new Random().nextInt(60000);
    }
}
