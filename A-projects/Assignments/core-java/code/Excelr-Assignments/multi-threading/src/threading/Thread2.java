package threading;

public class Thread2 extends Thread
{
    public void run()
    {
        for (int i = 11; i < 16 ; i++)
        {
            System.out.println(Thread.currentThread().getName()  + ": " + i);
            try
            {
                System.out.println(this.getName() + " going to sleep for 10 second");
                sleep(10000);
                System.out.println("sleep end");
            }
            catch(InterruptedException e)
            {
                System.out.println(this.getName() + " got Interrupted!!!! ");
                e.printStackTrace();
            }
            try
            {
                sleep(2000);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
