package threading;

import java.util.Random;
import java.util.concurrent.Callable;

public class ReturnableTask implements Callable<Integer>
{

    @Override
    public Integer call() throws Exception
    {
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            System.err.println("Thread got interrupted : " + e.getMessage());
        }
        // this task will return random between 0 and 100
        return new Random().nextInt(100);
    }
}
