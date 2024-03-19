package threading;

public class Producer implements Runnable
{
    SharedResource obj;
    Producer (SharedResource obj)
    {
        this.obj = obj;
        Thread t = new Thread(this,"Producer");
        t.start();
    }

    public void run()
    {
        int i = 0;
        while(true)
        {
            obj.set(++i);
            System.out.println("Producer sets num: " + i);
            try{ Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }

        }
    }
}
