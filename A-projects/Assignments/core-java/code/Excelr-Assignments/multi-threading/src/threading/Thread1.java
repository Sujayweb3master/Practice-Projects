package threading;

public class Thread1 extends Thread
{
    private long time = 0;
    Thread1(long time)
    {
        this.time = time * 1000;
    }

    public void run()
    {
        for (int i = 0; i < 11 ; i++)
        {                                                               //04-03-2024
            try
            {
                System.out.println(this.getName() + " going to sleep for 2 second");
                Thread.sleep(time);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }

    }
}
