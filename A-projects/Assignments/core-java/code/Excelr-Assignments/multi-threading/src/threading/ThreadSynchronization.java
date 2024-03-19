package threading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSynchronization
{
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    private boolean conditionMet = false;


    public void waitForCondition() throws InterruptedException {
        lock.lock();
        try
        {
            // loop to check if the condition after waking up
            // to avoid spurious wake-ups
            while(!conditionMet)
                condition.await();
            System.out.println(Thread.currentThread().getName() + " completed the given task");
        }
        finally
        {
            lock.unlock();
        }
    }

    public void signalCondition()
    {
        lock.lock();
        try
        {
            conditionMet = true;
            condition.signalAll();
        }
        finally
        {
            lock.unlock();
        }
    }
}
