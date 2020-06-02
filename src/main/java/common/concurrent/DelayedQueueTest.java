package common.concurrent;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class DelayedQueueTest {

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedTask> queue = new DelayQueue<>();

        queue.offer(new DelayedTask("1", 10, TimeUnit.SECONDS));

        DelayedTask task = queue.take();

        System.out.println(task.name());
    }
}
