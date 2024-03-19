package threading;

public class RunningEngine implements Runnable
{
    @Override
    public synchronized void run()
    {
        for (int i = 0; i < 11 ; i++)
        {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
