package threading;

public class Consumer implements Runnable
{
    SharedResource obj;
    Consumer (SharedResource obj)
    {
        this.obj = obj;
        Thread t = new Thread(this, "Consumer");
        t.start();
    }

    public void run()
    {
        while(true)
        {
            obj.get();
            try{ Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
