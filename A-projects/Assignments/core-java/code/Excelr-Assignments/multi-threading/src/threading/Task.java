package threading;

public class Task implements Runnable
{


    public void run()
    {
        System.out.println("This task is completed by " + Thread.currentThread().getName());
    }
}
