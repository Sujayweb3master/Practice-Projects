package threading;

public class SharedResource
{
    int num;
    boolean numSet = false;

    public synchronized void set(int num)
    {
        while(numSet)
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        this.num = num;
        numSet = true;
        notify();
    }

    public synchronized void get()
    {
        while(!numSet)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("Consumer gets num: " + num);
        numSet = false;
        notify();
    }
}
