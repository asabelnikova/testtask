import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);

    public static void main(String[] args) {
        //create object for handle tasks
        final Timer timer = new Timer();
        new Thread(timer).start();

        //start task generators for test
        final Random random = new Random();
        for (int i = 0; i < 10; i++) {
            executor.scheduleAtFixedRate(new TaskGenerator(timer), 0, random.nextInt(10), TimeUnit.MILLISECONDS);
        }
    }

}
