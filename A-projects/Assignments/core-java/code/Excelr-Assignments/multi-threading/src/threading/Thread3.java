package threading;

public class Thread3 extends Thread
{
    public synchronized void run()
    {
        for (int i = 21; i < 31 ; i++)
        {
            System.out.println(Thread.currentThread().getName()  + ": " + i);
        }
    }
}
