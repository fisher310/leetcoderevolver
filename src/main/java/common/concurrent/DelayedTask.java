package common.concurrent;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedTask implements Delayed {

    private long delayed;
    private String name;



    public DelayedTask(String name, long delayed, TimeUnit unit) {
        this.name = name;
        this.delayed = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delayed, unit);
    }

    public String name() {
        return name;
    }
    @Override
    public long getDelay(TimeUnit unit) {
        long now = System.nanoTime();
        return unit.convert( delayed - now, TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(this.getDelay(TimeUnit.NANOSECONDS), o.getDelay(TimeUnit.NANOSECONDS));
    }
}
