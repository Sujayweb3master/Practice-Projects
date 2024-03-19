package threadingClasses;

public class Thread1 implements Runnable
{
    @Override
    public void run()
    {
        for (int i = 0; i < 101; i++)
        {
            System.out.println("Thread 1 : " + i);
        }
    }

}
